package Exceptions;

public class ElementHasNoAttributeException extends Exception
{
    public ElementHasNoAttributeException()
    {
        super("This element has no attribute");
    }
}
