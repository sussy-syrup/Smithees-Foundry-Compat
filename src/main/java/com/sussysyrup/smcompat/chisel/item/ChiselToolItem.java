package com.sussysyrup.smcompat.chisel.item;

/**
 * LICENSED UNDER GNUv2
 */

import com.matthewperiut.chisel.Chisel;
import com.matthewperiut.chisel.item.ChiselItem;
import com.sussysyrup.smitheesfoundry.api.item.ToolItem;
import com.sussysyrup.smitheesfoundry.registry.ItemsRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.*;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChiselToolItem extends ToolItem implements NamedScreenHandlerFactory {

    public ChiselToolItem(Settings settings, String toolType, TagKey<Block> effectiveBlocks) {
        super(settings, toolType, effectiveBlocks);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient && ((ItemStack)user.getItemsHand().iterator().next()).isOf(ItemsRegistry.FORGE_CHISEL)) {
            user.openHandledScreen(this);
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return ((ChiselItem) Chisel.ITEM_CHISEL).createMenu(syncId, inv, player);
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

    @Override
    public boolean isSuitableFor(ItemStack stack, BlockState state) {
        return false;
    }
}
