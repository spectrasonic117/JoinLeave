package com.spectrasonic.JoinLeave.Commands;

import com.spectrasonic.JoinLeave.Config.ConfigManager;
import com.spectrasonic.JoinLeave.Utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleCommand implements CommandExecutor {
    private final ConfigManager configManager;

    public ToggleCommand(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2 && args[0].equalsIgnoreCase("toggle")) {
            if (!sender.hasPermission("joinleave.toggle")) {
                MessageUtils.sendPermissionMessage(sender);
                return true;
            }

            boolean enable = args[1].equalsIgnoreCase("on");
            configManager.setMessagesEnabled(enable);

            String message = enable ? configManager.getToggleOnMessage() : configManager.getToggleOffMessage();
            MessageUtils.sendMessage(sender, message);
            return true;
        }
        return false;
    }
}