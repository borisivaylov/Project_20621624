package CommandLine;

import bg.tu_varna.sit.Student;

import java.io.IOException;
import java.lang.reflect.Field;

public class DeleteCommand implements Command
{

    @Override
    public void execute(Object[] args) throws IOException
    {
        Student foundStudent = null;
        //Class clazz=null;
        String id=args[0].toString();
        String key=args[1].toString();

        for (Student fileDatum : OpenCommand.fileData) {
            if (fileDatum.getId().equalsIgnoreCase(id)) {
                foundStudent = fileDatum;
            }
        }

        if (!(foundStudent==null)) {

           // foundStudent.removeValue();

            for (Field field : foundStudent.getClass().getDeclaredFields())
            {
                if(field.getName().equalsIgnoreCase(key))
              {
                  foundStudent.removeValue(key);
               }
            }


        }
        else
        {
            System.out.println("Student with this id was not found.....");
            //препрадка към командния ред
        }
    }}

