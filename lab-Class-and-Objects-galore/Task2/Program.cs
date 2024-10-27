using System;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

public class FileReader
{
    public string ReadFileIntoString(string path)
    {
        try
        {
            return File.ReadAllText(path);
        }
        catch (Exception e)
        {
            Console.WriteLine($"Error reading file: {e.Message}");
            return string.Empty;
        }
    }
}

public class TextData
{
    private string fileName;
    private string text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private string longestWord = ""; 
    
    public TextData(string text, string fileName)
    {
        this.text = text;
        this.fileName = fileName;
        ProcessText();
    }
    
    private void ProcessText()
    {
        
        numberOfVowels = text.Count(c => "AEIOUaeiou".Contains(c));
        numberOfConsonants = text.Count(c => char.IsLetter(c) && !"AEIOUaeiou".Contains(c));
        
        
        numberOfLetters = text.Count(char.IsLetter);
        numberOfSentences = Regex.Matches(text, @"[.!?]").Count;

        
        longestWord = text.Split(new[] { ' ', '\t', '\n', '\r', '.', ',', '!', '?' }, StringSplitOptions.RemoveEmptyEntries)
                          .OrderByDescending(word => word.Length)
                          .FirstOrDefault() ?? string.Empty;
    }
    
    public string GetFilename() => fileName;
    public string GetText() => text;
    public int GetNumberOfVowels() => numberOfVowels;
    public int GetNumberOfConsonants() => numberOfConsonants;
    public int GetNumberOfLetters() => numberOfLetters;
    public int GetNumberOfSentences() => numberOfSentences;
    public string GetLongestWord() => longestWord;
}

public class Program
{
    public static void Main(string[] args)
    {
        if (args.Length == 0)
        {
            Console.WriteLine("Please provide the file path as a command-line argument.");
            return;
        }

        string filePath = args[0];
        FileReader fileReader = new FileReader();
        string fileContent = fileReader.ReadFileIntoString(filePath);

        if (string.IsNullOrEmpty(fileContent))
        {
            Console.WriteLine("File content is empty or could not be read.");
            return;
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
    }
}