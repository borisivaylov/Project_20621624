package CommandLine;

import Exceptions.EmptyFileException;
import Exceptions.FileNotOpenedException;
import Exceptions.InvalidCommandFormatException;
import Exceptions.StudentNotFoundException;
import bg.tu_varna.sit.ChildWithAttribute;
import bg.tu_varna.sit.Student;

import java.io.IOException;

public class ChildCommand implements Command{
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

        String studentId= args[0].toString();
        String n=args[1].toString();
        Student foundStudent=null;
        int counter = Integer.parseInt(n);
        int elementsCount=3;
        boolean findStudent=false;

        if(counter==0){
            throw new InvalidCommandFormatException();
        }

        for (Student fileDatum : OpenCommand.fileData) {    //Searching by id

            if (fileDatum.getId().equalsIgnoreCase(studentId)) {
                findStudent=true;
                foundStudent = fileDatum;
            }
        }

        if( findStudent && (counter==1))
        {
            System.out.println( "1st child element of student with id "+studentId+" is:   <Name>"+foundStudent.getName()+"</Name>");
        }
        else if(findStudent && (counter==2))
        {
            System.out.println( "2nd child element of student with id "+studentId+" is:   <Age>"+foundStudent.getAge()+"</Age>");
        }
        else if(findStudent && (counter==3))
        {
            System.out.println( "3rd child element of student with id "+studentId+" is:  \n "+foundStudent.getDiscipline());
        }

        else if (findStudent)
        {
             for (String string : foundStudent.values.keySet())
                {
                    elementsCount++;

                    if (elementsCount==counter) {
                        System.out.println(counter + "child element of student with id  "+studentId +" is:  \n "+ foundStudent.values.get(string));
                    }
                }

             if(elementsCount<counter)
             {
                 System.out.println("There is no "+counter+"th child in this element");
             }

        }
        else {
                throw new StudentNotFoundException();
                }
}
}
