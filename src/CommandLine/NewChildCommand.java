package CommandLine;

import Exceptions.EmptyFileException;
import Exceptions.FileNotOpenedException;
import Exceptions.InvalidCommandFormatException;
import Exceptions.StudentNotFoundException;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Student;

import java.io.IOException;

public class NewChildCommand implements Command{
    @Override
    public void execute(Object[] args) throws IOException, FileNotOpenedException, EmptyFileException, StudentNotFoundException, InvalidCommandFormatException {

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
        String newChildId=args[1].toString();

        Student foundStudent=null;
        Class clazz=null;
        boolean found=false;

        for(Student everyStudent:OpenCommand.fileData)          //Searching for student by id
        {
            if(everyStudent.getId().equalsIgnoreCase(studentId))
            {
                foundStudent=everyStudent;
            }
        }


        if(!(foundStudent==null))
        {
            for (String elementName : foundStudent.values.keySet()) // Check if the child element id already exists
            {
                if(elementName.equalsIgnoreCase(newChildId))
                {
                    newChildId=newChildId.concat("_1");         // If so then add "_1" in order for it to be unique
                }
            }
            ChildWithAttribute newChildElement=new ChildWithAttribute(newChildId);
            foundStudent.values.put(newChildId,newChildElement);
            System.out.println("New child element successfully added.");
        }
        else
        {
            throw new StudentNotFoundException();
        }



    }
}
