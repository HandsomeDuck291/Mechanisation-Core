package handsomeduck.mechacore.common;

import handsomeduck.mechacore.api.MechaCorePackets;
import handsomeduck.mechacore.common.registry.*;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

public class MechaCore implements ModInitializer {

	public static final String MOD_ID = "mechacore";
	public static final Logger LOGGER = LogManager.getLogger("mechacore:");

	@Override
	public void onInitialize() {
		GeckoLib.initialize();

		ObjectRegistry.init();
		EntityRegistry.init();
		ScreenRegistry.init();
		ArmourRegistry.init();
		WorldGeneration.init();

		MechaCorePackets.registerC2SPackets();
		MechaCorePackets.registerS2CPackets();

		LOGGER.info("Initialization done, CLANK!");
	}
}
