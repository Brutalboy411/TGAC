package me.terror.tgac.util;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class User {
    public Player player ;
    public double oldY = 0.0D;
    private ArrayList<Long> hits = new ArrayList<>();
    private HashMap<Long, Integer> entities = new HashMap<>();
    private long lastTimeHitsCleaned = 0L;
    private long lastTimeEntitiesCleaned = 0L;
    public boolean wasGoingUp = false;
    public int oldYModifier = 0;
    public int ticksUp = 0;
    public int oldTicksUp = 0;

    public User(Player player){
        this.player = player;
    }
    public Player getPlayer(){
        return this.player;
    }

    public void addHit(){
        this.hits.add(Long.valueOf(System.currentTimeMillis()));
    }

    public int getHits(){
        long start = System.currentTimeMillis();
        ArrayList<Long> toRemove = new ArrayList<>();
        int result = 0;
        for (Iterator localIterator = this.hits.iterator(); localIterator.hasNext();){
            long 1 = ((Long)localIterator.next()).longValue();
            if (start - 1 > 1000L){
                toRemove.add(Long.valueOf());
            }else {
                result++;
            }
        }
        this.hits.removeAll(toRemove);
        toRemove.clear();
        this.lastTimeHitsCleaned = start;
        return result;
    }

    public void addEntity(int i){
        this.entities.put(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
    }

    public int getEntities(){
        long start = System.currentTimeMillis();
        ArrayList<Long>
    }

}
