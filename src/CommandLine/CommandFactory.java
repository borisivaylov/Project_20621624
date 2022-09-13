package CommandLine;

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
        else if (commandName.equalsIgnoreCase("selectattribute"))
        {
            return new SelectAtribbuteCommand();
        }
        else if (commandName.equalsIgnoreCase("setattribute"))
        {
            return new SetAttributeCommand();
        }
        else if (commandName.equalsIgnoreCase("delete"))
        {
            return new DeleteCommand();
        }
        else
        {
            return null;
        }
    }
}
