package com.pilzbros.PilzServerTools.messages;

import com.pilzbros.PilzServerTools.PilzServerTools;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class GlobalMessages {
    private CommandSender player;
    private PilzServerTools pst;

    public GlobalMessages(PilzServerTools pst, CommandSender player) {
        this.player = player;
        this.pst = pst;
    }

    public void permissionError() {
        this.player.sendMessage(PilzServerTools.pluginPrefix + ChatColor.RED + "You don't have permissions to use PST");
    }
}
