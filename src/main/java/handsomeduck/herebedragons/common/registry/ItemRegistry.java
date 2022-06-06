package handsomeduck.herebedragons.common.registry;

import handsomeduck.herebedragons.HereBeDragons;
import handsomeduck.herebedragons.common.item.EggItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemRegistry {
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    // Item Tabs
    public static final ItemGroup dragon_stuff = FabricItemGroupBuilder
            .create(new Identifier(HereBeDragons.MOD_ID, "dragon_stuff"))
            .icon(() -> new ItemStack(ItemRegistry.DRAGON_ICON)).build();

    // Tab Icons
    public static final Item DRAGON_ICON = create( "dragon_icon",
            new Item(new Item.Settings()));

    // Items
    public static final Item FIREEGG = create( "fire_egg",
            new EggItem(dra().maxCount(1), EntityRegistry.FIREDRAGONEGG));
    public static final Item WATEREGG = create( "water_egg",
            new EggItem(dra().maxCount(1), EntityRegistry.WATERDRAGONEGG));

    // Functions
    private static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, new Identifier(HereBeDragons.MOD_ID, name));
        return item;
    }

    private static Item.Settings dra() {
        return new Item.Settings().group(dragon_stuff);
    }

    // Logger
    public static void registerModItems(){
        HereBeDragons.LOGGER.info("Registering Mod Items for " + HereBeDragons.MOD_ID);
    }
}
