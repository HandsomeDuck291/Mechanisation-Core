package handsomeduck.starktech.client.model.equipment.armour;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.entity.LivingEntity;

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class SkinTightTestModel<T extends LivingEntity> extends BipedEntityModel<T> {
	private final ModelPart armorHead;
	private final ModelPart armorRightLeg;
	private final ModelPart armorLeftLeg;
	private final ModelPart armorRightBoot;
	private final ModelPart armorLeftBoot;

	public SkinTightTestModel(ModelPart root) {
		super(root, RenderLayer::getArmorCutoutNoCull);
		child = false;
		armorHead = head.getChild("armorHead");
		armorLeftLeg = leftLeg.getChild("armorLeftLeg");
		armorLeftBoot = leftLeg.getChild("armorLeftBoot");
		armorRightLeg = rightLeg.getChild("armorRightLeg");
		armorRightBoot = rightLeg.getChild("armorRightBoot");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData data = BipedEntityModel.getModelData(Dilation.NONE, 0);
		ModelPartData head = data.getRoot().getChild(EntityModelPartNames.HEAD);
		ModelPartData body = data.getRoot().getChild(EntityModelPartNames.BODY);
		ModelPartData rightLeg = data.getRoot().getChild(EntityModelPartNames.RIGHT_LEG);
		ModelPartData leftLeg = data.getRoot().getChild(EntityModelPartNames.LEFT_LEG);
		ModelPartData rightArm = data.getRoot().getChild(EntityModelPartNames.RIGHT_ARM);
		ModelPartData leftArm = data.getRoot().getChild(EntityModelPartNames.LEFT_ARM);

		ModelPartData armorHead = head.addChild("armorHead", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F))
				.uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData armorBody = body.addChild("armorBody", ModelPartBuilder.create().uv(16, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F))
				.uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData armorRightArm = rightArm.addChild("armorRightArm", ModelPartBuilder.create().uv(40, 32).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F))
				.uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData armorLeftArm = leftArm.addChild("armorLeftArm", ModelPartBuilder.create().uv(48, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F))
				.uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData armorRightLeg = rightLeg.addChild("armorRightLeg", ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F))
				.uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData armorRightBoot = rightLeg.addChild("armorRightBoot", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData armorLeftLeg = leftLeg.addChild("armorLeftLeg", ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F))
				.uv(16, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData armorLeftBoot = leftLeg.addChild("armorLeftBoot", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(data, 64, 64);
	}
}