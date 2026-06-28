package stellar.stellar.client;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class StellarClient implements ClientModInitializer {
	KeyMapping.Category CATEGORY = KeyMapping.Category.register(
		Identifier.fromNamespaceAndPath("stellar", "custom_category")
	);

	KeyMapping sendToChatKey = KeyMappingHelper.registerKeyMapping(
	new KeyMapping(
			"key.stellar.send_to_chat", // The translation key for the key mapping.
			InputConstants.Type.KEYSYM, // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
			GLFW.GLFW_KEY_J, // The GLFW keycode of the key.
			this.CATEGORY // The category of the mapping.
	));

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
	while (this.sendToChatKey.consumeClick()) {
		if (client.player != null) {
			client.player.sendSystemMessage(Component.literal("/give @s stellar:lemon_lemon 1"));
		}
	}
});
	}
}