package me.terror.tgac.checks.events.combat;

import me.terror.tgac.checks.CheckResult;
import me.terror.tgac.checks.CheckType;
import me.terror.tgac.util.Distance;
import me.terror.tgac.util.User;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;

public class Reach
{
    private static final CheckResult PASS = new CheckResult(false, CheckType.REACH, "");

    public static CheckResult runCheck(User user, Entity entity)
    {
        Distance distance = new Distance(user.getPlayer().getLocation(), entity.getLocation());
        double x = distance.getXDifference();
        double z = distance.getZDifference();

        double max = user.getPlayer().getGameMode() == GameMode.CREATIVE ? 5.25D : 3.7D;
        if ((x > max) || (z > max)) {
            return new CheckResult(true, CheckType.REACH, (x > z ? x + " is " : z > max ? "both are " : new StringBuilder(String.valueOf(z)).append(" is ").toString()) + "greather than " + max);
        }
        return PASS;
    }
}