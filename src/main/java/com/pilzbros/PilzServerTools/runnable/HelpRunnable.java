package com.pilzbros.PilzServerTools.runnable;

import com.pilzbros.PilzServerTools.PilzServerTools;
import org.bukkit.scheduler.BukkitRunnable;

public class HelpRunnable extends BukkitRunnable {
    public void run() {
        PilzServerTools.manager.displayHelpQueue();
    }
}
