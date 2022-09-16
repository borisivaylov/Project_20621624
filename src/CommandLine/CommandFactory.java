package CommandLine;

import OtherCommands.AddStudentCommand;
import OtherCommands.SetDisciplineCommand;
import OtherCommands.SetTextCommand;

public abstract class CommandFactory
{
    public static Command getCommandName(String commandName)
    {
        if(commandName.equalsIgnoreCase("open"))
        {
            return new OpenCommand();
        }
        else if (commandName.equalsIgnoreCase("close"))
        {
            return new CloseCommand();
        }
        else if(commandName.equalsIgnoreCase("print"))
        {
             return new PrintCommand();
        }
        else if (commandName.equalsIgnoreCase("save"))
        {
            return new SaveCommand();
        }
        else if (commandName.equalsIgnoreCase("saveas"))
        {
            return new SaveAsCommand();
        }
        else if (commandName.equalsIgnoreCase("select"))
        {
            return new SelectAtribbuteCommand();
        }
        else if (commandName.equalsIgnoreCase("set"))
        {
            return new SetAttributeCommand();
        }
        else if (commandName.equalsIgnoreCase("delete"))
        {
            return new DeleteCommand();
        }
        else if (commandName.equalsIgnoreCase("newchild"))
        {
            return new NewChildCommand();
        }
        else if (commandName.equalsIgnoreCase("addstudent"))
        {
            return new AddStudentCommand();
        }
        else if (commandName.equalsIgnoreCase("setdiscipline"))
        {
            return new SetDisciplineCommand();
        }
        else if (commandName.equalsIgnoreCase("child"))
        {
            return new ChildCommand();
        }
        else if (commandName.equalsIgnoreCase("children"))
        {
            return new ChildrenCommand();
        }
        else if (commandName.equalsIgnoreCase("help"))
        {
            return new HelpCommand();
        }
        else if (commandName.equalsIgnoreCase("exit"))
        {
            return new ExitCommand();
        }
        else if (commandName.equalsIgnoreCase("Text"))
        {
            return new TextCommand();
        }
        else if (commandName.equalsIgnoreCase("setText"))
        {
            return new SetTextCommand();
        }
        else if (commandName.equalsIgnoreCase("student/"))
        {
            return new XpathStudentListCommand();
        }
        else if (commandName.equalsIgnoreCase("student"))
        {
            return new XpathOneStudentSearch();
        }
        else if (commandName.equalsIgnoreCase("student@"))
        {
            return new XpathAttributeListCommand();
        }
        else if (commandName.equalsIgnoreCase("student("))
        {
            return new XpathCompareCommand();
        }
        else
        {
            return new ErrorCommand();
        }
    }
}
