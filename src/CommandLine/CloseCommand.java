package CommandLine;

import Exceptions.FileNotOpenedException;

import java.io.IOException;

public class CloseCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException {
        if (!OpenCommand.opened)
        {
            throw new FileNotOpenedException();
        }


        while(!(OpenCommand.fileData.isEmpty()))
        {
            OpenCommand.fileData.remove(0);
        }
        OpenCommand.opened=false;
        System.out.println("Successfully closed "+OpenCommand.fileName);
        OpenCommand.fileName=null;
    }
}
