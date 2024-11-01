package com.pilzbros.PilzServerTools.help;

import com.pilzbros.PilzServerTools.PilzServerTools;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpMessages {
    private CommandSender player;
    private PilzServerTools pst;

    public HelpMessages(PilzServerTools pst, CommandSender player) {
        this.player = player;
        this.pst = pst;
    }

    public void nobodyInQueue() {
        this.player.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + "There are no users more in the help queue!");
    }

    public void noAdminsOnline() {
        this.player.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.RED + "There are no admins online to assist you right now");
    }

    public void permissionError() {
        this.player.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.RED + "You don't have permissions to use PST's HelpMe!");
    }
}
