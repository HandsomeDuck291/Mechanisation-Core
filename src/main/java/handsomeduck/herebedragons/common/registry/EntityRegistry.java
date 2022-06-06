package handsomeduck.herebedragons.common.registry;

import handsomeduck.herebedragons.HereBeDragons;
import handsomeduck.herebedragons.common.entity.FireDragonEggEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class EntityRegistry {
    private static final Map<EntityType<?>, Identifier> ENTITY_TYPES = new LinkedHashMap<>();

    public static final EntityType<FireDragonEggEntity> FIREDRAGONEGG = create("fire_dragon_egg",
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, FireDragonEggEntity::new).dimensions(EntityType.ARROW.getDimensions()).fireImmune().build());
    public static final EntityType<FireDragonEggEntity> WATERDRAGONEGG = create("water_dragon_egg",
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, FireDragonEggEntity::new).dimensions(FIREDRAGONEGG.getDimensions()).fireImmune().build());



    private static <T extends LivingEntity> EntityType<T> create(String name, DefaultAttributeContainer.Builder attributes, EntityType<T> type) {
        FabricDefaultAttributeRegistry.register(type, attributes);
        ENTITY_TYPES.put(type, new Identifier(HereBeDragons.MOD_ID, name));
        return type;
    }

    private static <T extends Entity> EntityType<T> create(String name, EntityType<T> type) {
        ENTITY_TYPES.put(type, new Identifier(HereBeDragons.MOD_ID, name));
        return type;
    }

    public static void registerModEntities(){ HereBeDragons.LOGGER.info("Registering Mod Entities for " + HereBeDragons.MOD_ID);
    }
}
