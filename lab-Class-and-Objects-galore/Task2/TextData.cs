using System;
using System.Linq;
using System.Text.RegularExpressions;

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
