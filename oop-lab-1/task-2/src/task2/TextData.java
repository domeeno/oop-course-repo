package task2;


public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
        analyzeText();
    }

    private void analyzeText() {
        numberOfVowels = countVowels(text);
        numberOfConsonants = countConsonants(text);
        numberOfLetters = countLetters(text);
        numberOfSentences = countSentences(text);
        longestWord = findLongestWord(text);
    }

    private int countVowels(String text) {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    private int countConsonants(String text) {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) {
                count++;
            }
        }
        return count;
    }

    private int countLetters(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }

    private int countSentences(String text) {
        String[] sentences = text.split("[.!?]");
        return sentences.length;
    }

    private String findLongestWord(String text) {
        String[] words = text.split("\\W+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public String getFileName() {
        return fileName;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public void printInfo() {
        System.out.println("----- Text Data Analysis -----");
        System.out.println("File Name       : " + fileName);
        System.out.println("Total Letters   : " + numberOfLetters);
        System.out.println("Vowels          : " + numberOfVowels);
        System.out.println("Consonants      : " + numberOfConsonants);
        System.out.println("Sentences       : " + numberOfSentences);
        System.out.println("Longest Word    : " + longestWord);
        System.out.println("------------------------------");
    }
}
