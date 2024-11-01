package com.pilzbros.PilzServerTools.listener;

import com.pilzbros.PilzServerTools.PilzServerTools;
import com.pilzbros.PilzServerTools.plugin.Setting;
import com.pilzbros.PilzServerTools.plugin.Settings;
import com.pilzbros.PilzServerTools.server.Login;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PilzListener implements Listener {
    PilzServerTools pst;

    public PilzListener(PilzServerTools ref) {
        this.pst = ref;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent evt) {
        Player player = evt.getPlayer();
        Login login = new Login(player, this.pst);
        login.checkMaintenanceMode();
        if (player.hasPermission("PST.*") || player.hasPermission("PST.admin")) {
            login.checkHelpQueue();
            if (this.pst.updateNeeded && Settings.getGlobalBoolean(Setting.NotifyOnNewUpdates)) {
                player.sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.YELLOW + "There is a new version of PilzServerTools available for update! Please update to get the newest features & bug fixes!");
            }

            if (Settings.getGlobalBoolean(Setting.NotifyOnAustinPilz) && player.getName().equalsIgnoreCase("austinpilz")) {
                Iterator var5 = Bukkit.getServer().getOnlinePlayers().iterator();

                while(var5.hasNext()) {
                    Player p = (Player)var5.next();
                    p.sendMessage(PilzServerTools.pluginPrefix + ChatColor.AQUA + "PST plugin creator austinpilz has just joined the server!");
                }
            }
        }

    }

    @EventHandler
    public void onPlayerLeave(PlayerJoinEvent evt) {
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (this.pst.lockdown && (!event.getPlayer().hasPermission("pst.*") || !event.getPlayer().hasPermission("pst.admin")) && Settings.getGlobalBoolean(Setting.LockdownDisableMovement)) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(PilzServerTools.pluginPrefix + ChatColor.RED + "Movement is disabled during lockdown!");
        }

    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (this.pst.silenceMode) {
            if (!event.getPlayer().hasPermission("pst.*") && !event.getPlayer().hasPermission("pst.admin")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(PilzServerTools.pluginPrefix + ChatColor.RED + Settings.getGlobalString(Setting.SilenceModeMessage));
            } else {
                event.getPlayer().sendMessage(PilzServerTools.pluginPrefix + ChatColor.YELLOW + "Note: Silence mode in on. Other plays cannot speak");
            }
        } else if (this.pst.lockdown && (!event.getPlayer().hasPermission("pst.*") || !event.getPlayer().hasPermission("pst.admin")) && Settings.getGlobalBoolean(Setting.LockdownDisableChat)) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(PilzServerTools.pluginPrefix + ChatColor.RED + "Chat is disabled during lockdown!");
        }

    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled()) {
            if (!event.getMessage().toLowerCase().equalsIgnoreCase("/?") && !event.getMessage().toLowerCase().equalsIgnoreCase("/pl") && !event.getMessage().toLowerCase().equalsIgnoreCase("/plugins") && !event.getMessage().toLowerCase().equalsIgnoreCase("/ver") && !event.getMessage().toLowerCase().equalsIgnoreCase("/version")) {
                if (event.getMessage().toLowerCase().startsWith("/reload") && Settings.getGlobalBoolean(Setting.ReloadAlert)) {
                    Iterator var3 = Bukkit.getServer().getOnlinePlayers().iterator();

                    while(var3.hasNext()) {
                        Player player = (Player)var3.next();
                        player.sendMessage(PilzServerTools.pluginPrefix + ChatColor.YELLOW + Settings.getGlobalString(Setting.ReloadAlertMessage));
                    }
                }
            } else if (!event.getPlayer().hasPermission("pst.*") && !event.getPlayer().hasPermission("pst.admin")) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.GREEN + PilzServerTools.pluginPrefix + ChatColor.RED + "This command his been disabled by Pilz Server Tools");
            }

            if (this.pst.lockdown && (!event.getPlayer().hasPermission("pst.*") || !event.getPlayer().hasPermission("pst.admin")) && Settings.getGlobalBoolean(Setting.LockdownDisableCommands)) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(PilzServerTools.pluginPrefix + ChatColor.RED + "Commands are disabled during lockdown!");
            }

        }
    }
}
