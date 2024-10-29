package task2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Check if any file paths are provided
        if (args.length < 1) {
            System.out.println("Please provide at least one file path as a command-line argument.");
            return;
        }

        // Loop through each file path provided in the arguments
        for (String filePath : args) {
            try {
                String content = FileReader.readFileIntoString(filePath);
                TextData textData = new TextData(filePath, content);
                textData.printInfo(); // Print the formatted output
            } catch (IOException e) {
                System.err.println("Error reading file '" + filePath + "': " + e.getMessage());
            }
        }
    }
}
