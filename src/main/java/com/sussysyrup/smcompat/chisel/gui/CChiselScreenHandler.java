package com.sussysyrup.smcompat.chisel.gui;

/**
 * LICENSED UNDER GNUv2
 * Copies and Modifies Chisel's Screen Handler for the chisel to fix bugs when applied to the generated chisels. Unfortunately this cannot use extend
 */
import com.matthewperiut.chisel.inventory.ChiselInventory;
import com.matthewperiut.chisel.inventory.InventoryNbtUtil;
import com.matthewperiut.chisel.item.ChiselItem;
import com.sussysyrup.smcompat.chisel.item.ChiselToolItem;
import com.sussysyrup.smcompat.chisel.registry.CScreenRegistry;
import com.sussysyrup.smitheesfoundry.registry.ItemsRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.registry.Registry;

public class CChiselScreenHandler extends ScreenHandler {
    private final ChiselInventory inventory;

    public CChiselScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new ChiselInventory());
    }

    public CChiselScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        this(syncId, playerInventory, inventory, new NbtCompound());
    }

    public CChiselScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, NbtCompound compound) {
        super(CScreenRegistry.CHISEL_SCREEN_HANDLER, syncId);
        checkSize(inventory, 61);
        this.inventory = (ChiselInventory) inventory;

        this.addSlot(new Slot(inventory, 0, 8, 145));

        int x;
        int y;
        for (x = 0; x < 10; ++x) {
            for (y = 0; y < 6; ++y) {
                this.addSlot(new SlotChiselOutput(inventory, 1 + x + 10 * y, 62 + 18 * x - 54, 8 + 18 * y + 7));
            }
        }

        for (x = 0; x < 9; ++x) {
            for (y = 0; y < 3; ++y) {
                this.addSlot(new Slot(playerInventory, 9 + x + 9 * y, 71 + 18 * x - 45, 120 + 18 * y + 7));
            }
        }

        for (x = 0; x < 9; ++x) {
            this.addSlot(new Slot(playerInventory, x, 71 + 18 * x - 45, 185));
        }
    }

    public boolean canUse(PlayerEntity player) {
        return true;
    }

    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (originalStack.getItem().equals(ItemsRegistry.FORGE_CHISEL)) {
                return ItemStack.EMPTY;
            }

            if (invSlot < this.inventory.size()) {
                if (invSlot != 0) {
                    originalStack.setCount((this.slots.get(0)).getStack().getCount());
                    ChiselItem.chiselSound(player.world, Registry.BLOCK.get(Registry.ITEM.getId(originalStack.getItem())), player.getBlockPos());
                }

                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    this.inventory.refresh((this.slots.get(0)).getStack().getItem());
                    return ItemStack.EMPTY;
                }

                this.inventory.clear();
            } else if (!this.insertItem(originalStack, 0, 1, false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    public void close(PlayerEntity player) {
        super.close(player);
        ItemStack hand = player.getItemsHand().iterator().next();
        if (!hand.isOf(ItemsRegistry.FORGE_CHISEL)) {
            ItemStack itemStack = ItemStack.EMPTY;

            for (int i = 0; i < player.getInventory().size(); ++i) {
                if (player.getInventory().getStack(i).isOf(ItemsRegistry.FORGE_CHISEL)) {
                    itemStack = player.getInventory().getStack(i);
                    player.getInventory().removeStack(i);
                }
            }

            player.getInventory().setStack(0, itemStack);
        }

        hand.getOrCreateNbt().copyFrom(InventoryNbtUtil.createCompound(this.inventory));
    }

    public void onSlotClick(int i, int j, SlotActionType actionType, PlayerEntity playerEntity) {
        if (i >= 0 && i < this.slots.size()) {
            Slot slot = this.slots.get(i);
            if (slot != null && slot.getStack().getItem() instanceof ChiselToolItem) {
                return;
            }
        }

        super.onSlotClick(i, j, actionType, playerEntity);
    }

    private class SlotChiselOutput extends Slot {
        public SlotChiselOutput(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        public void onTakeItem(PlayerEntity player, ItemStack stack) {
            this.inventory.clear();
            super.onTakeItem(player, stack);
        }

        public boolean canInsert(ItemStack stack) {
            return false;
        }

        public int getMaxItemCount() {
            return 1;
        }
    }
}
