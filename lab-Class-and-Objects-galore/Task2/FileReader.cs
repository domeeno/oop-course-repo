using System;
using System.IO;

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
