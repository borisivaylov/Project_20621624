package Exceptions;

public class FileNotOpenedException extends Exception
{
    public FileNotOpenedException()
    {
        super("File is not opened.");
    }
}
