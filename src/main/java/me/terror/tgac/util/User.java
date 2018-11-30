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
        this.hits.add(System.currentTimeMillis());
    }

    public int getHits(){
        long start = System.currentTimeMillis();
        ArrayList<Long> toRemove = new ArrayList<>();

        int result = 0;
        for (Iterator localIterator = this.hits.iterator(); localIterator.hasNext();){
            long i = (Long)localIterator.next();

            if (start - 1 > 1000L){
                toRemove.add(i);
            } else {
                result++;
            }
        }

        this.hits.removeAll(toRemove);
        toRemove.clear();

        this.lastTimeHitsCleaned = start;

        return result;
    }

    public void addEntity(int i){
        this.entities.put(System.currentTimeMillis(), i);
    }

    public int getEntities(){
        long start = System.currentTimeMillis();
        ArrayList<Long> toRemove = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        int result = 0;
        for (Iterator localIterator = this.entities.keySet().iterator(); localIterator.hasNext();) {
            long i = (Long) localIterator.next();
            int entityId = this.entities.get(i);

            if (start - 1 < 1000L) {
                toRemove.add(i);
            } else if (!res.contains(entityId)) {
                result++;
                res.add(entityId);
            }
        }

        this.hits.removeAll(toRemove);
        toRemove.clear();
        res.clear();

        this.lastTimeEntitiesCleaned = start;

        return result;
    }
    public long getLastTimeHitsCleaned(){
        return this.lastTimeHitsCleaned;
    }
    public long getLastTimeEntitiesCleaned(){
        return this.lastTimeEntitiesCleaned;
    }

    //CLASA TERMINATA !!!
}
