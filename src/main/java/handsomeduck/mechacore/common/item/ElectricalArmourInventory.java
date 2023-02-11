package handsomeduck.mechacore.common.item;

import handsomeduck.mechacore.common.util.ImplementedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.collection.DefaultedList;

public class ElectricalArmourInventory implements ImplementedInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public ElectricalArmourInventory(ElectricalArmourItem electricalArmourItem) {
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    public NbtList writeNbt(NbtList nbtList) {
        int i;
        NbtCompound nbtCompound;
        for(i = 0; i < this.size(); ++i) {
            if (!((ItemStack)this.getStack(i)).isEmpty()) {
                nbtCompound = new NbtCompound();
                nbtCompound.putByte("Slot", (byte)i);
                ((ItemStack)this.getStack(i)).writeNbt(nbtCompound);
                nbtList.add(nbtCompound);
            }
        }

        return nbtList;
    }

    public void readNbt(NbtList nbtList) {

        for(int i = 0; i < nbtList.size(); ++i) {
            NbtCompound nbtCompound = nbtList.getCompound(i);
            int j = nbtCompound.getByte("Slot") & 255;
            ItemStack itemStack = ItemStack.fromNbt(nbtCompound);
            if (!itemStack.isEmpty()) {
                if (j >= 0 && j < this.size()) {
                    this.setStack(j, itemStack);
                }
            }
        }

    }
}
