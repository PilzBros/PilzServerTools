package com.pilzbros.PilzServerTools.help;

import com.pilzbros.PilzServerTools.PilzServerTools;
import com.pilzbros.PilzServerTools.structs.BoardManager;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

public class HelpScoreboardManager {
    private PilzServerTools pst;
    public BoardManager showQueue;
    public BoardManager dummy;

    public HelpScoreboardManager(PilzServerTools ref) {
        this.showQueue = new BoardManager("HelpMe", ChatColor.GREEN + "HelpMe", DisplaySlot.SIDEBAR);
        this.dummy = new BoardManager("test", "dummy", DisplaySlot.SIDEBAR);
        this.pst = ref;
    }

    public void displayHelpQueue() {
        this.showQueue.setObjectiveScore("Users", this.pst.helpQueue.size());
        Iterator var2 = Bukkit.getOnlinePlayers().iterator();

        while(true) {
            while(true) {
                Player p;
                do {
                    if (!var2.hasNext()) {
                        return;
                    }

                    p = (Player)var2.next();
                } while(!p.hasPermission("pst.*") && !p.hasPermission("pst.admin") && !p.hasPermission("PST.helper"));

                if (!this.pst.helpQueue.isEmpty()) {
                    this.showQueue.setScoreboard(p);
                } else {
                    String[] array = (String[])this.showQueue.getPlayers().toArray(new String[this.showQueue.getPlayers().size()]);

                    for(int i = 0; i < array.length; ++i) {
                        this.dummy.setScoreboard(Bukkit.getPlayer(array[i]));
                    }
                }
            }
        }
    }
}
