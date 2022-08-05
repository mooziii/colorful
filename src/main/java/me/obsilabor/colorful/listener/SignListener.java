package me.obsilabor.colorful.listener;

import me.obsilabor.colorful.ColorfulPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignListener implements Listener {
    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        int index = 0;
        for (Component line : event.lines()) {
            event.line(index, ColorfulPlugin.MINI_MESSAGE.deserialize(PlainTextComponentSerializer.plainText().serialize(line)));
            index++;
        }
    }
}
