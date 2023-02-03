package handsomeduck.mechacore.common.registry;

import handsomeduck.mechacore.common.MechaCore;
import handsomeduck.mechacore.mixin.OrePlacedFeaturesAccessor;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

import java.util.List;

public class WorldGeneration {

    public static final List<OreFeatureConfig.Target> PALLADIUM_ORES = List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ObjectRegistry.PALLADIUM_ORE.getDefaultState()), OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ObjectRegistry.DEEPSLATE_PALLADIUM_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> PALLADIUM_ORE = ConfiguredFeatures.register("mechacore:palladium_ore", Feature.ORE, new OreFeatureConfig(PALLADIUM_ORES, 10));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> PALLADIUM_ORE_BURIED = ConfiguredFeatures.register("mechacore:palladium_ore_buried", Feature.ORE, new OreFeatureConfig(PALLADIUM_ORES, 10));

    public static final RegistryEntry<PlacedFeature> PALLADIUM_ORE_UPPER = PlacedFeatures.register("mechacore:palladium_ore_buried", PALLADIUM_ORE_BURIED, OrePlacedFeaturesAccessor.callModifiersWithCount(4, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(32))));
    public static final RegistryEntry<PlacedFeature> PALLADIUM_ORE_LOWER = PlacedFeatures.register("mechacore:palladium_ore_lower", PALLADIUM_ORE_BURIED, OrePlacedFeaturesAccessor.callModifiers(CountPlacementModifier.of(UniformIntProvider.create(0, 1)), HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-48))));

    public static void init() {
        BiomeModification worldGen = BiomeModifications.create(new Identifier(MechaCore.MOD_ID, "world_features"));
        worldGen.add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), context -> {
            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, PALLADIUM_ORE_UPPER.value());
            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, PALLADIUM_ORE_LOWER.value());
        });
    }
}
