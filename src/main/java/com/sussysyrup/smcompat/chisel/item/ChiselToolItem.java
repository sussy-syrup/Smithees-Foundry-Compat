package com.sussysyrup.smcompat.chisel.item;

/**
 * LICENSED UNDER GNUv2
 * Modifies Chisel's copies and modifies chisel's item code to be usable with the added chisels. Unfortunately this cannot use extend
 */

import com.matthewperiut.chisel.Chisel;
import com.matthewperiut.chisel.inventory.InventoryNbtUtil;
import com.matthewperiut.chisel.item.ChiselItem;
import com.sussysyrup.smcompat.chisel.gui.CChiselScreenHandler;
import com.sussysyrup.smitheesfoundry.api.item.ToolItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.BundleTooltipData;
import net.minecraft.client.item.TooltipData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;
import java.util.stream.Stream;

public class ChiselToolItem extends ToolItem implements NamedScreenHandlerFactory {

    private static final String ITEMS_KEY = "Items";

    public ChiselToolItem(Settings settings, String toolType, TagKey<Block> effectiveBlocks) {
        super(settings, toolType, effectiveBlocks);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            user.openHandledScreen(this);
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        NbtCompound nbt = player.getItemsHand().iterator().next().getOrCreateNbt();
        Inventory chiselInv = InventoryNbtUtil.createInventory(nbt);
        return new CChiselScreenHandler(syncId, inv, chiselInv, nbt);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        return Chisel.ITEM_CHISEL.useOnBlock(context);
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return Chisel.ITEM_CHISEL.canMine(state, world, pos, miner);
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return Chisel.ITEM_CHISEL.getMiningSpeedMultiplier(stack, state);
    }

    public Text getDisplayName() {
        return ((ChiselItem) Chisel.ITEM_CHISEL).getDisplayName();
    }

    private static int getItemOccupancy(ItemStack stack) {
        NbtCompound nbtCompound;
        if (stack.isOf(Items.BUNDLE)) {
            return 4 + getBundleOccupancy(stack);
        }
        if ((stack.isOf(Items.BEEHIVE) || stack.isOf(Items.BEE_NEST)) && stack.hasNbt() && (nbtCompound = BlockItem.getBlockEntityNbt(stack)) != null && !nbtCompound.getList("Bees", 10).isEmpty()) {
            return 64;
        }
        return 64 / stack.getMaxCount();
    }

    private static int getBundleOccupancy(ItemStack stack) {
        return getBundledStacks(stack).mapToInt(itemStack -> getItemOccupancy(itemStack) * itemStack.getCount()).sum();
    }

    private static Stream<ItemStack> getBundledStacks(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound == null) {
            return Stream.empty();
        }
        NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
        return nbtList.stream().map(NbtCompound.class::cast).map(ItemStack::fromNbt);
    }

    @Override
    public Optional<TooltipData> getTooltipData(ItemStack stack) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.of();
        getBundledStacks(stack).forEach(defaultedList::add);
        return Optional.of(new BundleTooltipData(defaultedList, getBundleOccupancy(stack)));
    }
}
