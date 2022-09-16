package CommandLine;

import Exceptions.*;

import java.io.IOException;

public class ErrorCommand implements Command
{

    @Override
    public void execute(Object[] args) throws IOException, FileNotOpenedException, EmptyFileException, StringAttributeException, ElementNotFoundException, ElementHasNoAttributeException, StudentNotFoundException, StringCantHaveAttributeException, DisciplineTextException, DeleteIdException, InvalidCommandFormatException, NoSuchCommandException {
        throw new NoSuchCommandException();
    }
}
