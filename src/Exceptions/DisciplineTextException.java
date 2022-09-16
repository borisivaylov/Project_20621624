package Exceptions;

public class DisciplineTextException extends Exception
{
    public DisciplineTextException()
    {
        super("Discipline can't have text");
    }
}
