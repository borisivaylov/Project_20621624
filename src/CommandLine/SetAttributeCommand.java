package CommandLine;

import bg.tu_varna.sit.Specialty;
import bg.tu_varna.sit.Student;

import java.io.IOException;
import java.lang.reflect.Field;

public class SetAttributeCommand implements Command{
    @Override
    public void execute(Object[] args) throws IOException {

        String id=args[0].toString();
        String key=args[1].toString();
        String value=args[2].toString();

        Student foundStudent = null;
        Class clazz = null;
        boolean foundAttribute=false;
        for (Student fileDatum : OpenCommand.fileData) {
            if (fileDatum.getId().equalsIgnoreCase(id)) {
                foundStudent = fileDatum;
                clazz = foundStudent.getClass();
            }
        }
        if(!(foundStudent == null) && (key.equalsIgnoreCase("discipline")))
        {
            String facultyName=args[3].toString();
            String specName=args[4].toString();
            Specialty specialty=new Specialty(facultyName,specName);
            foundStudent.discipline.setDiscName(value);
            foundStudent.discipline.setSpecialty(specialty);

        }
        else if (!(foundStudent == null)) {
            for (Field field : clazz.getDeclaredFields()) {
                if (field.getName().equalsIgnoreCase(key)) {
                    foundStudent.values.put(key,value);
                    foundAttribute=true;
                }
            }
        } else {
            System.out.println("Student with this id was not found.....");
            //препрадка към командния ред
        }
    }


    }

