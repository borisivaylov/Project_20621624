package CommandLine;

import bg.tu_varna.sit.Student;

import java.io.IOException;
import java.lang.reflect.Field;

public class SelectAtribbuteCommand implements Command
{

    @Override
    public void execute(Object[] args) throws IOException {

        String id=args[0].toString();
        String attribName=args[1].toString();


        Student foundStudent = null;
        Class clazz=null;
        boolean found=false;

        for (Student fileDatum : OpenCommand.fileData) {    //Searching by id

            if (fileDatum.getId().equalsIgnoreCase(id)) {
                foundStudent = fileDatum;
                clazz = foundStudent.getClass();
            }
        }
        if (!(foundStudent==null))                          //if a student was found check attributes
        {


            for (Field field : clazz.getDeclaredFields())   // checking basic attributes
            {

                if(field.getName().equalsIgnoreCase(attribName))
                {
                    System.out.println(foundStudent.getValue(attribName));
                    found=true;
                    break;
                }
            }

            if(!found) {              // if it is not a basic attribute, search in the later-added attributes
                for (String name : foundStudent.values.keySet()) {
                    if (name.equalsIgnoreCase(attribName)) {
                        System.out.println(foundStudent.getValue(name));
                        found = true;
                        break;
                    }
                }

            }

            if(!found)  // if the student is found, but attribute is not found
            {
                System.out.println("Student with id "+id+" does not have an "+attribName+" attribute.");
            }
        }
        else // if there is no student with such id
        {
            System.out.println("Student with this id was not found.....");
            //препрадка към командния ред
        }
    }

}

