package bg.tu_varna.sit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface Saving
{
    public void Saving(String filename, ArrayList<Student> filedata) throws IOException;
}
