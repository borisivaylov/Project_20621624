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
                System.out.print(">");
                String variables = sc.nextLine();
                String[] command;



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

    }}

