package CommandLine;

import Exceptions.EmptyFileException;
import Exceptions.FileNotOpenedException;
import Exceptions.InvalidCommandFormatException;
import Exceptions.StudentNotFoundException;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Student;

import java.io.IOException;

public class ChildrenCommand implements Command{
    @Override
    public void execute(Object[] args) throws IOException, EmptyFileException, FileNotOpenedException, StudentNotFoundException, InvalidCommandFormatException {

        if(args.length==0){
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
        Student foundStudent=null;
        boolean findStudent=false;

        for (Student fileDatum : OpenCommand.fileData) {    //Searching by id

            if (fileDatum.getId().equalsIgnoreCase(studentId)) {
                findStudent=true;
                foundStudent = fileDatum;
            }
        }

        if (!findStudent) {
            throw new StudentNotFoundException();
        }
        else if(foundStudent.discipline.getAttributeName()==null)
        {
            System.out.println(" Discipline -> no attribute set");
        }
        else if (!(foundStudent.discipline.getAttributeName()==null))
        {
            System.out.println(" Discipline -> "+foundStudent.discipline.getAttributeName()+" = "+foundStudent.discipline.getAttributeValue());
        }

        if(!foundStudent.values.isEmpty())    // check if there are any later added child elements
        {
            for (String string: foundStudent.values.keySet()) // if yes, go through them
            {
                ChildWithAttribute processing= (ChildWithAttribute) foundStudent.values.get(string);
                if (!(processing.getAttributeName()==null))     // if the child element has attribute set
                {
                    System.out.println(" "+string+" -> "+processing.getAttributeName()+" = "+processing.getAttributeValue());
                }
                else
                {
                    System.out.println(" "+string+" -> no attribute set");
                }

            }
        }






    }
}
