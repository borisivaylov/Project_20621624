package CommandLine;

import bg.tu_varna.sit.Student;

import java.io.IOException;

public class PrintCommand implements Command {

    @Override
    public void execute(Object[] args)  {
            for (Student fileDatum : OpenCommand.fileData) {
                System.out.println(fileDatum);
            }

        }
    }

