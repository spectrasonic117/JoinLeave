package com.spectrasonic.JoinLeave.Listeners;

import com.spectrasonic.JoinLeave.Config.ConfigManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    private final ConfigManager configManager;
    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    public JoinLeaveListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.joinMessage(null);
        if (configManager.isMessagesEnabled()) {
            String raw = configManager.getJoinMessage().replace("{player}", event.getPlayer().getName());
            Component message = miniMessage.deserialize(raw);
            event.getPlayer().getServer().sendMessage(message);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.quitMessage(null);
        if (configManager.isMessagesEnabled()) {
            String raw = configManager.getLeaveMessage().replace("{player}", event.getPlayer().getName());
            Component message = miniMessage.deserialize(raw);
            event.getPlayer().getServer().sendMessage(message);
        }

    }
}
