package bg.tu_varna.sit;

import java.io.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Student> fileData = new ArrayList<Student>();
        Open openFile=new Open();
        Close closeFile=new Close();
        Save saveFile=new Save();
        SaveAs saveAsFile=new SaveAs();
        String filename="stuts";


        Student st1=new Student("2062","Ivan",4.62);
        Student st3=new Student("2063","Petur",4.82);
        Student st4=new Student("2064","Kristian",5.62);

        openFile.OpenFile(filename,fileData);
        for(int i=0;i< fileData.size();i++)
        {
            System.out.println(fileData.get(i));
        }
        System.out.println("----------------------------");
       // fileData.add(st3);
       // fileData.add(st4);

        for(int i=0;i< fileData.size();i++)
        {
            System.out.println(fileData.get(i));
        }
        System.out.println("----------------------------");
        fileData.remove(1);
        for(int i=0;i< fileData.size();i++)
        {
            System.out.println(fileData.get(i));
        }
        System.out.println("----------------------------");
        saveFile.Saving(filename,fileData);
        closeFile.CloseFile(filename,fileData);
        System.out.println(fileData.isEmpty());
        System.out.println("----------------------------");
        for(int i=0;i< fileData.size();i++) {
            System.out.println(fileData.get(i));
        }

        filename="C:\\Users\\Boris\\Desktop\\testfiles.txt";
        saveAsFile.Saving(filename,fileData);

        //saveFile.Saving(filename,fileData);

       // fileData.add(st3);
      //  fileData.add(st4);
///
        /*
        for(int i=0;i< fileData.size();i++)
        {
            System.out.println(fileData.get(i));
        }

        saveFile.Saving(filename,fileData);
        closeFile.CloseFile(filename,fileData);
        for(int i=0;i< fileData.size();i++)
        {
            System.out.println(fileData.get(i));
        }
        openFile.OpenFile(filename,fileData);
        fileData.set(1,null);
        for(int i=0;i< fileData.size();i++)
        {
            System.out.println(fileData.get(i));
        }
        saveFile.Saving(filename,fileData);
        closeFile.CloseFile(filename,fileData);
*/

///



        //System.out.println(fileData.get(1));

        /*
        for(int i=0;i< fileData.size();i++)
        {
            System.out.println(fileData.get(i));
        }

        fileData.set(1,null);
        saveFile.Saving(filename,fileData);
        closeFile.CloseFile(filename,fileData);

        openFile.OpenFile(filename,fileData);

        for(int i=0;i< fileData.size();i++)
        {
            System.out.println(fileData.get(i));
        }


       // closefile.CloseFile(filename,fileData);
       // System.out.println(fileData.get(1));



*/




    }}

