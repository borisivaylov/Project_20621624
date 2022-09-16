package Exceptions;

public class CantCompareException extends Exception
{
    public CantCompareException()
    {
        super("Can't compare equal element ids!");
    }
}
