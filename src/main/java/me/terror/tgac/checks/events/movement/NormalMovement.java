package me.terror.tgac.checks.events.movement;

import me.terror.tgac.checks.CancelType;
import me.terror.tgac.checks.CheckResult;
import me.terror.tgac.checks.CheckType;
import me.terror.tgac.checks.MoveCheck;
import me.terror.tgac.util.*;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NormalMovement
        extends MoveCheck
{
    public static final CheckResult PASS = new CheckResult(false, CheckType.NORMALMOVEMENTS, "");

    public NormalMovement()
    {
        super(CheckType.NORMALMOVEMENTS);
        this.cancelType = CancelType.NOTHING;
    }

    public CheckResult runCheck(User user, Distance distance)
    {
        if ((!distance.isGoingUp()) || (distance.getYDifference() == 0.0D))
        {
            user.wasGoingUp = false;
            user.oldYModifier = 0;
            user.ticksUp = 0;
            return PASS;
        }
        user.wasGoingUp = true;
        int ticksUp = user.ticksUp;
        user.ticksUp += 1;
        user.oldTicksUp = ticksUp;

        double speed = Settings.round(distance.getYDifference());

        int id = getYModifier(user);
        if (id > user.oldYModifier) {
            user.oldYModifier = id;
        }
        id = user.oldYModifier;
        YMap map = YMap.get(id);
        if ((distance.isGoingUp()) && (distance.isMovingHorizontally()))
        {
            boolean step = (MovementUtil.isStepping(distance.getFrom())) || (MovementUtil.isStepping(distance.getTo()));
            boolean yMap = (map != null) && (map.contains(speed));
            debug(Boolean.valueOf(yMap));
            if (step)
            {
                if (speed > 0.5D) {
                    return new CheckResult(true, CheckType.NORMALMOVEMENTS, "reason: step, type: " + (speed > 0.5D ? "high" : "low") + ", y: " + speed);
                }
                return PASS;
            }
        }
        if (map == null)
        {
            Bukkit.getLogger().warning("Modifier '" + id + "' has no contents!");
            return PASS;
        }
        if (!map.hasSpeed(ticksUp)) {
            return new CheckResult(true, CheckType.NORMALMOVEMENTS, "reason: long, s: " + ticksUp + ", m: " + map.size());
        }
        if ((map.size() <= ticksUp) && (
                (id == 0) || (!distance.isMovingHorizontally()) || (map.size() != ticksUp) || (speed != map.getSpeed(ticksUp).doubleValue()))) {
            new CheckResult(true, CheckType.NORMALMOVEMENTS, "reason: too high (ticksUp: " + ticksUp + ", max: " + (map.size() - 1));
        }
        if (map.size() < ticksUp) {
            return PASS;
        }
        double expected = map.getSpeed(ticksUp).doubleValue();
        if (expected != speed) {
            return new CheckResult(true, CheckType.NORMALMOVEMENTS, "reason: normal, type: " + (expected < speed ? "high" : "low") + " (speed: " + speed + ", expected: " + expected);
        }
        return PASS;
    }

    public int getYModifier(User user)
    {
        if (user.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) {
            for (PotionEffect pe : user.getPlayer().getActivePotionEffects()) {
                if (pe.getType().equals(PotionEffectType.JUMP)) {
                    return pe.getAmplifier() + 1;
                }
            }
        }
        return 0;
    }
}

