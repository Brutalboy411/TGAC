package me.terror.tgac.checks.events.combat;

import me.terror.tgac.checks.CheckResult;
import me.terror.tgac.checks.CheckType;
import me.terror.tgac.util.Distance;
import me.terror.tgac.util.User;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class WallHit
{
    private static final CheckResult PASS = new CheckResult(false, CheckType.WALLHIT, "");

    public static CheckResult runCheck(User user, Entity entity)
    {
        System.out.println("Loaded module: WallHit");
        Distance distance = new Distance(user.getPlayer().getLocation(), entity.getLocation());
        double x = distance.getXDifference();
        double z = distance.getZDifference();
        Player p = user.getPlayer();
        if ((x == 0.0D) || (z == 0.0D))
        {
            System.out.println("Warning! Positions are same");
            return PASS;
        }
        if (distance.getYDifference() >= 0.6D) {
            return PASS;
        }
        Location l = null;
        if ((x <= 0.5D) && (z >= 1.0D))
        {
            if (p.getLocation().getZ() > entity.getLocation().getZ()) {
                l = p.getLocation().clone().add(0.0D, 0.0D, -1.0D);
            } else {
                l = p.getLocation().clone().add(0.0D, 0.0D, 1.0D);
            }
        }
        else if ((z <= 0.5D) && (x >= 1.0D)) {
            if (p.getLocation().getX() > entity.getLocation().getX()) {
                l = p.getLocation().clone().add(-1.0D, 0.0D, 0.0D);
            } else {
                l = p.getLocation().clone().add(-1.0D, 0.0D, 0.0D);
            }
        }
        boolean failed = false;
        if (l != null) {
            failed = (l.getBlock().getType().isSolid()) && (l.clone().add(0.0D, 1.0D, 0.0D).getBlock().getType().isSolid());
        }
        return failed ? new CheckResult(true, CheckType.WALLHIT, "tried to hit" + (
                entity.getType() != EntityType.PLAYER ? " a" : "") + " " + entity.getName() + " through a wall") :
                PASS;
    }
}
