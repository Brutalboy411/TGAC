package me.terror.tgac.checks.events.combat;

import me.terror.tgac.checks.CheckResult;
import me.terror.tgac.checks.CheckType;
import me.terror.tgac.util.User;
import org.bukkit.entity.Entity;

public class MultiAura
{
    private static final CheckResult PASS = new CheckResult(false, CheckType.MULTIAURA, "");

    public static CheckResult runCheck(User user, Entity entity)
    {
        user.addEntity(entity.getEntityId());
        int entities = user.getEntities();
        return entities > 6 ? new CheckResult(true, CheckType.MULTIAURA, "tried to hit: " + entities + " different entities max(" + 6 + ")") : PASS;
    }
}

