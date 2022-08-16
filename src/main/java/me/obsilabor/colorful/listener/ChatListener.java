package me.obsilabor.colorful.listener;

import io.papermc.paper.chat.ChatRenderer;
import io.papermc.paper.event.player.AsyncChatEvent;
import me.obsilabor.colorful.ColorfulPlugin;
import me.obsilabor.colorful.config.ColorfulConfiguration;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ChatListener implements Listener {
    @EventHandler
    public void onAsyncChat(AsyncChatEvent event) {
        event.renderer(ChatRenderer.viewerUnaware((source, sourceDisplayName, message) -> {
            String formattedMessage = ColorfulConfiguration.INSTANCE.getChatFormat()
                    .replace("${message}", PlainTextComponentSerializer.plainText().serialize(message));
            return ColorfulPlugin.MINI_MESSAGE.deserialize(formattedMessage).replaceText(
                    TextReplacementConfig.builder()
                            .matchLiteral("${source}")
                            .replacement(source.displayName())
                            .once()
                            .build()
            );
        }));
    }
}
