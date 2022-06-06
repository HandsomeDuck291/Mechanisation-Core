package handsomeduck.herebedragons;

import handsomeduck.herebedragons.client.renderer.FireDragonEggRenderer;
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
        EntityRendererRegistry.register(EntityRegistry.FIREDRAGONEGG, FireDragonEggRenderer::new);
        //EntityRendererRegistry.register(EntityRegistry.WATERDRAGONEGG, WaterDragonEggRenderer::new);
    }
}
