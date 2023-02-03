package handsomeduck.mechacore.common.block.client;

import handsomeduck.mechacore.common.block.SuitConstructor;
import handsomeduck.mechacore.common.block.SuitConstructorEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class SuitConstuctorBlockEntityRender implements BlockEntityRenderer<SuitConstructorEntity> {
    public SuitConstuctorBlockEntityRender(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(SuitConstructorEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(0.5f, 0.645f, 0.5f);
        matrices.scale(0.2f, 0.2f, 0.2f);
        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-90));

        switch (entity.getCachedState().get(SuitConstructor.FACING)) {
            case NORTH -> matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
            case EAST -> matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(270));
            case SOUTH -> matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(0));
            case WEST -> matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(90));
        }
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }

}
