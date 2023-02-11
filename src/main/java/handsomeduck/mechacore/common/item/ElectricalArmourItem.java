package handsomeduck.mechacore.common.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class ElectricalArmourItem extends ArmorItem{
    private final ElectricalArmourInventory inventory = new ElectricalArmourInventory(this);

    public ElectricalArmourItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }
}
