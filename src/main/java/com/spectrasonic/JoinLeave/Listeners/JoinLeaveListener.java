package com.spectrasonic.JoinLeave.Listeners;

import com.spectrasonic.JoinLeave.Config.ConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    private final ConfigManager configManager;

    public JoinLeaveListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        if (configManager.isMessagesEnabled()) {
            String message = configManager.getJoinMessage().replace("{player}", event.getPlayer().getName());
            event.getPlayer().getServer().broadcastMessage(message);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        if (configManager.isMessagesEnabled()) {
            String message = configManager.getLeaveMessage().replace("{player}", event.getPlayer().getName());
            event.getPlayer().getServer().broadcastMessage(message);
        }
    }
}