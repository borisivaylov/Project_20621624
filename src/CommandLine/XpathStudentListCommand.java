package CommandLine;

import Exceptions.*;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Student;

import java.io.IOException;

public class XpathStudentListCommand implements Command{
    @Override
    public void execute(Object[] args) throws IOException, FileNotOpenedException, EmptyFileException, StringAttributeException, ElementNotFoundException, ElementHasNoAttributeException, StudentNotFoundException, StringCantHaveAttributeException, DisciplineTextException, DeleteIdException, InvalidCommandFormatException, NoSuchCommandException {

        if (args.length==0)
        {
            throw new InvalidCommandFormatException();
        }

        if (!OpenCommand.opened)
        {
            throw new FileNotOpenedException();
        }
        else if(OpenCommand.fileData.isEmpty())
        {
            throw new EmptyFileException();
        }

        String elementId=args[0].toString();
        boolean elementFound=false;

        for (Student everyStudent: OpenCommand.fileData)
        {
            if(elementId.equalsIgnoreCase("name"))
            {
                System.out.println(" Student("+everyStudent.getId()+")  name is - "+everyStudent.getName());
                elementFound=true;
            }
            else if(elementId.equalsIgnoreCase("age"))
            {
                System.out.println(" Student("+everyStudent.getId()+")  age is - "+everyStudent.getAge());
                elementFound=true;
            }
            else if(elementId.equalsIgnoreCase("discipline"))
            {
                System.out.println(" Student("+everyStudent.getId()+")  discipline is :\n"+"        "+everyStudent.getDiscipline());
                elementFound=true;
            }
            else if(!everyStudent.values.isEmpty())
            {
                for (String string:everyStudent.values.keySet())
                {
                    if (string.equalsIgnoreCase(elementId))
                    {
                        ChildWithAttribute childWithAttribute= (ChildWithAttribute) everyStudent.values.get(string);
                        System.out.println(" Student("+everyStudent.getId()+")" + string + " is: "+childWithAttribute.getChildText());
                        elementFound=true;
                    }
                }
            }
            if (!elementFound)
            {
                throw new ElementNotFoundException();
            }

        }



    }
}
