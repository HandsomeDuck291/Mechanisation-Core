package handsomeduck.herebedragons.common.registry;

import handsomeduck.herebedragons.HereBeDragons;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {
    public static <B extends Block> B registerBlock(String name, B block) {
        return Registry.register(Registry.BLOCK, new Identifier(HereBeDragons.MOD_ID, name), block);
    }

    //public static final Block RUBY_ORE = registerBlock("ruby_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()));

    public static void registerModBlocks(){ HereBeDragons.LOGGER.info("Registering Mod Blocks for " + HereBeDragons.MOD_ID);
    }
}
