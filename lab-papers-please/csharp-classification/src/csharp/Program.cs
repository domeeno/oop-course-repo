using System;
using System.Text.Json;
using System.Text.Json.Nodes;

namespace Csharp
{
    class Program
    {
        static void Main()
        {
            //var inputFile = "..\\resources\\test-input.json";
            string baseDir = AppContext.BaseDirectory;

            // Adjust the path relative to the base directory where the app is running
            var inputFile = Path.Combine(baseDir, "..", "..", "..", "..", "resources", "input", "test-input.json");

            var jsonData = File.ReadAllText(inputFile);
            var data = JsonNode.Parse(jsonData)?["data"]?.AsArray();

            var starWars = new Universe("starWars", new List<JsonNode>());
            var hitchHiker = new Universe("hitchHiker", new List<JsonNode>());
            var rings = new Universe("rings", new List<JsonNode>());
            var marvel = new Universe("marvel", new List<JsonNode>());

            if(data != null)
            {
                foreach(var entry in data)
                {
                    Console.WriteLine(entry.ToString());
                    string? userInput = Console.ReadLine();
                    switch(userInput.Trim())
                    {
                        case "1":
                        {
                            starWars.Individuals.Add(entry);
                            break;
                        }
                        case "2":
                        {
                            hitchHiker.Individuals.Add(entry);
                            break;
                        }
                        case "3":
                        {
                            rings.Individuals.Add(entry);
                            break;
                        }
                        case "4":
                        {
                            marvel.Individuals.Add(entry);
                            break;
                        }
                    }
                }
            }

            var options = new JsonSerializerOptions
            {
                WriteIndented = true
            };

            string outputDirectory = Path.Combine(baseDir, "..", "..", "..", "..", "resources", "output");
          
            File.WriteAllText(Path.Combine(outputDirectory, "starwars.json"), JsonSerializer.Serialize(starWars, options));
            File.WriteAllText(Path.Combine(outputDirectory, "hitchhiker.json"), JsonSerializer.Serialize(hitchHiker, options));
            File.WriteAllText(Path.Combine(outputDirectory, "rings.json"), JsonSerializer.Serialize(rings, options));
            File.WriteAllText(Path.Combine(outputDirectory, "marvel.json"), JsonSerializer.Serialize(marvel, options));

        }
    }

    public class Universe
    {
        public string Name {get; set;}
        public List<JsonNode> Individuals {get; set;} 

        public Universe(string name, List<JsonNode> individuals)
        {
            Name = name;
            Individuals = individuals;
        }
    }
}

