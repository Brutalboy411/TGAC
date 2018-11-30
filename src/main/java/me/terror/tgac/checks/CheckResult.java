package me.terror.tgac.checks;


public class CheckResult
{
    private boolean failed;
    private CheckType type;
    private String message;

    public CheckResult(boolean failed, CheckType type, String message)
    {
        this.failed = failed;
        this.type = type;
        this.message = message;
    }

    public boolean failed()
    {
        return this.failed;
    }

    public CheckType getType()
    {
        return this.type;
    }

    public String getMessage()
    {
        return this.message;
    }
}