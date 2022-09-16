package Exceptions;

public class NoSuchCommandException extends Exception
{
    public NoSuchCommandException()
    {
        super("This command doesn't exist!\n" +
                "To see a list of all supported commands type 'help'");
    }
}
