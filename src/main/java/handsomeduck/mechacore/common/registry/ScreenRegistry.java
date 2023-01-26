package handsomeduck.mechacore.common.registry;

import handsomeduck.mechacore.common.MechaCore;
import handsomeduck.mechacore.common.gui.SuitConstructorHandler;
import handsomeduck.mechacore.common.gui.EquipPadHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ScreenRegistry {
    public static final ScreenHandlerType<EquipPadHandler> EQUIP_PAD_HANDLER = new ScreenHandlerType<>(EquipPadHandler::new);
    public static final ScreenHandlerType<SuitConstructorHandler> SUIT_CONSTRUCTOR_HANDLER = new ScreenHandlerType<>(SuitConstructorHandler::new);

    public static void init() {
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(MechaCore.MOD_ID, "equip_pad_screen"), EQUIP_PAD_HANDLER);
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(MechaCore.MOD_ID, "suit_constructor_screen"), SUIT_CONSTRUCTOR_HANDLER);
    }
}
