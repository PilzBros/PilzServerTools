package com.pilzbros.PilzServerTools.command;

import com.pilzbros.PilzServerTools.PilzServerTools;
import com.pilzbros.PilzServerTools.messages.CommandMessages;
import com.pilzbros.PilzServerTools.messages.Commands;
import com.pilzbros.PilzServerTools.plugin.Setting;
import com.pilzbros.PilzServerTools.plugin.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PilzCommandExc implements CommandExecutor {
    public String pluginName;
    public String pluginVersion;
    public String pluginPrefix;
    private PilzServerTools pst;

    public PilzCommandExc(PilzServerTools pilzServerTools) {
        this.pst = pilzServerTools;
        this.pluginName = "PilzServerTools";
        this.pluginVersion = "2.3";
        this.pluginPrefix = PilzServerTools.pluginPrefix;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CommandMessages commandMessages = new CommandMessages(sender);
        Commands commandExe = new Commands(sender);
        if (!sender.hasPermission("PST.*") && !sender.hasPermission("PST.admin")) {
            commandMessages.permissionError();
        } else if (args.length < 1) {
            commandExe.runningStatus();
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("info")) {
                commandExe.pluginInfo();
            } else if (args[0].equalsIgnoreCase("update")) {
                if (Settings.getGlobalBoolean(Setting.CheckForUpdates)) {
                    if (this.pst.updateNeeded) {
                        commandMessages.updateNeededCommand();
                    } else {
                        commandMessages.noUpdateNeededCommand();
                    }
                } else {
                    commandMessages.updateCheckDisabled();
                }
            } else if (args[0].equalsIgnoreCase("player")) {
                commandMessages.playerSyntax();
            } else if (args[0].equalsIgnoreCase("memory")) {
                sender.sendMessage(PilzServerTools.pluginPrefix + ChatColor.WHITE + " --- Server Memory --- ");
                sender.sendMessage("Processors: " + PilzServerTools.memory.getProcessors());
                sender.sendMessage("Total Memory: " + PilzServerTools.memory.getTotalMemory() + "MB");
                sender.sendMessage("Free Memory: " + PilzServerTools.memory.getFreeMemory() + "MB");
                sender.sendMessage("Memory In Use: " + (PilzServerTools.memory.getTotalMemory() - PilzServerTools.memory.getFreeMemory()) + "MB (" + PilzServerTools.memory.getMemoryUsage() + ")%");
                sender.sendMessage("Memory Remaining: " + PilzServerTools.memory.getMemoryRemaining() + "%");
            } else if (args[0].equalsIgnoreCase("maintenance")) {
                commandMessages.maintenanceSyntax();
            } else {
                commandMessages.unknownCommand();
            }
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("maintenance")) {
                if (args[1].equalsIgnoreCase("enable")) {
                    this.pst.updateMaintenance(true);
                    commandExe.maintenanceEnable();
                } else if (args[1].equalsIgnoreCase("disable")) {
                    this.pst.updateMaintenance(false);
                    commandExe.maintenanceDisable();
                } else if (args[1].equalsIgnoreCase("info")) {
                    if (this.pst.getMaintenance()) {
                        commandMessages.maintenanceEnabled();
                    } else {
                        commandMessages.maintenanceDisabled();
                    }
                } else {
                    commandMessages.maintenanceSyntaxError();
                }
            } else if (args[0].equalsIgnoreCase("player")) {
                OfflinePlayer player = Bukkit.getServer().getOfflinePlayer(args[1]);
                if (player.hasPlayedBefore()) {
                    if (player.isOnline()) {
                        Player onlinePlayer = Bukkit.getServer().getPlayer(player.getName());
                        commandExe.getUserInfo(onlinePlayer);
                    } else {
                        commandMessages.onlineUserError();
                    }
                } else {
                    commandMessages.playerExistError();
                }
            } else {
                commandMessages.unknownCommand();
            }
        } else {
            commandMessages.unknownCommand();
        }

        return true;
    }
}
