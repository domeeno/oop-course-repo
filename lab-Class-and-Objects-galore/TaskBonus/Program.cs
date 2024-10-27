using System;
using System.IO;

public class Program
{
    public static void Main(string[] args)
    {
        if (args.Length == 0)
        {
            Console.WriteLine("Please provide at least one file path as a command-line argument.");
            return;
        }

        FileReader fileReader = new FileReader();

        foreach (string filePath in args)
        {
            if (!File.Exists(filePath))
            {
                Console.WriteLine($"File does not exist: {filePath}");
                continue;
            }

            string fileContent = fileReader.ReadFileIntoString(filePath);

            if (string.IsNullOrEmpty(fileContent))
            {
                Console.WriteLine($"File content is empty or could not be read: {filePath}");
                continue;
            }

            string fileName = Path.GetFileName(filePath);
            TextData textData = new TextData(fileContent, fileName);

            Console.WriteLine($"File Name: {textData.GetFilename()}");
            Console.WriteLine($"Text Content: {textData.GetText()}");
            Console.WriteLine($"Number of Vowels: {textData.GetNumberOfVowels()}");
            Console.WriteLine($"Number of Consonants: {textData.GetNumberOfConsonants()}");
            Console.WriteLine($"Number of Letters: {textData.GetNumberOfLetters()}");
            Console.WriteLine($"Number of Sentences: {textData.GetNumberOfSentences()}");
            Console.WriteLine($"Longest Word: {textData.GetLongestWord()}");
            Console.WriteLine(); // Print a blank line between file outputs
        }
    }
}
