package handsomeduck.starktech.api;

import handsomeduck.starktech.common.registry.ObjectRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Util;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.function.Consumer;

public class IronRecipeGenerator extends FabricRecipeProvider {
    IronRecipeGenerator(FabricDataGenerator generator) {
        super(generator);
    }

    public static final List<ItemConvertible> SMELTABLE_TO_PALLADIUM_INGOT = Util.make(Lists.newArrayList(), list -> {
        list.add(ObjectRegistry.PALLADIUM_ORE);
        list.add(ObjectRegistry.DEEPSLATE_PALLADIUM_ORE);
        list.add(ObjectRegistry.RAW_PALLADIUM);
    });

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        // Shapeless
        ShapelessRecipeJsonBuilder.create(ObjectRegistry.PALLADIUM_BLOCK).input(ObjectRegistry.PALLADIUM_INGOT).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(ObjectRegistry.RAW_PALLADIUM_BLOCK).input(ObjectRegistry.RAW_PALLADIUM).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(ObjectRegistry.RAW_PALLADIUM, 9).input(ObjectRegistry.RAW_PALLADIUM_BLOCK, 1).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(ObjectRegistry.PALLADIUM_INGOT, 9).input(ObjectRegistry.PALLADIUM_BLOCK, 1).offerTo(exporter);

        // Smelting
        RecipeProvider.offerSmelting(exporter, SMELTABLE_TO_PALLADIUM_INGOT, ObjectRegistry.PALLADIUM_INGOT, 0.7F, 200, "palladium");
        RecipeProvider.offerBlasting(exporter, SMELTABLE_TO_PALLADIUM_INGOT, ObjectRegistry.PALLADIUM_INGOT, 0.7F, 100, "palladium");
    }
}
