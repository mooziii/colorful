package me.obsilabor.colorful.config;

import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.loader.HeaderMode;
import org.spongepowered.configurate.yaml.NodeStyle;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

import java.nio.file.Files;
import java.nio.file.Path;

public class ColorfulConfiguration {
    public static final ColorfulConfiguration INSTANCE = new ColorfulConfiguration();

    private final Path path = Path.of("config", "colorful-config.yml");
    private final ConfigurationNode root;

    private ColorfulConfiguration() {
        try {
            boolean initial = false;
            if (!Files.exists(path)) {
                Files.createFile(path);
                initial = true;
            }
            final YamlConfigurationLoader loader = YamlConfigurationLoader.builder().path(path).nodeStyle(NodeStyle.BLOCK).build();
            root = loader.load();
            ConfigurationNode chatNode = root.node("chat");
            ConfigurationNode chatFormatNode = root.node("chat-format");
            ConfigurationNode signsNode = root.node("signs");
            ConfigurationNode anvilsNode = root.node("anvils");
            if (initial) {
                chatNode.set(true);
                chatFormatNode.set("<${source}> ${message}");
                signsNode.set(true);
                anvilsNode.set(true);
            }
            loader.save(root);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isChatEnabled() {
        return root.node("chat").getBoolean();
    }

    public String getChatFormat() {
        return root.node("chat-format").getString();
    }

    public boolean areSignsEnabled() {
        return root.node("signs").getBoolean();
    }

    public boolean areAnvilsEnabled() {
        return root.node("anvils").getBoolean();
    }
}
