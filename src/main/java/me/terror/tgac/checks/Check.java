package me.terror.tgac.checks;


public abstract class Check
{
    protected final CheckType type;
    protected CancelType cancelType;

    public Check(CheckType type)
    {
        this.type = type;
        this.cancelType = CancelType.EVENT;
    }

    public CheckType getType()
    {
        return this.type;
    }

    public CancelType getCancelType()
    {
        return this.cancelType;
    }



}
