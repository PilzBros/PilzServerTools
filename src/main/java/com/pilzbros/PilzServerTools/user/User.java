package com.pilzbros.PilzServerTools.user;

import com.pilzbros.PilzServerTools.PilzServerTools;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class User {
    private Player player;
    PilzServerTools pst = new PilzServerTools();

    public User() {
        this.player = null;
    }

    public User(Player user, CommandSender s) {
        this.player = user;
    }

    public void test() {
        this.player.isBanned();
        this.player.isDead();
        this.player.isEmpty();
        this.player.isFlying();
        this.player.isInsideVehicle();
        this.player.isOnline();
        this.player.isSleeping();
        this.player.isWhitelisted();
        this.player.getDisplayName();
        this.player.getFirstPlayed();
        this.player.getFlySpeed();
        this.player.getFoodLevel();
        this.player.getGameMode();
        this.player.getHealth();
        this.player.getLevel();
    }
}
