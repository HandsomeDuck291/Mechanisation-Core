package handsomeduck.herebedragons.api.client.model;

import handsomeduck.herebedragons.HereBeDragons;
import handsomeduck.herebedragons.api.entity.DragonEggEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib3.model.AnimatedGeoModel;

@Environment(EnvType.CLIENT)
public class DragonEggModel extends AnimatedGeoModel<DragonEggEntity> {

    @Override
    public Identifier getModelLocation(DragonEggEntity object) {
        return new Identifier(HereBeDragons.MOD_ID, "geo/entity/dragonegg.geo.json");
    }

    @Override
    public Identifier getAnimationFileLocation(DragonEggEntity animatable) {
        return new Identifier(HereBeDragons.MOD_ID, "animations/dragonegg.animation.json");
    }

    @Override
    public Identifier getTextureLocation(DragonEggEntity object) {
        return null;
    }
}
