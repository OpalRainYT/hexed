package com.hexed.client;

import com.hexed.HexedMod;
import com.hexed.client.ui.HexedHud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class HexedClient implements ClientModInitializer {
    private static boolean hudEnabled = true;

    public static KeyBinding toggleHudKey;

    public static boolean isHudEnabled() {
        return hudEnabled;
    }

    public static void setHudEnabled(boolean enabled) {
        hudEnabled = enabled;
    }

    @Override
    public void onInitializeClient() {
        toggleHudKey = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.hexed.toggle_hud",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_H,
                        "category.hexed"
                )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleHudKey.wasPressed()) {
                hudEnabled = !hudEnabled;
                HexedMod.LOGGER.info("Hexed HUD {}", hudEnabled ? "enabled" : "disabled");
            }
        });

        HexedHud.register();
    }
}
