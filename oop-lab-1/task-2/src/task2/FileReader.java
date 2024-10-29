package task2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileReader {
    public static String readFileIntoString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
