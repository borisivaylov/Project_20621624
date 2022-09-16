package CommandLine;

import Exceptions.EmptyFileException;
import Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.Student;

import java.io.IOException;

public class PrintCommand implements Command {

    @Override
    public void execute(Object[] args) throws FileNotOpenedException, EmptyFileException {

        if (!OpenCommand.opened)
        {
            throw new FileNotOpenedException();
        }
        else if(OpenCommand.fileData.isEmpty())
        {
            throw new EmptyFileException();
        }

        System.out.println();
            for (Student fileDatum : OpenCommand.fileData) {
                System.out.println(fileDatum);
            }

        }
    }

