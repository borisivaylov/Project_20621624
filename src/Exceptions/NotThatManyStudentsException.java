package Exceptions;

public class NotThatManyStudentsException extends Exception
{
    public NotThatManyStudentsException()
    {
        super("There are not that many students in this file.");
    }
}
