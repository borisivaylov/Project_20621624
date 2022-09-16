package CommandLine;

import Exceptions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
    void execute(Object[] args) throws IOException, FileNotOpenedException, EmptyFileException, StringAttributeException, ElementNotFoundException, ElementHasNoAttributeException, StudentNotFoundException, StringCantHaveAttributeException, DisciplineTextException, DeleteIdException, InvalidCommandFormatException, NoSuchCommandException, NotThatManyStudentsException, CantCompareException;
}
