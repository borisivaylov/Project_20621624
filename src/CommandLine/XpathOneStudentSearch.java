package CommandLine;

import Exceptions.*;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Student;

import java.io.IOException;
import java.util.Arrays;

public class XpathOneStudentSearch implements Command{
    @Override
    public void execute(Object[] args) throws IOException, FileNotOpenedException, EmptyFileException, StringAttributeException, ElementNotFoundException, ElementHasNoAttributeException, StudentNotFoundException, StringCantHaveAttributeException, DisciplineTextException, DeleteIdException, InvalidCommandFormatException, NoSuchCommandException, NotThatManyStudentsException {

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

        String[] textProcessing= Arrays.copyOf(args,args.length,String[].class);
        String[] textValueProcessing=new String[textProcessing.length];
        System.arraycopy(textProcessing,0,textValueProcessing,0,textProcessing.length);
        String argsProcessing= String.join("",textValueProcessing);
        String[] argsReady = argsProcessing.split("\\[+");
        String[] trueNumberArr=argsReady[1].split("]");

        int trueNumber=Integer.parseInt(trueNumberArr[0]);
        String elementId= argsReady[0];
        argsReady=elementId.split("/");
        elementId= argsReady[0];

        Student student;
        boolean elementFound=false;


        if (OpenCommand.fileData.size()<trueNumber)
        {
            throw new NotThatManyStudentsException();
        }
        else
        {
            student=OpenCommand.fileData.get(trueNumber-1);
        }

        if(elementId.equalsIgnoreCase("name"))
        {
            System.out.println("id="+student.getId()+" name is "+student.getName());
            elementFound=true;
        }
        else if(elementId.equalsIgnoreCase("age"))
        {
            System.out.println("id="+student.getId()+" age is "+student.getAge());
            elementFound=true;
        }
        else if(elementId.equalsIgnoreCase("discipline"))
        {
            System.out.println("id="+student.getId()+" discipline is:\n "+student.getDiscipline());
            elementFound=true;
        }
        else if (!student.values.isEmpty())
        {
            for( String string:student.values.keySet())
            {
                if (string.equalsIgnoreCase(elementId))
                {
                    ChildWithAttribute childWithAttribute= (ChildWithAttribute) student.values.get(string);
                    System.out.println("id="+student.getId()+" "+childWithAttribute.getChildId() +" is: \n "+childWithAttribute);
                    elementFound=true;
                }
            }
        }

        if(!elementFound)
        {
            throw new ElementNotFoundException();
        }
    }
}
