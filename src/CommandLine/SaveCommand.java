package CommandLine;

import Exceptions.FileNotOpenedException;
import bg.tu_varna.sit.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand implements Command{
    @Override
    public void execute(Object[] args) throws IOException, FileNotOpenedException {

        if (!OpenCommand.opened)
        {
            throw new FileNotOpenedException();
        }

        FileOutputStream fos= new FileOutputStream(OpenCommand.fileName+".txt");
        ObjectOutputStream oos= new ObjectOutputStream(fos);

        for (Student fileDatum : OpenCommand.fileData) {
            if(fileDatum!=null) {
                oos.writeObject(fileDatum);
            }
        }
        oos.close();
        System.out.println("Successfully saved "+OpenCommand.fileName);

    }
}
