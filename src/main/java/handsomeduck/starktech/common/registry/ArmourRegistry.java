package handsomeduck.starktech.common.registry;

import handsomeduck.starktech.common.StarkTech;
import handsomeduck.starktech.common.item.ArcReactor;
import handsomeduck.starktech.common.item.PalladiumMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static handsomeduck.starktech.common.registry.ObjectRegistry.stark_clutter;

public class ArmourRegistry {
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();
    public static final ArmorMaterial PALLADIUM_MATERIAL = new PalladiumMaterial();

    public static final ArcReactor ARC1 = create( "arc1", new ArcReactor(PALLADIUM_MATERIAL, EquipmentSlot.CHEST, gen()));

    // Functions
    private static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, new Identifier(StarkTech.MOD_ID, name));
        return item;
    }

    private static Item.Settings gen() {
        return new Item.Settings().group(stark_clutter);
    }

    public static void init() {
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
    }

    // Logger
    public static void registerModArmour(){
        StarkTech.LOGGER.info("Registering Mod Armour for " + StarkTech.MOD_ID);
    }
}
