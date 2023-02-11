package handsomeduck.mechacore.mixin;

import handsomeduck.mechacore.common.item.ElectricalArmourItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public PlayerEntityRendererMixin(EntityRendererFactory.Context ctx, PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void PlayerEntityRenderer(EntityRendererFactory.Context ctx, boolean slim, CallbackInfo callbackInfo) {
    }

    @Inject(method = "render(Lnet/minecraft/client/network/AbstractClientPlayerEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At("HEAD"), cancellable = true)
    private void render(AbstractClientPlayerEntity player, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, CallbackInfo callbackInfo) {
    }

    @Inject(method = "setModelPose(Lnet/minecraft/client/network/AbstractClientPlayerEntity;)V", at = @At("TAIL"))
    private void setModelPose(AbstractClientPlayerEntity player, CallbackInfo ci) {
        PlayerEntityModel<AbstractClientPlayerEntity> playerEntityModel = (PlayerEntityModel)this.getModel();
        if (player.getEquippedStack(EquipmentSlot.HEAD).getItem() instanceof ElectricalArmourItem electricalArmourItem) {
            playerEntityModel.hat.visible = false;
        }
        if (player.getEquippedStack(EquipmentSlot.CHEST).getItem() instanceof ElectricalArmourItem electricalArmourItem) {
            playerEntityModel.jacket.visible = false;
            playerEntityModel.rightSleeve.visible = false;
            playerEntityModel.leftSleeve.visible = false;
        }
        if (player.getEquippedStack(EquipmentSlot.LEGS).getItem() instanceof ElectricalArmourItem electricalArmourItem) {
            playerEntityModel.leftPants.visible = false;
            playerEntityModel.rightPants.visible = false;
        }
    }
}
