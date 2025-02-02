package com.spectrasonic.JoinLeave.Commands;

import com.spectrasonic.JoinLeave.Config.ConfigManager;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.annotation.CommandPermission;
import org.bukkit.command.CommandSender;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.Component;

@CommandAlias("joinleave")
public class ReloadCommand extends BaseCommand {
    private final ConfigManager configManager;
    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    public ReloadCommand(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @Subcommand("reload")
    @CommandPermission("joinleave.reload")
    public void onReload(CommandSender sender) {
        configManager.load();
        Component message = miniMessage.deserialize(configManager.getReloadMessage());
        sender.sendMessage(message);
    }
}
