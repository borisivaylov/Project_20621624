package CommandLine;

import Exceptions.*;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Student;

import java.io.IOException;
import java.lang.reflect.Field;

public class SelectAtribbuteCommand implements Command
{

    @Override
    public void execute(Object[] args) throws IOException, FileNotOpenedException, EmptyFileException, StringAttributeException, ElementNotFoundException, ElementHasNoAttributeException, StudentNotFoundException, InvalidCommandFormatException {

        if(args.length<2){
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

        String id=args[0].toString();
        String attribName=args[1].toString();
        ChildWithAttribute childWithAttribute = null;
        String noAttributeFound=null;

        Student foundStudent = null;

        boolean foundElement=false;
        boolean findStudent=false;


        for (Student fileDatum : OpenCommand.fileData) {    //Searching by id

            if (fileDatum.getId().equalsIgnoreCase(id)) {
                findStudent=true;
                foundStudent = fileDatum;

            }
        }

        if((attribName.equalsIgnoreCase("name")||attribName.equalsIgnoreCase("age")) && findStudent)
        {
           throw new StringAttributeException();
        }
        else if (!(foundStudent==null)&&attribName.equalsIgnoreCase("discipline")) //check if we search for a discipline element
        {
            if (foundStudent.discipline.getAttributeName() == null)
            {
                throw new ElementHasNoAttributeException();
            }

            System.out.println(foundStudent.discipline.getAttributeName()+"="+foundStudent.discipline.getAttributeValue());
        }
        else if (!(foundStudent==null)) // search in the later added elements
        {
            for (String string:foundStudent.values.keySet())
            {
                if(string.equalsIgnoreCase(attribName))
                {
                    childWithAttribute= (ChildWithAttribute) foundStudent.values.get(string);
                    foundElement=true;
                }
                if(foundElement && !(childWithAttribute.getAttributeName()==null))  //if the element is found print it
                {
                    System.out.println(childWithAttribute.getAttributeName()+"="+childWithAttribute.getAttributeValue());
                }
            }
            if(!foundElement) // if the element doesn't exist
            {
                    throw new ElementNotFoundException();
            }
            else if (childWithAttribute.getAttributeName()==null) //if the found element has no attribute
            {
                throw  new ElementHasNoAttributeException();
            }

        }
        else
        {
            throw new StudentNotFoundException();
        }


    }

}

