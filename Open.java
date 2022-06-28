package bg.tu_varna.sit;

import java.io.*;
import java.util.ArrayList;

public class Open {

    public void OpenFile(String fileName,ArrayList<Student>fileData) throws IOException {

        //ArrayList<Student> fileData = new ArrayList<Student>();
        Student stread;
        File file = new File(fileName + ".txt");
        if (file.exists()) {

            System.out.println("Successfully opened "+fileName+".xml");

            FileInputStream fis = new FileInputStream(fileName + ".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {


                while (true) {
                    stread = (Student) ois.readObject();
                    fileData.add(stread);

                    // System.out.println(st);
                }
            }
            catch (IOException | ClassNotFoundException e) {
                ois.close();

            }

        }

        else
        {
            try {
                if(file.createNewFile())
                {
                    System.out.println("Created an empty new file.");
                }
            }
            catch (IOException e)
            {
                System.out.println("Error");
            }
        }
    }

}
