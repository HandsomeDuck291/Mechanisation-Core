package handsomeduck.starktech.common.registry;

import handsomeduck.starktech.common.StarkTech;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class EntityRegistry {
    private static final Map<EntityType<?>, Identifier> ENTITY_TYPES = new LinkedHashMap<>();



    private static <T extends LivingEntity> EntityType<T> create(String name, DefaultAttributeContainer.Builder attributes, EntityType<T> type) {
        FabricDefaultAttributeRegistry.register(type, attributes);
        ENTITY_TYPES.put(type, new Identifier(StarkTech.MOD_ID, name));
        return type;
    }

    private static <T extends Entity> EntityType<T> create(String name, EntityType<T> type) {
        ENTITY_TYPES.put(type, new Identifier(StarkTech.MOD_ID, name));
        return type;
    }

    public static void init() {
        StarkTech.LOGGER.info("Registering Mod Entities for " + StarkTech.MOD_ID);
        ENTITY_TYPES.keySet().forEach(entityType -> Registry.register(Registry.ENTITY_TYPE, ENTITY_TYPES.get(entityType), entityType));
    }
}
