package me.terror.tgac;

import me.terror.tgac.util.User;
import org.bukkit.scheduler.BukkitRunnable;

public class Cleaner extends BukkitRunnable {

    public void run()
    {
        for (User user : MainClass.USERS.values())
        {
            user.getHits();
            user.getEntities();
        }
    }
}
