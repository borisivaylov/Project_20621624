package OtherCommands;

import CommandLine.Command;
import CommandLine.OpenCommand;
import bg.tu_varna.sit.Discipline;
import bg.tu_varna.sit.Specialty;
import bg.tu_varna.sit.Student;

import java.io.IOException;

public class SetDisciplineCommand implements Command {
    @Override
    public void execute(Object[] args) throws IOException
    {
        String studentId=args[0].toString();
        String discName=args[1].toString();
        String facultyName=args[2].toString();
        String specName=args[3].toString();
        Student foundStudent=null;

        for (Student fileDatum : OpenCommand.fileData) {    //Searching by id

            if (fileDatum.getId().equalsIgnoreCase(studentId))
                foundStudent = fileDatum;

        }

        if(!(foundStudent==null))
        {
            Specialty newSpecialty=new Specialty(facultyName,specName);
            Discipline newDiscipline=new Discipline(discName,newSpecialty);
            foundStudent.setDiscipline(newDiscipline);
        }


    }
}
