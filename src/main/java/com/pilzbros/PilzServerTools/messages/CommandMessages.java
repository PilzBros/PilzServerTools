package com.pilzbros.PilzServerTools.messages;

import com.pilzbros.PilzServerTools.PilzServerTools;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CommandMessages {
    private CommandSender sender;

    public CommandMessages() {
    }

    public CommandMessages(CommandSender send) {
        this.sender = send;
    }

    public void playerSyntax() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.RED + " Player syntax: /pst player [name]");
    }

    public void maintenanceSyntax() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.RED + " Maintenance syntax: /pst maintenance [enable/disable]");
    }

    public void permissionError() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.RED + " You don't have permission to this plugin");
    }

    public void playerSyntaxError() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.GRAY + " Player syntax: /pst player NAME info");
    }

    public void maintenanceSyntaxError() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.GRAY + " Maintenance syntax: /pst maintenance [enabled / disable]");
    }

    public void playerExistError() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.RED + " User is not online or does not exist!");
    }

    public void unknownCommand() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.RED + " Unknown command!");
    }

    public void onlineUserError() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.RED + " User information cannot be retrieved when they're offline!");
    }

    public void maintenanceEnabled() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + " Maintenance mode" + ChatColor.RED + " enabled!");
    }

    public void maintenanceDisabled() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + " Maintenance mode" + ChatColor.GREEN + " disabled!");
    }

    public void updateNeededCommand() {
        this.sender.sendMessage(PilzServerTools.pluginPrefix + ChatColor.WHITE + "A new version of PilzServerTools is available!!");
    }

    public void noUpdateNeededCommand() {
        this.sender.sendMessage(PilzServerTools.pluginPrefix + ChatColor.WHITE + "You're running the latest version of PilzServerTools! (Version " + "2.3" + ")");
    }

    public void updateCheckDisabled() {
        this.sender.sendMessage(PilzServerTools.pluginPrefix + ChatColor.RED + "You have disabled update checking in global.yml. Please enable this setting to allow PilzServerTools to check for new updates");
    }
}
