package com.spectrasonic.JoinLeave.Commands;

import com.spectrasonic.JoinLeave.Config.ConfigManager;
import com.spectrasonic.JoinLeave.Utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    private final ConfigManager configManager;

    public ReloadCommand(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("joinleave.reload")) {
                MessageUtils.sendPermissionMessage(sender);
                return true;
            }
            configManager.load();
            MessageUtils.sendMessage(sender, configManager.getReloadMessage());
            return true;
        }
        return false;
    }
}