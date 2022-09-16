package CommandLine;

import Exceptions.*;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Student;

import java.io.IOException;
import java.util.Arrays;

public class XpathCompareCommand implements Command{
    @Override
    public void execute(Object[] args) throws IOException, FileNotOpenedException, EmptyFileException, StringAttributeException, ElementNotFoundException, ElementHasNoAttributeException, StudentNotFoundException, StringCantHaveAttributeException, DisciplineTextException, DeleteIdException, InvalidCommandFormatException, NoSuchCommandException, NotThatManyStudentsException, CantCompareException {

        if (!(args.length==2))
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
        String[] textArgsProcessing=new String[textProcessing.length];
        System.arraycopy(textProcessing,0,textArgsProcessing,0,textProcessing.length);
        String argsProcessing= String.join("",textArgsProcessing);
        String[] compareProcessing= textArgsProcessing[0].split("=");


        String elementId=textArgsProcessing[1];
        String elementCompareId=compareProcessing[0];
        String elementCompareValue=compareProcessing[1];
        //System.out.println(elementId+" "+elementCompareId+" "+elementCompareValue); // If error
        boolean elementFound=false;

        if (elementId.equalsIgnoreCase(elementCompareId))
        {
            throw new CantCompareException();
        }
        for(Student student : OpenCommand.fileData)
        {
            if (elementCompareId.equalsIgnoreCase("name"))
                 {
                    if (elementId.equalsIgnoreCase("age")&&student.getName().equalsIgnoreCase(elementCompareValue))
                        {
                            System.out.println("Student id:"+student.getId()+" age is "+ student.getAge());
                            elementFound=true;
                        }
                    else if(elementId.equalsIgnoreCase("discipline"))
                        {
                            System.out.println("Student id:"+student.getId()+" discipline is:\n "+ student.getDiscipline());
                            elementFound=true;
                        }
                     if (!elementFound && !student.values.isEmpty())
                     {
                         for (String string : student.values.keySet())
                         {
                             ChildWithAttribute childWithAttribute= (ChildWithAttribute) student.values.get(string);
                             if(string.equalsIgnoreCase(elementId))
                             {
                                 System.out.println("Student id:"+student.getId()+" "+childWithAttribute.getChildId()+ " is "+ childWithAttribute.getChildText());
                                 elementFound=true;
                             }
                         }
                     }
                 }
            else if (elementCompareId.equalsIgnoreCase("age"))
            {
                if (elementId.equalsIgnoreCase("name")&&student.getAge().equalsIgnoreCase(elementCompareValue))
                {
                    System.out.println("Student id:"+student.getId()+" name is "+ student.getName());
                    elementFound=true;
                }
                else if(elementId.equalsIgnoreCase("discipline")&&student.getAge().equalsIgnoreCase(elementCompareValue))
                {
                    System.out.println("Student id:"+student.getId()+" discipline is:\n "+ student.getDiscipline());
                    elementFound=true;
                }
                if (!elementFound && !student.values.isEmpty())
                {
                    for (String string : student.values.keySet())
                    {
                        ChildWithAttribute childWithAttribute= (ChildWithAttribute) student.values.get(string);
                        if(string.equalsIgnoreCase(elementId))
                        {
                            System.out.println("Student id:"+student.getId()+" "+childWithAttribute.getChildId()+ " is "+ childWithAttribute.getChildText());
                            elementFound=true;
                        }
                    }
                }
            }
            if (elementCompareId.equalsIgnoreCase("discipline"))
            {
                if (elementId.equalsIgnoreCase("name")&&student.discipline.getDiscName().equalsIgnoreCase(elementCompareValue))
                {
                    System.out.println("Student id:"+student.getId()+" name is "+ student.getName());
                    elementFound=true;
                }
                else if(elementId.equalsIgnoreCase("age")&&student.discipline.getDiscName().equalsIgnoreCase(elementCompareValue))
                {
                    System.out.println("Student id:"+student.getId()+" age is "+ student.getAge());
                    elementFound=true;
                }
                if (!elementFound && !student.values.isEmpty())
                {
                    for (String string : student.values.keySet())
                    {
                        ChildWithAttribute childWithAttribute= (ChildWithAttribute) student.values.get(string);
                        if(string.equalsIgnoreCase(elementId))
                        {
                            System.out.println("Student id:"+student.getId()+" "+childWithAttribute.getChildId()+ " is "+ childWithAttribute.getChildText());
                            elementFound=true;
                        }
                    }
                }
            }

        }
        if (!elementFound)
        {
            throw new ElementNotFoundException();
        }
    }
}
