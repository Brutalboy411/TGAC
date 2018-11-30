package me.terror.tgac.checks.events;

import me.terror.tgac.MainClass;
import me.terror.tgac.checks.CheckResult;
import me.terror.tgac.checks.MoveCheck;
import me.terror.tgac.checks.events.movement.Glide;
import me.terror.tgac.checks.events.movement.NormalMovement;
import me.terror.tgac.util.Distance;
import me.terror.tgac.util.User;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class CheckManager implements Listener {
    private ArrayList<MoveCheck> moveChecks;

    public CheckManager()
    {
        this.moveChecks = new ArrayList();
        String splitter = "-======================-";
        Bukkit.getLogger().info(splitter);
        Bukkit.getLogger().info("\t\tTGAC");
        Bukkit.getLogger().info(splitter);
        Bukkit.getLogger().info("\tVersion: " + ((MainClass)MainClass.getPlugin(MainClass.class)).getDescription().getVersion());
        Bukkit.getLogger().info("\tAuthor: BrutalBoy, GamerRO28");
        Bukkit.getLogger().info(splitter);
        Bukkit.getLogger().info(" ");
        Bukkit.getLogger().info(splitter);
        Bukkit.getLogger().info("\t   Check Manager");
        Bukkit.getLogger().info(splitter);
        Bukkit.getLogger().info("\tMovement Checks:");
        addCheck(new Glide());
        addCheck(new NormalMovement());

        Bukkit.getLogger().info(splitter);
    }

    private void addCheck(MoveCheck moveCheck)
    {
        this.moveChecks.add(moveCheck);
        Bukkit.getLogger().info("\t" + moveCheck.getType().getName() + " has been enabled.");
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e)
    {
        User user = MainClass.getUser(e.getPlayer());
        Distance distance = new Distance(e);
        for (MoveCheck check : this.moveChecks) {
            if (MainClass.shouldCheck(user, check.getType()))
            {
                CheckResult result = check.runCheck(user, distance);
                if (result.failed())
                {
                    MainClass.log(user, result);
                    switch (check.getCancelType())
                    {
                        case EVENT:
                            e.setTo(e.getFrom());
                            break;
                        case NOTHING:

                    }
                }
            }
        }
    }
}
