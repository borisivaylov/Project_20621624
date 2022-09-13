package bg.tu_varna.sit;
import CommandLine.*;

import com.sun.org.apache.bcel.internal.generic.Select;
import jdk.internal.cmm.SystemResourcePressureImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                //Scanner sc = new Scanner(System.in);
                String variables = sc.nextLine();
                String[] command;

                //System.out.println(sc);

                command = variables.split("\\s+");
                String commandName = command[0];
                Object[] commandArgs = new String[command.length - 1];
                System.arraycopy(command, 1, commandArgs, 0, commandArgs.length);


                Command commands = CommandFactory.getCommandName(commandName);

                if (commands != null)
                    commands.execute(commandArgs);

            }
            catch (Exception e)
            {System.out.println(e);}
        }






































        /*
        Open openFile=new Open();
        Close closeFile=new Close();
        Save saveFile=new Save();
        SaveAs saveAsFile=new SaveAs();
        Print printFile=new Print();
        DeleteAttribute deleteAttribute=new DeleteAttribute();
        Open.fileName="students1";
        Specialty specialty=new Specialty("FITA","SIT");
        Discipline discipline=new Discipline("OOP1",specialty);


        Student st1=new Student("2062","Ivan","4.62",discipline);
        Student st3=new Student("2063","Petur","4.82",discipline);
        Student st4=new Student("2064","Kristian","5.62",discipline);

        openFile.OpenFile(Open.fileName,Open.fileData);
        printFile.printing(Open.fileData);
        closeFile.CloseFile();
        System.out.println(Open.fileData);
        System.out.println(Open.opened);


*/
    }}

