package CommandLine;

import Exceptions.*;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Student;

import java.io.IOException;
import java.lang.reflect.Field;

public class DeleteCommand implements Command
{

    @Override
    public void execute(Object[] args) throws IOException, FileNotOpenedException, EmptyFileException, StudentNotFoundException, ElementHasNoAttributeException, ElementNotFoundException, DeleteIdException, InvalidCommandFormatException {

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

        Student foundStudent = null;
        String studentId=args[0].toString();
        String elementId=args[1].toString();

        boolean studentFound=false;
        boolean elementFound=false;


        for (Student fileDatum : OpenCommand.fileData) {
            if (fileDatum.getId().equalsIgnoreCase(studentId)) {
                foundStudent = fileDatum;
                studentFound=true;
            }
        }

        if(!studentFound)
        {
            throw new StudentNotFoundException();
        }
        else if(elementId.equalsIgnoreCase("id"))
        {
            throw new DeleteIdException();
        }
        else if(elementId.equalsIgnoreCase("name")||elementId.equalsIgnoreCase("age"))
        {
            throw new ElementHasNoAttributeException();
        }
        else if(elementId.equalsIgnoreCase("discipline"))
        {
            String foundDiscipline=foundStudent.discipline.getAttributeName();
            if(foundDiscipline==null)
            {
                System.out.println(" Discipline has no attribute set");
                elementFound=true;
            }
            else {
                foundStudent.discipline.setAttributeValue(null);
                foundStudent.discipline.setAttributeName(null);
                System.out.println("Deleted the attribute successfully.");
                elementFound = true;
            }
        }
        else if(!(foundStudent.values.isEmpty() ))
        {
            ChildWithAttribute processing=null;
            for (String string: foundStudent.values.keySet()) {

                //System.out.println(processing);

                if(string.equalsIgnoreCase(elementId))
                {
                   processing = (ChildWithAttribute) foundStudent.values.get(string);
                   elementFound=true;

                }
                 if ( !(processing==null) && processing.getAttributeName()==null && string.equalsIgnoreCase(elementId))     // if the child element has attribute set
                {
                    System.out.println(" "+string+" has no attribute set");
                }
                else if(!(processing==null))
                {
                    processing.setAttributeName(null);
                    processing.setAttributeValue(null);
                    foundStudent.values.put(elementId,processing);
                    System.out.println("Deleted the attribute successfully.");

                }

            }
            if(!elementFound)
            {
                throw new ElementNotFoundException();
            }
        }


    }}

