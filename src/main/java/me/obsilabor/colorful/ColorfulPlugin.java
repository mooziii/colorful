package me.obsilabor.colorful;

import me.obsilabor.colorful.config.ColorfulConfiguration;
import me.obsilabor.colorful.listener.AnvilListener;
import me.obsilabor.colorful.listener.ChatListener;
import me.obsilabor.colorful.listener.SignListener;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ColorfulPlugin extends JavaPlugin {
    public static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

    @Override
    public void onEnable() {
        if (!Bukkit.getName().toLowerCase().contains("paper")) {
            getLogger().warning("Seems like you're not using PaperMC, this plugin will not work on Spigot or Bukkit. Paper forks may work.");
        }
        PluginManager pluginManager = Bukkit.getPluginManager();
        if (ColorfulConfiguration.INSTANCE.isChatEnabled()) {
            pluginManager.registerEvents(new ChatListener(), this);
        }
        if (ColorfulConfiguration.INSTANCE.areSignsEnabled()) {
            pluginManager.registerEvents(new SignListener(), this);
        }
        if (ColorfulConfiguration.INSTANCE.areAnvilsEnabled()) {
            pluginManager.registerEvents(new AnvilListener(), this);
        }
    }
}
