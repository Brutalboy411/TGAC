package me.terror.tgac.checks.events.movement;

import me.terror.tgac.checks.CheckResult;
import me.terror.tgac.checks.CheckType;
import me.terror.tgac.checks.MoveCheck;
import me.terror.tgac.util.Distance;
import me.terror.tgac.util.MovementUtil;
import me.terror.tgac.util.User;

public class Glide
        extends MoveCheck
{
    public static final CheckResult PASS = new CheckResult(false, CheckType.GLIDE, "");

    public Glide()
    {
        super(CheckType.GLIDE);
    }

    public CheckResult runCheck(User user, Distance distance)
    {
        double oldY = user.oldY;

        user.oldY = distance.getYDifference();
        if (distance.getFrom().getY() > distance.getTo().getY())
        {
            if ((oldY >= distance.getYDifference()) && (oldY != 0.0D) && (!MovementUtil.shouldNotFlag(distance.getTo()))) {
                return new CheckResult(true, CheckType.GLIDE, "tried to glide; " + oldY + " <= " + user.oldY);
            }
        }
        else {
            user.oldY = 0.0D;
        }
        return PASS;
    }
}