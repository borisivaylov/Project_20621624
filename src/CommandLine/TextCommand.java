package CommandLine;

import Exceptions.*;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Student;

import java.io.IOException;

public class TextCommand implements Command{
    @Override
    public void execute(Object[] args) throws IOException, FileNotOpenedException, EmptyFileException, StudentNotFoundException, DisciplineTextException, ElementNotFoundException, InvalidCommandFormatException {

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

        String studentId=args[0].toString();
        String elementId=args[1].toString();

        Student foundStudent = null;
        boolean findStudent=false;
        boolean foundElement=false;

        for (Student fileDatum : OpenCommand.fileData) {    //Searching by id

            if (fileDatum.getId().equalsIgnoreCase(studentId)) {
                findStudent=true;
                foundStudent = fileDatum;

            }
        }

        if (!findStudent)
        {
            throw new StudentNotFoundException();
        }
        else if(elementId.equalsIgnoreCase("name"))
        {
            System.out.println(" Student id ("+studentId+") -> name - " +foundStudent.getName());
        }
        else if(elementId.equalsIgnoreCase("age"))
        {
            System.out.println(" Student id ("+studentId+") -> age - " +foundStudent.getAge());
        }
        else if (elementId.equalsIgnoreCase("discipline"))
        {
           throw new DisciplineTextException();
        }
         else if(!foundStudent.values.isEmpty())
        {
            ChildWithAttribute childWithAttribute=null;
            for (String string:foundStudent.values.keySet())
            {
                if(string.equalsIgnoreCase(elementId))
                {
                    childWithAttribute= (ChildWithAttribute) foundStudent.values.get(string);
                    foundElement=true;

                }

            }

            if(foundElement && childWithAttribute.getChildText().equalsIgnoreCase(""))
            {
                System.out.println(" Student id ("+studentId+") -> "+childWithAttribute.getChildId()+" -  no text set");
            }
            else if (foundElement)
            {
                System.out.println(" Student id ("+studentId+") -> "+childWithAttribute.getChildId()+" - "+childWithAttribute.getChildText());
            }
            if(!foundElement)
            {
                throw new ElementNotFoundException();
            }

    }

}}
