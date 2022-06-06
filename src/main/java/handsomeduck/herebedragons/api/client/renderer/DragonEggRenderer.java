package handsomeduck.herebedragons.api.client.renderer;

import handsomeduck.herebedragons.api.client.model.DragonEggModel;
import handsomeduck.herebedragons.api.entity.DragonEggEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@Environment(EnvType.CLIENT)
public class DragonEggRenderer<T extends DragonEggEntity> extends GeoEntityRenderer {

    public DragonEggRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DragonEggModel());
    }

    public Identifier getTextureLocation(DragonEggEntity object) {
        return null;
    }
}
