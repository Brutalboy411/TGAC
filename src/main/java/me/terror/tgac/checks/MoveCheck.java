package me.terror.tgac.checks;

import me.terror.tgac.util.Distance;
import me.terror.tgac.util.User;

public abstract class MoveCheck
        extends Check
{
    public MoveCheck(CheckType type)
    {
        super(type);
    }

    public abstract CheckResult runCheck(User paramUser, Distance paramDistance);
}