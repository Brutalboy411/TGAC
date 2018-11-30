package me.terror.tgac.checks.events.combat;

import me.terror.tgac.checks.CheckResult;
import me.terror.tgac.checks.CheckType;
import me.terror.tgac.util.User;
import org.bukkit.entity.Entity;

public class HitSpeed {
    private static final CheckResult PASS = new CheckResult(false, CheckType.HITSPEED, "");

    public static CheckResult runCheck(User user, Entity entity)
    {
        user.addHit();
        int hits = user.getHits() * 2;

        user.getPlayer().sendMessage("Hits: " + hits);
        if (hits > 15) {
            return new CheckResult(true, CheckType.HITSPEED, "tried to hit " + user.getHits() + " times per second!");
        }
        return PASS;
    }
}
