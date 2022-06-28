package bg.tu_varna.sit;

import java.io.IOException;
import java.util.ArrayList;

public class Close
{

    public void CloseFile(String fileName, ArrayList<Student>fileData) throws IOException
    {

        while(!(fileData.isEmpty()))
        {
            fileData.remove(0);
        }

        System.out.println("Successfully closed "+fileName+".xml");
    }

}
