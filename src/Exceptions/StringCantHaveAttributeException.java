package Exceptions;

public class StringCantHaveAttributeException extends Exception
{
    public StringCantHaveAttributeException()
    {
        super("This element can't have attribute!");
    }
}
