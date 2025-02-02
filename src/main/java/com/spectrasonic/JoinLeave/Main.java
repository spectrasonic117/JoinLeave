package com.spectrasonic.JoinLeave;

import co.aikar.commands.PaperCommandManager;
import com.spectrasonic.JoinLeave.Utils.MessageUtils;
import com.spectrasonic.JoinLeave.Commands.ReloadCommand;
import com.spectrasonic.JoinLeave.Config.ConfigManager;
import com.spectrasonic.JoinLeave.Listeners.JoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private ConfigManager configManager;
    private PaperCommandManager commandManager;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;
        saveDefaultConfig();
        configManager = new ConfigManager(this);
        configManager.load();

        saveDefaultConfig();

        registerCommands();
        registerEvents();
        MessageUtils.sendStartupMessage(this);

    }

    @Override
    public void onDisable() {
        MessageUtils.sendShutdownMessage(this);
    }

    public void registerCommands() {
        commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new ReloadCommand(configManager));
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(configManager), this);
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

}
