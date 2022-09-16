package OtherCommands;

import CommandLine.Command;
import CommandLine.OpenCommand;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Student;

import java.io.IOException;
import java.util.Arrays;

public class SetTextCommand implements Command
{

    @Override
    public void execute(Object[] args) throws IOException
    {
        String studentId=args[0].toString();
        String elementId=args[1].toString();

        String[] textProcessing=Arrays.copyOf(args,args.length,String[].class);
        String[] textValueProcessing=new String[textProcessing.length-2];
        System.arraycopy(textProcessing,2,textValueProcessing,0,textProcessing.length-2);
        String textValue= String.join(" ",textValueProcessing);



        boolean findStudent=false;
        Student foundStudent = null;
        boolean foundElement=false;

        for (Student fileDatum : OpenCommand.fileData) {    //Searching by id

            if (fileDatum.getId().equalsIgnoreCase(studentId)) {
                findStudent=true;
                foundStudent = fileDatum;
            }
        }

        if (!findStudent)
        {
            System.out.println("No student found.");
        }
        else if(elementId.equalsIgnoreCase("name"))
        {
            foundStudent.setName(textValue);
        }
        else if(elementId.equalsIgnoreCase("age"))
        {
            foundStudent.setAge(textValue);
        }
        else if (elementId.equalsIgnoreCase("discipline"))
        {
            System.out.println("Discipline can't have text");
        }
        else if(!foundStudent.values.isEmpty())
        {
            ChildWithAttribute childWithAttribute=null;
            for (String string:foundStudent.values.keySet())
            {
                if(string.equalsIgnoreCase(elementId))
                {
                    childWithAttribute= (ChildWithAttribute) foundStudent.values.get(string);
                    //System.out.println(childWithAttribute.getAttributeName()+"="+childWithAttribute.getAttributeValue());
                    foundElement=true;

                }

            }
            if (foundElement)
            {
                childWithAttribute.setChildText(textValue);
                foundStudent.values.put(elementId,childWithAttribute);
                System.out.println("Ok");
            }

        }
    }

}
