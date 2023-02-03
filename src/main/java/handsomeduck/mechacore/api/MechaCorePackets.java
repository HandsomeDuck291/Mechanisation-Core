package handsomeduck.mechacore.api;

import handsomeduck.mechacore.api.packets.ArmorCreationC2SPacket;
import handsomeduck.mechacore.api.packets.ItemStackSyncS2CPacket;
import handsomeduck.mechacore.common.MechaCore;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class MechaCorePackets {
    public static final Identifier FABRICATION_ID = new Identifier(MechaCore.MOD_ID, "armour_creation");

    public static final Identifier ITEM_SYNC = new Identifier(MechaCore.MOD_ID, "item_sync");

    public static void registerC2SPackets() {
        MechaCore.LOGGER.info("C2S Packets Registered for " + MechaCore.MOD_ID);
        ServerPlayNetworking.registerGlobalReceiver(FABRICATION_ID, ArmorCreationC2SPacket::receive);
    }

    public static void registerS2CPackets() {
        MechaCore.LOGGER.info("S2C Packets Registered for " + MechaCore.MOD_ID);
        ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC, ItemStackSyncS2CPacket::receive);
    }
}
