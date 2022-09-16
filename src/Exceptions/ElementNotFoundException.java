package Exceptions;

public class ElementNotFoundException extends Exception
{
    public ElementNotFoundException()
    {
        super("There is no such element!");
    }
}
