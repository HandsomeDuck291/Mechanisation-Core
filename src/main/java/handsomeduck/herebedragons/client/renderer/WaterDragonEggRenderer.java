package handsomeduck.herebedragons.client.renderer;

import handsomeduck.herebedragons.HereBeDragons;
import handsomeduck.herebedragons.api.client.renderer.DragonEggRenderer;
import handsomeduck.herebedragons.api.entity.DragonEggEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class WaterDragonEggRenderer extends DragonEggRenderer<DragonEggEntity> {

    public WaterDragonEggRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTextureLocation(DragonEggEntity object) {
        return new Identifier(HereBeDragons.MOD_ID, "textures/entity/dragonegg/wateregg.png");
    }
}
