package CommandLine;

import Exceptions.*;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Student;

import java.io.IOException;

public class XpathAttributeListCommand implements Command
{
    @Override
    public void execute(Object[] args) throws IOException, FileNotOpenedException, EmptyFileException, StringAttributeException, ElementNotFoundException, ElementHasNoAttributeException, StudentNotFoundException, StringCantHaveAttributeException, DisciplineTextException, DeleteIdException, InvalidCommandFormatException, NoSuchCommandException, NotThatManyStudentsException
    {
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
        Student student;
        ChildWithAttribute childWithAttribute=null;
        boolean elementFound=false;

        if((elementId.equalsIgnoreCase("name")||elementId.equalsIgnoreCase("age")))
        {
            throw new StringAttributeException();
        }
        else if (elementId.equalsIgnoreCase("discipline"))
        {
            for (Student everyStudent : OpenCommand.fileData)
            {

                if (!(everyStudent.discipline.getAttributeName()==null))
                {
                    System.out.println("id="+everyStudent.getId()+" discipline attribute is "+everyStudent.discipline.getAttributeName()+"="+everyStudent.discipline.getAttributeValue());
                    elementFound=true;
                }
                else
                {
                    System.out.println("id="+everyStudent.getId()+" discipline attribute is not set");
                    elementFound=true;
                }
            }
        }
        else
        {
            for (Student everyStudent : OpenCommand.fileData)
            {
               for (String string:everyStudent.values.keySet())
               {
                   if (elementId.equalsIgnoreCase(string))
                   {
                       childWithAttribute= (ChildWithAttribute) everyStudent.values.get(elementId);
                       System.out.println("id="+everyStudent.getId()+" "+childWithAttribute.getAttributeName()+"="+childWithAttribute.getAttributeValue());
                       elementFound=true;
                   }
               }
            }
        }
        if(!elementFound)
        {
            throw new ElementNotFoundException();
        }
    }
}
