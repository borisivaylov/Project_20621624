package bg.tu_varna.sit;

import CommandLine.OpenCommand;

import java.io.IOException;
import java.util.ArrayList;

public class Close
{

    public void CloseFile() throws IOException
    {

        while(!(OpenCommand.fileData.isEmpty()))
        {
            OpenCommand.fileData.remove(0);
        }
        OpenCommand.opened=false;
        System.out.println("Successfully closed "+OpenCommand.fileName+".xml");
    }

}
