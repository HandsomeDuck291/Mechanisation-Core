package handsomeduck.starktech.common.registry;

import handsomeduck.starktech.client.screen.SuitConstructorHandler;
import handsomeduck.starktech.common.StarkTech;
import handsomeduck.starktech.client.screen.EquipPadHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ScreenRegistry {
    public static final ScreenHandlerType<EquipPadHandler> EQUIP_PAD_HANDLER = new ScreenHandlerType<>(EquipPadHandler::new);
    public static final ScreenHandlerType<SuitConstructorHandler> SUIT_CONSTRUCTOR_HANDLER = new ScreenHandlerType<>(SuitConstructorHandler::new);

    public static void init() {
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(StarkTech.MOD_ID, "equip_pad_screen"), EQUIP_PAD_HANDLER);
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(StarkTech.MOD_ID, "suit_constructor_screen"), SUIT_CONSTRUCTOR_HANDLER);
    }
}
