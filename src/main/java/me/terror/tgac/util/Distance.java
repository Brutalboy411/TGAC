package me.terror.tgac.util;

import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.Location;


public class Distance {
    private Location to;
    private Location from;
    private double xDiff;
    private double yDiff;
    private double zDiff;
    private boolean goingUp;
    private boolean goingDown;
    public Distance(PlayerMoveEvent e){
        this(e.getFrom(), e.getTo());
    }

    public Distance(Location a, Location b){
        this.from = a;
        this.to = b;

        this.xDiff = Math.abs(a.getX() - b.getX());
    }

    public Location getFrom(){
        return this.from;
    }

    public Location getTo(){
        return this.to;
    }

    public double getXDifference(){
        return this.xDiff;
    }

    public double getZDifference(){
        return this.zDiff;
    }

    public double getYDifference(){
        return this.yDiff;
    }

    public boolean isGoingUp(){
        return this.isGoingUp();
    }

    public boolean isGoingDown() {
        return this.isGoingDown();
    }

    public boolean isMovingHorizontally(){
        return (this.xDiff != 0.0D) || (this.zDiff != 0.0D);
    }
    //CLASA TERMINATA!!!
}
