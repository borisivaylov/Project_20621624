package CommandLine;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
    void execute(Object[] args) throws IOException;
}
