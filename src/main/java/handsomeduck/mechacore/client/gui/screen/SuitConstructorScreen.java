package handsomeduck.mechacore.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import handsomeduck.mechacore.api.MechaCorePackets;
import handsomeduck.mechacore.common.gui.SuitConstructorHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SuitConstructorScreen extends HandledScreen<SuitConstructorHandler> {
    private static final Identifier TEXTURE = new Identifier("mechacore", "textures/gui/suit_constructor.png");

    public SuitConstructorScreen(SuitConstructorHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();

        int y = (height - backgroundHeight) / 2;
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 28, y + 57, 56, 20, Text.translatable("fabricator.fabricate"), (button) -> {
            ClientPlayNetworking.send(MechaCorePackets.FABRICATION_ID, PacketByteBufs.empty());
        }));
    }
}
