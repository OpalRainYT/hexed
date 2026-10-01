package com.hexed.client.ui;

import com.hexed.client.HexedClient;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public final class HexedHud {
    private HexedHud() {
    }

    public static void register() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (!HexedClient.isHudEnabled()) {
                return;
            }

            MinecraftClient client = MinecraftClient.getInstance();
            if (client == null || client.player == null) {
                return;
            }

            TextRenderer textRenderer = client.textRenderer;
            int x = 8;
            int y = 8;

            drawText(drawContext, textRenderer, "HEXED", x, y, 0xFF00FFAA);
            drawText(drawContext, textRenderer, "v0.1.0", x, y + 12, 0xFF9FE7FF);
            drawText(drawContext, textRenderer, "status: online", x, y + 24, 0xFF7CFF93);
        });
    }

    private static void drawText(DrawContext drawContext, TextRenderer textRenderer, String text, int x, int y, int color) {
        drawContext.drawText(textRenderer, text, x, y, color, true);
    }
}
