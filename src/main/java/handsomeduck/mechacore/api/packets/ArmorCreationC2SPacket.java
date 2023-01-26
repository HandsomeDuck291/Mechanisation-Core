package handsomeduck.mechacore.api.packets;

import handsomeduck.mechacore.common.registry.ArmourRegistry;
import handsomeduck.mechacore.common.registry.ObjectRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class ArmorCreationC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {

        server.execute(() -> {
            player.sendMessage(Text.literal("DEBUG"));
            PlayerInventory playerInventory = player.getInventory();

            if (playerInventory.count(ObjectRegistry.PALLADIUM_INGOT) >= 2 && player.currentScreenHandler.slots.isEmpty()) {
                player.sendMessage(Text.literal("Exo Suit Created"));
                playerInventory.removeStack(playerInventory.getSlotWithStack(new ItemStack(ObjectRegistry.PALLADIUM_INGOT)), 2);
                player.currentScreenHandler.setStackInSlot(0, 0, new ItemStack(ArmourRegistry.HELM));
                player.currentScreenHandler.setStackInSlot(1, 0, new ItemStack(ArmourRegistry.CHEST));
                player.currentScreenHandler.setStackInSlot(2, 0, new ItemStack(ArmourRegistry.PANT));
                player.currentScreenHandler.setStackInSlot(3, 0, new ItemStack(ArmourRegistry.BOOT));
            } else if (!player.currentScreenHandler.slots.isEmpty()) {
                player.sendMessage(Text.literal("Sorry Chief, not empty"));
            } else {
                player.sendMessage(Text.literal("Need more stuff"));
            }
        });
    }
}
