package com.spectrasonic.JoinLeave.Config;

import com.spectrasonic.JoinLeave.Main;
import org.bukkit.ChatColor;
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
        joinMessage = ChatColor.translateAlternateColorCodes('&', config.getString("messages.join", "&8[&a+&8] &6{player}"));
        leaveMessage = ChatColor.translateAlternateColorCodes('&', config.getString("messages.leave", "&8[&c-&8] &6{player}"));
        reloadMessage = ChatColor.translateAlternateColorCodes('&', config.getString("messages.reload", "&7[&fJoinLeave&7] &aConfiguration reloaded successfully!"));
        toggleOnMessage = ChatColor.translateAlternateColorCodes('&', config.getString("messages.toggle_on", "&7[&fJoinLeave&7] &aJoin/Leave messages enabled"));
        toggleOffMessage = ChatColor.translateAlternateColorCodes('&', config.getString("messages.toggle_off", "&7[&fJoinLeave&7] &cJoin/Leave messages disabled"));
        messagesEnabled = config.getBoolean("settings.messages_enabled", true);
    }
}