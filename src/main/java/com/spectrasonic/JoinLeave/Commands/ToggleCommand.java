package com.spectrasonic.JoinLeave.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.spectrasonic.JoinLeave.Config.ConfigManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;

@CommandAlias("joinleave")
public class ToggleCommand extends BaseCommand {
    private final ConfigManager configManager;
    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    public ToggleCommand(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @Subcommand("toggle")
    @CommandCompletion("@toggle")
    @CommandPermission("joinleave.toggle")
    public void onToggle(CommandSender sender, @Values("on|off") String state) {
        boolean enable = state.equalsIgnoreCase("on");
        configManager.setMessagesEnabled(enable);
        
        String message = enable ? configManager.getToggleOnMessage() : configManager.getToggleOffMessage();
        Component component = miniMessage.deserialize(message);
        sender.sendMessage(component);
    }
}