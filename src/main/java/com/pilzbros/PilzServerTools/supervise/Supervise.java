package com.pilzbros.PilzServerTools.supervise;

import com.pilzbros.PilzServerTools.PilzServerTools;
import com.pilzbros.PilzServerTools.messages.GlobalMessages;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Supervise implements CommandExecutor {
    private PilzServerTools pst;

    public Supervise(PilzServerTools ref) {
        this.pst = ref;
    }

    private void enterSupervisor(CommandSender admin, Player player) {
        Player a = Bukkit.getPlayer(admin.getName());
        Bukkit.getServer().dispatchCommand(admin, "v");
        a.teleport(player.getLocation());
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        GlobalMessages gm = new GlobalMessages(this.pst, sender);
        SuperviseMessages sm = new SuperviseMessages(this.pst, sender);
        if (!sender.hasPermission("PST.*") && !sender.hasPermission("PST.admin")) {
            gm.permissionError();
        } else if (args.length < 1) {
            sm.description();
        } else if (args.length == 1) {
            OfflinePlayer offPl = Bukkit.getServer().getOfflinePlayer(args[0]);
            if (offPl.hasPlayedBefore()) {
                if (offPl.isOnline()) {
                    if (offPl != sender) {
                        this.enterSupervisor(sender, (Player)offPl);
                        sm.nowSupervising(args[0]);
                    } else {
                        sm.superviseYourself();
                    }
                } else {
                    sm.notOnline(args[0]);
                }
            } else {
                sm.neverPlayedBefore(args[0]);
            }
        } else {
            sm.syntaxError();
        }

        return true;
    }
}
