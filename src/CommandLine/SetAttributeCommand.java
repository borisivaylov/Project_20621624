package CommandLine;

import Exceptions.*;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Discipline;
import bg.tu_varna.sit.Specialty;
import bg.tu_varna.sit.Student;

import java.io.IOException;
import java.lang.reflect.Field;

public class SetAttributeCommand implements Command{
    @Override
    public void execute(Object[] args) throws IOException, FileNotOpenedException, EmptyFileException, StringCantHaveAttributeException, ElementNotFoundException, StudentNotFoundException, InvalidCommandFormatException {

        if(args.length<4){
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


        String studentId=args[0].toString();
        String elementId=args[1].toString();
        String attributeKey= args[2].toString();
        String attributeValue=args[3].toString();


        Student foundStudent=null;
        Object foundElement=null;

        for(Student everyStudent:OpenCommand.fileData)          //Searching for student by id
        {
            if(everyStudent.getId().equalsIgnoreCase(studentId))
            {
                foundStudent=everyStudent;
            }
        }

        if(!(foundStudent==null)&&(elementId.equalsIgnoreCase("name")||(elementId.equalsIgnoreCase("age"))))
        {
            throw new StringCantHaveAttributeException();
        }

        if( !(foundStudent==null) &&elementId.equalsIgnoreCase("discipline"))
            {
                foundStudent.discipline.setAttributeName(attributeKey);
                foundStudent.discipline.setAttributeValue(attributeValue);
                System.out.println("Attribute successfully set");
            }
        else if(!(foundStudent==null)) {

            for (String string : foundStudent.values.keySet()) // finding element
            {
                if (string.equalsIgnoreCase(elementId)) {
                    foundElement = foundStudent.values.get(string);
                }
            }

            if (foundElement==null)
            {
                throw new ElementNotFoundException();
            }
            else if (foundElement instanceof ChildWithAttribute) {
                ((ChildWithAttribute) foundElement).setAttributeName(attributeKey);
                ((ChildWithAttribute) foundElement).setAttributeValue(attributeValue);
                foundStudent.values.put(elementId, foundElement);
                System.out.println("Attribute successfully set");
            }

        }

        else {
            throw new StudentNotFoundException();
        }
    }


    }

