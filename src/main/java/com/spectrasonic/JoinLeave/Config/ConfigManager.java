package com.spectrasonic.JoinLeave.Config;

import com.spectrasonic.JoinLeave.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private final Main plugin;
    private String joinMessage;
    private String leaveMessage;
    private String reloadMessage;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
    }

    public Main getPlugin() {
        return plugin;
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

    public void load() {
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();
        joinMessage = config.getString("messages.join", "<dark_gray>[<green>+<dark_gray>] {player}");
        leaveMessage = config.getString("messages.leave", "<dark_gray>[<red>-<dark_gray>] {player}");
        reloadMessage = config.getString("messages.reload", "<green>¡Configuración recargada correctamente!");
    }
}