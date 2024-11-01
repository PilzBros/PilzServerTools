package com.pilzbros.PilzServerTools;

import com.pilzbros.PilzServerTools.command.PilzCommandExc;
import com.pilzbros.PilzServerTools.help.Help;
import com.pilzbros.PilzServerTools.help.HelpMe;
import com.pilzbros.PilzServerTools.help.HelpScoreboardManager;
import com.pilzbros.PilzServerTools.structs.Queue;
import com.pilzbros.PilzServerTools.listener.PilzListener;
import com.pilzbros.PilzServerTools.lockdown.Lockdown;
import com.pilzbros.PilzServerTools.memory.MemoryManager;
import com.pilzbros.PilzServerTools.plugin.InputOutput;
import com.pilzbros.PilzServerTools.plugin.Setting;
import com.pilzbros.PilzServerTools.plugin.Settings;
import com.pilzbros.PilzServerTools.plugin.Update;
import com.pilzbros.PilzServerTools.runnable.HelpRunnable;
import com.pilzbros.PilzServerTools.silence.Silence;
import com.pilzbros.PilzServerTools.supervise.Supervise;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PilzServerTools extends JavaPlugin implements Listener {
    public static final String pluginName = "PilzServerTools";
    public static final String pluginVersion = "2.3";
    public static final String pluginPrefix;
    public boolean maintenanceMode;
    public boolean silenceMode;
    public boolean lockdown;
    public HelpMe helpMe = new HelpMe(this);
    public Queue<CommandSender> helpQueue = new Queue();
    public static HelpScoreboardManager manager;
    public static MemoryManager memory;
    public boolean updateNeeded;
    public static PilzServerTools instance;
    public static Logger log;
    public InputOutput IO;

    static {
        pluginPrefix = ChatColor.GREEN + "[PST] ";
        log = Logger.getLogger("Minecraft");
    }

    public void onEnable() {
        this.getLogger().info("PilzServerTools v2.3 startup has been initiated...");
        instance = this;
        this.maintenanceMode = false;
        this.silenceMode = false;
        this.lockdown = false;
        this.IO = new InputOutput(this);
        manager = new HelpScoreboardManager(this);
        memory = new MemoryManager();
        Bukkit.getServer().getPluginManager().registerEvents(new PilzListener(this), this);
        this.getCommand("pst").setExecutor(new PilzCommandExc(this));
        this.getCommand("helpme").setExecutor(new Help(this));
        this.getCommand("supervise").setExecutor(new Supervise(this));
        this.getCommand("silence").setExecutor(new Silence(this));
        this.getCommand("lockdown").setExecutor(new Lockdown(this));
        this.IO.LoadSettings();
        if (Settings.getGlobalBoolean(Setting.CheckForUpdates)) {
            new Update(69622, "", this);
        }

        Bukkit.getScheduler().runTaskTimer(this, new HelpRunnable(), 20L, 20L);
    }

    public void onDisable() {
    }

    public void updateMaintenance(boolean setting) {
        this.maintenanceMode = setting;
    }

    public boolean getMaintenance() {
        return this.maintenanceMode;
    }
}