using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;

public class LaboratoryDataWrapper
{
    public List<LaboratoryData> Input { get; set; }
}

public class LaboratoryData
{
    public int Id { get; set; }
    public bool? IsHumanoid { get; set; }
    public string Planet { get; set; }
    public int? Age { get; set; }
    public List<string> Traits { get; set; }

    public void PrintInfo()
    {
        Console.WriteLine($"ID: {Id}, IsHumanoid: {IsHumanoid}, Planet: {Planet ?? string.Empty}, Age: {Age}, Traits: {string.Join(", ", Traits ?? new List<string>())}");
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        
        string filePath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "..\\..\\..\\..\\input.json");

        try
        {
            
            string jsonString = File.ReadAllText(filePath);

            var options = new JsonSerializerOptions
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            };

            
            LaboratoryDataWrapper dataWrapper = JsonSerializer.Deserialize<LaboratoryDataWrapper>(jsonString, options);

            
            if (dataWrapper == null)
            {
                Console.WriteLine("Deserialization returned null.");
                return;
            }

            
            if (dataWrapper.Input == null)
            {
                Console.WriteLine("The Input property is null.");
                return;
            }

            
            foreach (var data in dataWrapper.Input)
            {
                data.PrintInfo();
            }
        }
        catch (FileNotFoundException)
        {
            Console.WriteLine("Error: The file was not found.");
        }
        catch (JsonException ex)
        {
            Console.WriteLine("Error parsing JSON: " + ex.Message);
        }
        catch (Exception ex)
        {
            Console.WriteLine("An error occurred: " + ex.Message);
        }
    }
}