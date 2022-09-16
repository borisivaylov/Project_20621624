package Exceptions;

public class InvalidCommandFormatException extends Exception
{
    public InvalidCommandFormatException()
    {
        super("The command was used incorrectly");
    }
}
