package handsomeduck.starktech.client.screen;

import handsomeduck.starktech.common.registry.ScreenRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class SuitConstructorHandler extends ScreenHandler {
    private final Inventory inventory;

    public SuitConstructorHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(4));
    }

    public SuitConstructorHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenRegistry.SUIT_CONSTRUCTOR_HANDLER, syncId);
        checkSize(inventory, 4);
        this.inventory = inventory;
        //some inventories do custom logic when a player opens it.
        inventory.onOpen(playerInventory.player);

        this.addSlot(new ArmourSlot(inventory, 0, 13, 6, EquipmentSlot.HEAD));
        this.addSlot(new ArmourSlot(inventory, 1, 13, 24, EquipmentSlot.CHEST));
        this.addSlot(new ArmourSlot(inventory, 2, 13, 42, EquipmentSlot.LEGS));
        this.addSlot(new ArmourSlot(inventory, 3, 13, 60, EquipmentSlot.FEET));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    // Shift + Player Inv Slot
    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
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

    private void addPlayerInventory(PlayerInventory playerInventory) {
        int i;
        for (i = 0; i < 3; ++i) {
            int l;
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        int i;
        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }

    private class ArmourSlot extends Slot {
        private final EquipmentSlot type;

        public ArmourSlot(Inventory inventory, int index, int x, int y, EquipmentSlot type) {
            super(inventory, index, x, y);
            this.type = type;
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return (stack.getItem() instanceof ArmorItem armorItem) && (armorItem.getSlotType() == type);
        }
    }
}
