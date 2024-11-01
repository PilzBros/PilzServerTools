package com.pilzbros.PilzServerTools.silence;

import com.pilzbros.PilzServerTools.PilzServerTools;
import com.pilzbros.PilzServerTools.messages.GlobalMessages;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Silence implements CommandExecutor {
    private PilzServerTools pst;

    public Silence(PilzServerTools pst) {
        this.pst = pst;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        GlobalMessages gm = new GlobalMessages(this.pst, sender);
        SilenceMessages sm = new SilenceMessages(this.pst, sender);
        if (!sender.hasPermission("PST.*") && !sender.hasPermission("PST.admin")) {
            gm.permissionError();
        } else if (this.pst.silenceMode) {
            this.pst.silenceMode = false;
            sm.silenceDisabled();
        } else {
            this.pst.silenceMode = true;
            sm.silenceEnabled();
            Iterator var8 = Bukkit.getServer().getOnlinePlayers().iterator();

            while(true) {
                Player p;
                do {
                    if (!var8.hasNext()) {
                        return true;
                    }

                    p = (Player)var8.next();
                } while(p.hasPermission("PST.*") && p.hasPermission("PST.admin"));

                p.sendMessage(PilzServerTools.pluginPrefix + ChatColor.YELLOW + "Silence mode has been enabled, which disables chat for all players");
            }
        }

        return true;
    }
}
