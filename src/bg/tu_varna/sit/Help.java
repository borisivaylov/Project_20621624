package bg.tu_varna.sit;

public class Help
{
    public void printCommands()
    {
        System.out.println(
                "Supported main commands: \n"+
                        "Open <filename>            Opens file with <filename> \n"+
                        "Close                      Closes the currently opened file \n"+
                        "Save                       Saves the currently open file\n"+
                        "saveas <file>              Saves the currently open file in <file>\n"+
                        "help                       Prints this information\n"+
                        "exit                       Exists the program\n\n"+
                        "Supported XML commands:\n"+
                        "Print                      Prints the file information\n"+
                        "Select <id> <key>          Prints the value of the <key>(attribute) of the <id>(element)\n"+
                        "Set <id> <key> <value>     Set the <value> of the <key>(attribute) of the <id>(element)\n"+
                        "Children <id>              "+
                        "Child <id> <n>             "+
                        "Text <id>                  "+
                        "Delete <id> <key>          Deletes(Sets to null) the <key>(attribute) of the <id>(element)\n"+
                        "Newchild <id>              "+
                        "Xpath <id> <xpath          >\n"
        );

    }
}
