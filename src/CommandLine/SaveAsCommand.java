package CommandLine;

import Exceptions.FileNotOpenedException;
import Exceptions.InvalidCommandFormatException;
import bg.tu_varna.sit.Student;

import java.io.*;
import java.util.Arrays;

public class SaveAsCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException, IOException, InvalidCommandFormatException {

        if(args.length==0){
            throw new InvalidCommandFormatException();
        }

        if (!OpenCommand.opened)
        {
            throw new FileNotOpenedException();
        }

        String[] argsProcessing = Arrays.copyOf(args, args.length, String[].class);
        String saveFileName=String.join(" ",argsProcessing);
        File file = new File(saveFileName + ".txt");


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

