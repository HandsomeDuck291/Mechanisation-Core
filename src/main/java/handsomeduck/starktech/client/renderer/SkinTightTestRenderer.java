package handsomeduck.starktech.client.renderer;

import handsomeduck.starktech.client.model.equipment.armour.SkinTightTestModel;
import handsomeduck.starktech.common.IronClient;
import handsomeduck.starktech.common.StarkTech;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class SkinTightTestRenderer implements ArmorRenderer {
    private static final Identifier SKIN_TIGHT_VARIANT_TEXTURE = new Identifier(StarkTech.MOD_ID, "textures/entity/armor/steve.png");
    private static SkinTightTestModel<LivingEntity> armorModel;

    private final Identifier texture;
    private final Item helmItem;

    public SkinTightTestRenderer(Identifier texture, @Nullable Item helmItem) {
        this.texture = texture;
        this.helmItem = helmItem;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        if (armorModel == null) {
            armorModel = new SkinTightTestModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(IronClient.SKIN_TIGHT_MODEL_LAYER));
        }
        boolean hem = stack.getItem() == helmItem;
        contextModel.setAttributes(armorModel);
        armorModel.setVisible(false);
        armorModel.head.visible = slot == EquipmentSlot.HEAD;
        armorModel.body.visible = slot == EquipmentSlot.CHEST;
        armorModel.leftArm.visible = slot == EquipmentSlot.CHEST;
        armorModel.rightArm.visible = slot == EquipmentSlot.CHEST;
        armorModel.leftLeg.visible = slot == EquipmentSlot.LEGS;
        armorModel.rightLeg.visible = slot == EquipmentSlot.LEGS;
        ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, armorModel, hem ? SKIN_TIGHT_VARIANT_TEXTURE : texture);
    }
}
