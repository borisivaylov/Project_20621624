package CommandLine;

import bg.tu_varna.sit.Save;
import bg.tu_varna.sit.SaveAs;
import bg.tu_varna.sit.Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class SaveAsCommand implements Command{
    @Override
    public void execute(Object[] args) throws IOException
    {
        String[] argsProcessing = Arrays.copyOf(args, args.length, String[].class);
        String saveFileName=String.join(" ",argsProcessing);
        File file = new File(saveFileName + ".txt");

        System.out.println(OpenCommand.fileName);
        System.out.println(saveFileName);

        if(file.exists())
        {
            new SaveCommand().execute(args);
        }
        else
        {
            try {
                if(file.createNewFile())
                {
                    FileOutputStream fos= new FileOutputStream(saveFileName+".txt");
                    ObjectOutputStream oos= new ObjectOutputStream(fos);

                    for (Student fileDatum : OpenCommand.fileData) {
                        if(fileDatum!=null) {
                            oos.writeObject(fileDatum);
                        }
                    }
                    oos.close();

                    System.out.println("Information was successfully saved in "+saveFileName);

                };
            }
            catch (IOException e)
            {
                System.out.println("Error");
            }
        }

    }
    }

