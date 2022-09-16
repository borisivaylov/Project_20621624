package Exceptions;

public class StudentNotFoundException extends Exception
{
    public StudentNotFoundException()
    {
        super("There is no student with this id");
    }
}
