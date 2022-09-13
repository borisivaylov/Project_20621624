package bg.tu_varna.sit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Save implements Saving{
    @Override
    public void Saving(String fileName, ArrayList<Student> fileData) throws IOException {

        FileOutputStream fos= new FileOutputStream(fileName+".txt");
        ObjectOutputStream oos= new ObjectOutputStream(fos);

        for (Student fileDatum : fileData) {
            if(fileDatum!=null) {
                oos.writeObject(fileDatum);
            }
        }
        oos.close();
        System.out.println("Successfully saved "+fileName+".xml");

    }
}
