package com.pilzbros.PilzServerTools.messages;

import com.pilzbros.PilzServerTools.PilzServerTools;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands {
    PilzServerTools pst;
    private CommandSender sender;

    public Commands() {
        this.pst = PilzServerTools.instance;
        this.sender = null;
    }

    public Commands(CommandSender send) {
        this.pst = PilzServerTools.instance;
        this.sender = send;
    }

    public void runningStatus() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + "PilzServerTools" + ChatColor.WHITE + " v" + "2.3");
        if (this.pst.updateNeeded) {
            this.sender.sendMessage(ChatColor.YELLOW + "Update available!!");
        }

        if (this.pst.getMaintenance()) {
            this.sender.sendMessage(ChatColor.YELLOW + "Maintenance Mode: " + ChatColor.RED + " ENABLED");
        }

    }

    public void runningCheck() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + "PilzServerTools is running!");
    }

    public void pluginInfo() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + "PilzServerTools" + ChatColor.WHITE + " v" + "2.3");
    }

    public void pluginUpdate() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.YELLOW + "Updating automatically is not available at this time!");
    }

    public void maintenanceEnable() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.YELLOW + "Maintenance mode enabled! Only users with PST admin permission can login");
    }

    public void maintenanceDisable() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.GREEN + "Maintenance mode disabled! Login is now permitted");
    }

    public void commandError() {
        this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.RED + "Invalid command!");
    }

    public void getUserInfo(Player player) {
        if (!player.isOnline()) {
            this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + "PilzServerTools" + ChatColor.RED + " User is not online or does not exist!");
        } else {
            this.sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + "PilzServerTools");
            this.sender.sendMessage(" Name: " + player.getDisplayName());
            if (player.isOnline()) {
                this.sender.sendMessage(ChatColor.GREEN + "Currently Online");
            } else if (player.isBanned()) {
                this.sender.sendMessage(ChatColor.RED + "Currently Banned");
            } else {
                this.sender.sendMessage("Offline");
            }

            if (player.isWhitelisted()) {
                this.sender.sendMessage("Whitelisted: Yes");
            } else {
                this.sender.sendMessage("Whitelisted: No");
            }

            if (player.isSleeping()) {
                this.sender.sendMessage("Sleeping: " + ChatColor.GREEN + " Yes");
            }

            if (player.isFlying()) {
                this.sender.sendMessage("Flying: " + ChatColor.GREEN + " Yes");
            }

            if (player.isInsideVehicle()) {
                this.sender.sendMessage("In Vehnicle: " + ChatColor.GREEN + " Yes");
            }

            this.sender.sendMessage("Game Mode: " + player.getGameMode());
            this.sender.sendMessage("Fly Speed: " + player.getFlySpeed());
            this.sender.sendMessage("Walk Speed: " + player.getWalkSpeed());
            this.sender.sendMessage("Level: " + player.getLevel());
            this.sender.sendMessage("Health: " + player.getHealth() + " / " + player.getHealthScale());
            this.sender.sendMessage("Food: " + player.getFoodLevel());
        }

    }
}