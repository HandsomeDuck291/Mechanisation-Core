package handsomeduck.mechacore.common.registry;

import handsomeduck.mechacore.common.MechaCore;
import handsomeduck.mechacore.common.gui.ModuleTableHandler;
import handsomeduck.mechacore.common.gui.SuitConstructorHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ScreenRegistry {
    public static final ScreenHandlerType<SuitConstructorHandler> SUIT_CONSTRUCTOR_HANDLER = new ScreenHandlerType<>(SuitConstructorHandler::new);
    public static final ScreenHandlerType<ModuleTableHandler> MODULE_TABLE_HANDLER = new ScreenHandlerType<>(ModuleTableHandler::new);

    public static void init() {
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(MechaCore.MOD_ID, "suit_constructor_screen"), SUIT_CONSTRUCTOR_HANDLER);
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(MechaCore.MOD_ID, "module_table_screen"), MODULE_TABLE_HANDLER);
    }
}
