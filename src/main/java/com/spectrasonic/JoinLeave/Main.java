package com.spectrasonic.JoinLeave;

import com.spectrasonic.JoinLeave.Commands.ReloadCommand;
import com.spectrasonic.JoinLeave.Commands.ToggleCommand;
import com.spectrasonic.JoinLeave.Commands.JoinLeaveTabCompleter;
import com.spectrasonic.JoinLeave.Config.ConfigManager;
import com.spectrasonic.JoinLeave.Listeners.JoinLeaveListener;
import com.spectrasonic.JoinLeave.Utils.MessageUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private ConfigManager configManager;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        configManager = new ConfigManager(this);
        configManager.load();

        registerCommands();
        registerEvents();
        MessageUtils.sendStartupMessage(this);
    }

    @Override
    public void onDisable() {
        MessageUtils.sendShutdownMessage(this);
    }

    public void registerCommands() {
        getCommand("joinleave").setExecutor(new ReloadCommand(configManager));
        getCommand("joinleave").setExecutor(new ToggleCommand(configManager));
        getCommand("joinleave").setTabCompleter(new JoinLeaveTabCompleter());
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(configManager), this);
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}