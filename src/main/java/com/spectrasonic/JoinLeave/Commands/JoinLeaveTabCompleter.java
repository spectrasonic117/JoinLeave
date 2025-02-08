package com.spectrasonic.JoinLeave.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinLeaveTabCompleter implements TabCompleter {
    private final List<String> mainCommands = Arrays.asList("reload", "toggle");
    private final List<String> toggleOptions = Arrays.asList("on", "off");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            if (sender.hasPermission("joinleave.reload")) {
                if ("reload".startsWith(args[0].toLowerCase())) {
                    completions.add("reload");
                }
            }
            if (sender.hasPermission("joinleave.toggle")) {
                if ("toggle".startsWith(args[0].toLowerCase())) {
                    completions.add("toggle");
                }
            }
        } else if (args.length == 2 && args[0].equalsIgnoreCase("toggle")) {
            if (sender.hasPermission("joinleave.toggle")) {
                for (String option : toggleOptions) {
                    if (option.startsWith(args[1].toLowerCase())) {
                        completions.add(option);
                    }
                }
            }
        }

        return completions;
    }
}