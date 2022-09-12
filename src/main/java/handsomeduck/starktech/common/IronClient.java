package handsomeduck.starktech.common;

import handsomeduck.starktech.client.screen.EquipPadScreen;
import handsomeduck.starktech.client.screen.SuitConstructorScreen;
import handsomeduck.starktech.common.registry.ObjectRegistry;
import handsomeduck.starktech.common.registry.ScreenRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

@SuppressWarnings({"unchecked", "ConstantConditions"})
@Environment(EnvType.CLIENT)
public class IronClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ScreenRegistry.EQUIP_PAD_HANDLER, EquipPadScreen::new);
        HandledScreens.register(ScreenRegistry.SUIT_CONSTRUCTOR_HANDLER, SuitConstructorScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ObjectRegistry.CONSTRUCTOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ObjectRegistry.EQUIP_PAD, RenderLayer.getCutout());
    }
}
