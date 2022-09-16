package Exceptions;

public class StringAttributeException extends Exception
{
    public StringAttributeException()
    {
        super("This element has no attribute");
    }
}
