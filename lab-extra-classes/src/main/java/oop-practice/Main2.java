import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class ReadFile {
    public String readFileIntoString(String path) {
        var file = new File(path);
        var content = new StringBuilder();

        try (var scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                var data = scanner.nextLine();
                content.append(data);
                content.append("\n");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        return content.toString();
    }
}

class TextData {
    private String fileName;
    private String text;
    private int numberOfLetters;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String text) {
        this.text = text;
        this.numberOfLetters = calculateLetters();
        this.numberOfVowels = calculateVowels();
        this.numberOfConsonants = calculateConsonants();
        this.numberOfSentences = calculateSentences();
        this.longestWord = findLongestWord();
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }

    private int calculateLetters() {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                count++;
            }
        }

        return count;
    }

    private int calculateVowels() {
        int count = 0;


        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));

            if (c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'a') {
                count++;
            }
        }

        return count;
    }

    private int calculateConsonants() {
        return numberOfLetters - numberOfVowels;
    }

    private int calculateSentences() {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == '.' || c == '?' || c == '!') {
                count++;
            }
        }

        return count;
    }

    private String findLongestWord() {
        var longestWord = "";
        var words = text.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            var word = words[i];
            word = word.replaceAll("[^a-zA-Z]", "");

            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }
}

public class Main2 {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please provide a filename");
            return;
        }

        var maxConsonants = 0;
        var fileMaxConsonantsFile = "";

        var readFile = new ReadFile();
        for (int i = 0; i < args.length; i++) {

            var filePath = args[i];
            var text = readFile.readFileIntoString(filePath);

            var textData = new TextData(text);

            // Print info for this file
            System.out.println("\n=== File " + (i + 1) + ": " + filePath + " ===");
            System.out.println("Number of vowels: " + textData.getNumberOfVowels());
            System.out.println("Number of consonants: " + textData.getNumberOfConsonants());
            System.out.println("Number of letters: " + textData.getNumberOfLetters());
            System.out.println("Number of sentences: " + textData.getNumberOfSentences());
            System.out.println("Longest word: " + textData.getLongestWord());

            if (textData.getNumberOfVowels() > maxConsonants) {
                maxConsonants = textData.getNumberOfVowels();
                fileMaxConsonantsFile = filePath;
            }
        }
        System.out.println("File with the most words: " + fileMaxConsonantsFile);
        System.out.println(maxConsonants);


    }
}