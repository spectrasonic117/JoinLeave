package com.spectrasonic.JoinLeave.Config;

import com.spectrasonic.JoinLeave.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private final Main plugin;
    private String joinMessage;
    private String leaveMessage;
    private String reloadMessage;
    private String toggleOnMessage;
    private String toggleOffMessage;
    private boolean messagesEnabled;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
    }

    public Main getPlugin() {
        return plugin;
    }

    public boolean isMessagesEnabled() {
        return messagesEnabled;
    }

    public void setMessagesEnabled(boolean enabled) {
        this.messagesEnabled = enabled;
        plugin.getConfig().set("settings.messages_enabled", enabled);
        plugin.saveConfig();
    }

    public String getJoinMessage() {
        return joinMessage;
    }

    public String getLeaveMessage() {
        return leaveMessage;
    }

    public String getReloadMessage() {
        return reloadMessage;
    }

    public String getToggleOnMessage() {
        return toggleOnMessage;
    }

    public String getToggleOffMessage() {
        return toggleOffMessage;
    }

    public void load() {
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();
        joinMessage = config.getString("messages.join", "<dark_gray>[<green>+<dark_gray>] {player}");
        leaveMessage = config.getString("messages.leave", "<dark_gray>[<red>-<dark_gray>] {player}");
        reloadMessage = config.getString("messages.reload", "<green>¡Configuración recargada correctamente!");
        toggleOnMessage = config.getString("messages.toggle_on", "<green>Mensajes de entrada/salida activados");
        toggleOffMessage = config.getString("messages.toggle_off", "<red>Mensajes de entrada/salida desactivados");
        messagesEnabled = config.getBoolean("settings.messages_enabled", true);
    }
}