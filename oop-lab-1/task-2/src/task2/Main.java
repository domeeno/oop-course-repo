package task2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the file path as a command-line argument.");
            return;
        }

        String filePath = args[0];

        try {
            String content = FileReader.readFileIntoString(filePath);
            TextData textData = new TextData(filePath, content);
            textData.printInfo(); // Print the formatted output
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
