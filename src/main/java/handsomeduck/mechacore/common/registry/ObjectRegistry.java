package handsomeduck.mechacore.common.registry;

import handsomeduck.mechacore.common.MechaCore;
import handsomeduck.mechacore.common.block.ModuleTable;
import handsomeduck.mechacore.common.block.ModuleTableEntity;
import handsomeduck.mechacore.common.block.SuitConstructor;
import handsomeduck.mechacore.common.block.SuitConstructorEntity;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class ObjectRegistry {
    private static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    // Item Tabs
    public static final ItemGroup mech_clutter = FabricItemGroupBuilder
            .create(new Identifier(MechaCore.MOD_ID, "mecha_clutter"))
            .icon(() -> new ItemStack(ObjectRegistry.PALLADIUM_BLOCK)).build();

    // Blocks
    public static final SuitConstructor CONSTRUCTOR = create("suit_constructor", new SuitConstructor(FabricBlockSettings.of(Material.STONE).strength(4.0f).nonOpaque()), true);
    public static final ModuleTable MODULE_TABLE = create("module_table", new ModuleTable(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().nonOpaque()), true);
    // Palladium Blocks
    public static final Block PALLADIUM_ORE = create("palladium_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), true);
    public static final Block DEEPSLATE_PALLADIUM_ORE = create("deepslate_palladium_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(6.0f).requiresTool()), true);
    public static final Block RAW_PALLADIUM_BLOCK = create("raw_palladium_block", new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), true);
    public static final Block PALLADIUM_BLOCK = create("palladium_block", new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), true);

    // Items
    public static final Item PALLADIUM_INGOT = create("palladium_ingot", new Item(gen()));
    public static final Item RAW_PALLADIUM = create("raw_palladium", new Item(gen()));

    // Block Entity
    public static final BlockEntityType<SuitConstructorEntity> SUIT_CONSTRUCTOR_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE, new Identifier(MechaCore.MOD_ID, "suit_constructor"),
            FabricBlockEntityTypeBuilder.create(SuitConstructorEntity::new, CONSTRUCTOR).build(null));
    public static final BlockEntityType<ModuleTableEntity> MODULE_TABLE_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE, new Identifier(MechaCore.MOD_ID, "module_table"),
            FabricBlockEntityTypeBuilder.create(ModuleTableEntity::new, MODULE_TABLE).build(null));

    // Functions
    private static <T extends Block> T create(String name, T block, boolean createItem) {
        BLOCKS.put(block, new Identifier(MechaCore.MOD_ID, name));
        if (createItem) {
            ITEMS.put(new BlockItem(block, gen()), BLOCKS.get(block));
        }
        return block;
    }

    private static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, new Identifier(MechaCore.MOD_ID, name));
        return item;
    }

    private static Item.Settings gen() {
        return new Item.Settings().group(mech_clutter);
    }

    public static void init() {
        MechaCore.LOGGER.info("Registering Mod Items for " + MechaCore.MOD_ID);
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
        BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
    }
}
