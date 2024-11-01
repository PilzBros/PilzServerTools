package com.pilzbros.PilzServerTools.help;

import com.pilzbros.PilzServerTools.PilzServerTools;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpMeCommands implements CommandExecutor {
    private PilzServerTools pst;

    public HelpMeCommands(PilzServerTools pst) {
        this.pst = pst;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        new HelpMessages(this.pst, sender);
        if (!sender.hasPermission("PST.*") && !sender.hasPermission("PST.admin") && !sender.hasPermission("PST.helper")) {
            if (sender.hasPermission("PST.user")) {
                if (!this.pst.helpQueue.inQueue(sender)) {
                    this.pst.helpQueue.enqueue(sender);
                    sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + "You're now " + this.pst.helpQueue.size() + " in the help queue");
                    this.notifyOPs();
                } else {
                    sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + "You are already in the help queue!");
                }

                return true;
            } else {
                return true;
            }
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("clear")) {
                this.pst.helpQueue.clear();
                sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + "The help queue has been cleared!");
            }

            return true;
        } else {
            if (!this.pst.helpQueue.isEmpty()) {
                Player player = (Player)this.pst.helpQueue.dequeue();
                Player admin = (Player)sender;
                Location location = player.getLocation();
                if (player.isOnline()) {
                    admin.teleport(location);
                    sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + "You are now helping " + ChatColor.AQUA + player.getDisplayName());
                } else {
                    sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + "Requested user is no longer online");
                }

                if (this.pst.helpQueue.isEmpty()) {
                    sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + "There are no users more in the help queue!");
                } else {
                    sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + "There are " + this.pst.helpQueue.size() + " more user(s) in the help queue");
                }
            } else {
                sender.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + "There are no users in the help queue!");
            }

            return true;
        }
    }

    private void notifyOPs() {
        Iterator var2 = Bukkit.getOnlinePlayers().iterator();

        while(true) {
            Player p;
            do {
                if (!var2.hasNext()) {
                    return;
                }

                p = (Player)var2.next();
            } while(!p.hasPermission("pst.*") && !p.hasPermission("pst.admin"));

            p.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.WHITE + this.pst.helpQueue.size() + " users are in the help queue!");
        }
    }
}
