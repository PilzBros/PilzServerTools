package com.pilzbros.PilzServerTools.server;

import com.pilzbros.PilzServerTools.PilzServerTools;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Login {
    private PilzServerTools pst;
    private Player player;

    public Login(Player play, PilzServerTools ref) {
        this.player = play;
        this.pst = ref;
    }

    public void checkHelpQueue() {
        if (!this.pst.helpQueue.isEmpty()) {
            this.player.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + this.pst.helpQueue.size() + " users are in the help queue!");
        }

    }

    public void checkMaintenanceMode() {
        if (this.pst.getMaintenance()) {
            if (this.player.hasPermission("PST.*") && this.player.hasPermission("PST.admin")) {
                this.player.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + "Welcome! Maintainence mode is enabled. Only users with admin permissions are currently allowed to join the server");
            } else if (this.player.hasPlayedBefore()) {
                this.player.kickPlayer("The server is currently being updated! Please check back shortly! (Updating usually takes less than 10 minutes)");
            } else {
                this.player.kickPlayer("Welcome to the server! We're currently updating a few things, so please check back shortly! (Updating usually takes less than 10 minutes)");
            }
        }

    }
}
