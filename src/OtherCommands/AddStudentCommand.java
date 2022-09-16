package OtherCommands;

import CommandLine.Command;
import CommandLine.OpenCommand;
import bg.tu_varna.sit.Student;

import java.io.IOException;
import java.util.Arrays;

public class AddStudentCommand implements Command {
    @Override
    public void execute(Object[] args) throws IOException {

        String newStudentId=args[0].toString();
        String newStudentAge=args[1].toString();

        String[] textProcessing= Arrays.copyOf(args,args.length,String[].class);
        String[] textValueProcessing=new String[textProcessing.length-2];
        System.arraycopy(textProcessing,2,textValueProcessing,0,textProcessing.length-2);
        String newStudentName= String.join(" ",textValueProcessing);

        Student newStudent= new Student(newStudentId,newStudentName,newStudentAge);
        OpenCommand.fileData.add(newStudent);
    }
}
