package handsomeduck.mechacore.common;

import handsomeduck.mechacore.client.gui.screen.EquipPadScreen;
import handsomeduck.mechacore.client.gui.screen.SuitConstructorScreen;
import handsomeduck.mechacore.client.model.equipment.armour.SkinTightTestModel;
import handsomeduck.mechacore.client.renderer.SkinTightTestRenderer;
import handsomeduck.mechacore.common.registry.ArmourRegistry;
import handsomeduck.mechacore.common.registry.ObjectRegistry;
import handsomeduck.mechacore.common.registry.ScreenRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@SuppressWarnings({"unchecked", "ConstantConditions"})
@Environment(EnvType.CLIENT)
public class MechaCoreClient implements ClientModInitializer {

    public static final EntityModelLayer SKIN_TIGHT_MODEL_LAYER = new EntityModelLayer(new Identifier(MechaCore.MOD_ID, "skin_armour"), "main");

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ScreenRegistry.EQUIP_PAD_HANDLER, EquipPadScreen::new);
        HandledScreens.register(ScreenRegistry.SUIT_CONSTRUCTOR_HANDLER, SuitConstructorScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ObjectRegistry.CONSTRUCTOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ObjectRegistry.EQUIP_PAD, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(SKIN_TIGHT_MODEL_LAYER, SkinTightTestModel::getTexturedModelData);
        ArmorRenderer.register(new SkinTightTestRenderer(new Identifier(MechaCore.MOD_ID, "textures/entity/armor/steve.png"),
                ArmourRegistry.HELM), ArmourRegistry.HELM, ArmourRegistry.CHEST, ArmourRegistry.PANT, ArmourRegistry.BOOT);

    }

    private static ModelPart getPart(EntityModelLayer layer) {
        return MinecraftClient.getInstance().getEntityModelLoader().getModelPart(layer);
    }
}
