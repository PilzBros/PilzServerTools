package com.pilzbros.PilzServerTools.silence;

import com.pilzbros.PilzServerTools.PilzServerTools;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class SilenceMessages {
    private CommandSender player;
    private PilzServerTools pst;

    public SilenceMessages(PilzServerTools pst, CommandSender player) {
        this.player = player;
        this.pst = pst;
    }

    public void silenceEnabled() {
        this.player.sendMessage(PilzServerTools.pluginPrefix + ChatColor.GREEN + "Silence mode has been enabled. Only users with PST permissions can speak!");
    }

    public void silenceDisabled() {
        this.player.sendMessage(PilzServerTools.pluginPrefix + ChatColor.YELLOW + "Silence mode has been disabled!");
    }
}
