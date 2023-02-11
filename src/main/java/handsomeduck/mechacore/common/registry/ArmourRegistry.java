package handsomeduck.mechacore.common.registry;

import handsomeduck.mechacore.common.MechaCore;
import handsomeduck.mechacore.common.item.ElectricalArmourItem;
import handsomeduck.mechacore.common.item.TitaniumMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static handsomeduck.mechacore.common.registry.ObjectRegistry.mech_clutter;

public class ArmourRegistry {
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();
    public static final ArmorMaterial TITANIUM_MATERIAL = new TitaniumMaterial();

    public static final Item HELM = create("helm", new ElectricalArmourItem(TITANIUM_MATERIAL, EquipmentSlot.HEAD, gen()));
    public static final Item CHEST = create("chest", new ElectricalArmourItem(TITANIUM_MATERIAL, EquipmentSlot.CHEST, gen()));
    public static final Item PANT = create("pant", new ElectricalArmourItem(TITANIUM_MATERIAL, EquipmentSlot.LEGS, gen()));
    public static final Item BOOT = create("boot", new ElectricalArmourItem(TITANIUM_MATERIAL, EquipmentSlot.FEET, gen()));

    // Methods
    private static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, new Identifier(MechaCore.MOD_ID, name));
        return item;
    }

    private static Item.Settings gen() {
        return new Item.Settings().group(mech_clutter);
    }

    public static void init() {
        MechaCore.LOGGER.info("Registering Mod Armour for " + MechaCore.MOD_ID);
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
    }
}
