package com.pilzbros.PilzServerTools.lockdown;

import com.pilzbros.PilzServerTools.PilzServerTools;
import com.pilzbros.PilzServerTools.messages.GlobalMessages;
import com.pilzbros.PilzServerTools.plugin.Setting;
import com.pilzbros.PilzServerTools.plugin.Settings;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lockdown implements CommandExecutor {
    PilzServerTools pst;

    public Lockdown(PilzServerTools pstref) {
        this.pst = pstref;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        GlobalMessages gm = new GlobalMessages(this.pst, sender);
        if (!sender.hasPermission("PST.*") && !sender.hasPermission("PST.admin")) {
            gm.permissionError();
        } else {
            Player p;
            Iterator var7;
            if (this.pst.lockdown) {
                this.pst.lockdown = false;
                var7 = Bukkit.getServer().getOnlinePlayers().iterator();

                while(var7.hasNext()) {
                    p = (Player)var7.next();
                    p.sendMessage(PilzServerTools.pluginPrefix + ChatColor.GREEN + Settings.getGlobalString(Setting.LockdownDisableMessage));
                }
            } else {
                this.pst.lockdown = true;
                var7 = Bukkit.getServer().getOnlinePlayers().iterator();

                while(var7.hasNext()) {
                    p = (Player)var7.next();
                    p.sendMessage(PilzServerTools.pluginPrefix + ChatColor.RED + Settings.getGlobalString(Setting.LockdownEnableMessage));
                }
            }
        }

        return true;
    }
}