package CommandLine;

import bg.tu_varna.sit.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class OpenCommand implements Command{

    public static boolean opened=false;
    public static ArrayList<Student> fileData=new ArrayList<Student>();
    public static String fileName;

    @Override
    public void execute(Object[] args) throws IOException {

        Student dataRead;
        String[] argsProcessing = Arrays.copyOf(args, args.length, String[].class);
        fileName=String.join(" ",argsProcessing);
        File file = new File(fileName + ".txt");
        if (file.exists()) {

            if(file.length()==0)
            {
                System.out.println("Successfully opened "+fileName);
            }
            else {
                System.out.println("Successfully opened " + fileName);

                FileInputStream fis = new FileInputStream(fileName + ".txt");
                ObjectInputStream ois = new ObjectInputStream(fis);

                try {
                    opened = true;
                    while (true) {
                        dataRead = (Student) ois.readObject();
                        fileData.add(dataRead);
                        //System.out.println(dataRead);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    ois.close();

                }
            }

        }

        else
        {
            try {
                if(file.createNewFile())
                {
                    System.out.println("Created an empty new file.");
                    opened=true;
                }
            }
            catch (IOException e)
            {
                System.out.println("Error");
            }
        }
    }

}

