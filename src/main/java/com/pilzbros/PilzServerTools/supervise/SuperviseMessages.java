package com.pilzbros.PilzServerTools.supervise;

import com.pilzbros.PilzServerTools.PilzServerTools;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class SuperviseMessages {
    private CommandSender player;
    private PilzServerTools pst;

    public SuperviseMessages(PilzServerTools pst, CommandSender player) {
        this.player = player;
        this.pst = pst;
    }

    public void description() {
        this.player.sendMessage(PilzServerTools.pluginPrefix + ChatColor.YELLOW + "Supervise vanishes you from users and teleports you to the desired user. " + ChatColor.AQUA + "/supervise [player]");
    }

    public void syntaxError() {
        this.player.sendMessage(PilzServerTools.pluginPrefix + ChatColor.RED + " Supervise syntax error! /supervise [player]");
    }

    public void notOnline(String p) {
        this.player.sendMessage(PilzServerTools.pluginPrefix + ChatColor.YELLOW + p + ChatColor.RED + " is not currently online");
    }

    public void neverPlayedBefore(String p) {
        this.player.sendMessage(PilzServerTools.pluginPrefix + ChatColor.YELLOW + p + ChatColor.RED + " has never played on this server before. Please consider checking your spelling and try again");
    }

    public void superviseYourself() {
        this.player.sendMessage(PilzServerTools.pluginPrefix + ChatColor.RED + "you cannot supervise yourself! :P");
    }

    public void nowSupervising(String p) {
        this.player.sendMessage(PilzServerTools.pluginPrefix + ChatColor.WHITE + "you are now supervising " + ChatColor.AQUA + p);
    }
}