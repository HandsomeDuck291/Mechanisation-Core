package handsomeduck.starktech.common;

import handsomeduck.starktech.common.registry.ArmourRegistry;
import handsomeduck.starktech.common.registry.EntityRegistry;
import handsomeduck.starktech.common.registry.ObjectRegistry;
import handsomeduck.starktech.common.registry.ScreenRegistry;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

public class StarkTech implements ModInitializer {

	public static final String MOD_ID = "starktech";
	public static final Logger LOGGER = LogManager.getLogger("starktech:");

	@Override
	public void onInitialize() {
		GeckoLib.initialize();

		ObjectRegistry.registerModItems();
		EntityRegistry.registerModEntities();
		ArmourRegistry.registerModArmour();
		ObjectRegistry.init();
		EntityRegistry.init();
		ScreenRegistry.init();
		ArmourRegistry.init();


		LOGGER.info("Initialization done, CLANK!");
	}
}
