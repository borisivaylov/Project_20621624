package bg.tu_varna.sit;

import CommandLine.OpenCommand;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaveAs implements Saving{
    @Override
    public void Saving(String fileName, ArrayList<Student> fileData) throws IOException {

        SaveAs save=new SaveAs();
        File file = new File(fileName + ".txt");

        if(file.exists())
        {
            save.Saving(OpenCommand.fileName,OpenCommand.fileData);
        }
        else
        {
            try {
                if(file.createNewFile())
                {
                    save.Saving(fileName,fileData);
                }
            }
            catch (IOException e)
            {
                System.out.println("Error");
            }
        }

    }
}
