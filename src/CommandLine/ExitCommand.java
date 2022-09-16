package CommandLine;

import java.io.IOException;

public class ExitCommand implements Command{
    @Override
    public void execute(Object[] args) throws IOException {
        System.exit(0);
    }
}
