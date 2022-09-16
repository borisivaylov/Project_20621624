package CommandLine;

import java.io.IOException;

public class HelpCommand implements Command{
    @Override
    public void execute(Object[] args) throws IOException {

        System.out.println("The following commands are supported:\n" +
                            "Open <fileName>        Opens <filename>\n" +
                            "Close                  Closes the currently opened file\n" +
                            "Save                   Saves the currently opened file\n" +
                            "Saveas <fileName>      Saves the currently opened file in <filename>\n" +
                            "Help                   Prints this information\n" +
                            "Exit                   Exits the program\n" +
                            "Print                  Prints the file information\n" +
                            "Select <Student id><Element id>                                Prints the attribute value of <element id> in <Student id>\n" +
                            "Set <Student id><Element id><Attribute key><Attribute value>   Sets the attribute of <Element id> in <Student id>\n" +
                            "Children <Student Id>                                          Prints the attributes of all elements in <Student id>\n"+
                            "Child <Student id><n>                                          Prints the n-th child element of <Student id>\n" +
                            "Text <Student Id><Element id>                                  Prints the text value of <element id> in <Student id>\n" +
                            "Delete <Student id><Element id>                                Deletes the attribute of <Element id> in <Student  id>\n" +
                            "Newchild <Student id><Element id>                              Adds a new child element in <Student id>\n"+
                            "Student/ <element id>                                          Prints all elements with the <element id>\n"+
                            "Student  <element id>[student position in file]                Prints the <element id> of the student in position []\n"+
                            "Student@  <element id>                                         Prints all attributes of <element id> \n"+
                            "Student(  <element compare id>=<element compare value> <element id display>    Prints the text of <element id display> if its student element values "
        );



    }
}
