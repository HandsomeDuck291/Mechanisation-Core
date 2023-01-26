package handsomeduck.mechacore.api;

import handsomeduck.mechacore.common.registry.ObjectRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.List;
import java.util.function.Consumer;

public class MechaCoreRecipeGenerator extends FabricRecipeProvider {
    public MechaCoreRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        // Shapeless


        // Compacting
        offerReversibleCompactingRecipes(exporter, ObjectRegistry.PALLADIUM_INGOT, ObjectRegistry.PALLADIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, ObjectRegistry.RAW_PALLADIUM, ObjectRegistry.RAW_PALLADIUM_BLOCK);

        // Smelting
        offerSmelting(exporter, List.of(ObjectRegistry.PALLADIUM_ORE), ObjectRegistry.PALLADIUM_INGOT, 0.7F, 200, "palladium");
        offerBlasting(exporter, List.of(ObjectRegistry.PALLADIUM_ORE), ObjectRegistry.PALLADIUM_INGOT, 0.7F, 100, "palladium");
        offerSmelting(exporter, List.of(ObjectRegistry.DEEPSLATE_PALLADIUM_ORE), ObjectRegistry.PALLADIUM_INGOT, 0.7F, 200, "palladium");
        offerBlasting(exporter, List.of(ObjectRegistry.DEEPSLATE_PALLADIUM_ORE), ObjectRegistry.PALLADIUM_INGOT, 0.7F, 100, "palladium");
        offerSmelting(exporter, List.of(ObjectRegistry.RAW_PALLADIUM), ObjectRegistry.PALLADIUM_INGOT, 0.7F, 200, "palladium");
        offerBlasting(exporter, List.of(ObjectRegistry.RAW_PALLADIUM), ObjectRegistry.PALLADIUM_INGOT, 0.7F, 100, "palladium");
    }
}
