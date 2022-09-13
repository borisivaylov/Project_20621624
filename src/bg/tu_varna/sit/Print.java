package bg.tu_varna.sit;

import java.util.ArrayList;

public class Print {

    public void printing(ArrayList<Student> fileData)
    {
        for (Student fileDatum : fileData) {
            System.out.println(fileDatum);
        }
    }
}
