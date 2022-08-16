package me.obsilabor.colorful.listener;

import me.obsilabor.colorful.ColorfulPlugin;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;

public class AnvilListener implements Listener {
    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        var result = event.getResult();
        if (result == null) {
            return;
        }
        var meta = result.getItemMeta();
        if (meta == null) {
            return;
        }
        meta.displayName(ColorfulPlugin.MINI_MESSAGE.deserialize(PlainTextComponentSerializer.plainText().serialize(meta.displayName())));
        result.setItemMeta(meta);
    }
}
