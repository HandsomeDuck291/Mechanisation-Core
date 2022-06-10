package handsomeduck.herebedragons;

import handsomeduck.herebedragons.api.client.renderer.DragonEggRenderer;
import handsomeduck.herebedragons.client.renderer.FireDragonEggRenderer;
import handsomeduck.herebedragons.client.renderer.WaterDragonEggRenderer;
import handsomeduck.herebedragons.common.registry.EntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@SuppressWarnings({"unchecked", "ConstantConditions"})
@Environment(EnvType.CLIENT)
public class DragonClient implements ClientModInitializer {
    public static final EntityModelLayer EGG_MODEL_LAYER = new EntityModelLayer(new Identifier(HereBeDragons.MOD_ID, "egg"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityRegistry.DRAGON_EGG, DragonEggRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.FIRE_DRAGON_EGG, FireDragonEggRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.WATER_DRAGON_EGG, WaterDragonEggRenderer::new);
    }
}
