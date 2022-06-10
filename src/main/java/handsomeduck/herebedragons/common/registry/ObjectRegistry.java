package handsomeduck.herebedragons.common.registry;

import handsomeduck.herebedragons.HereBeDragons;
import handsomeduck.herebedragons.common.item.EggItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class ObjectRegistry {
    private static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    // Item Tabs
    public static final ItemGroup dragon_stuff = FabricItemGroupBuilder
            .create(new Identifier(HereBeDragons.MOD_ID, "dragon_stuff"))
            .icon(() -> new ItemStack(ObjectRegistry.DRAGON_ICON)).build();

    // Tab Icons
    public static final Item DRAGON_ICON = create( "dragon_icon",
            new Item(new Item.Settings()));

    // Blocks


    // Items
    public static final Item FIREEGG = create( "fire_egg",
            new EggItem(dra().maxCount(1), EntityRegistry.FIRE_DRAGON_EGG));
    public static final Item WATEREGG = create( "water_egg",
            new EggItem(dra().maxCount(1), EntityRegistry.WATER_DRAGON_EGG));

    // Functions
    private static <T extends Block> T create(String name, T block, boolean createItem, boolean dragonTab) {
        BLOCKS.put(block, new Identifier(HereBeDragons.MOD_ID, name));
        if (createItem) {
            if (dragonTab) {
                ITEMS.put(new BlockItem(block, dra()), BLOCKS.get(block));
            }
        }
        return block;
    }

    private static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, new Identifier(HereBeDragons.MOD_ID, name));
        return item;
    }

    private static Item.Settings dra() {
        return new Item.Settings().group(dragon_stuff);
    }

    public static void init() {
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
        BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
    }

    // Logger
    public static void registerModItems(){
        HereBeDragons.LOGGER.info("Registering Mod Items for " + HereBeDragons.MOD_ID);
    }
}
