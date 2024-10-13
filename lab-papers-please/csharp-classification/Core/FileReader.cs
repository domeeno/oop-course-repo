using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace csharp_classification.Core
{
    public class FileReader
    {
        private readonly RuleSet ruleSet;

        public FileReader(RuleSet ruleSet)
        {
            this.ruleSet = ruleSet;
        }

        public void ClassifyAndSaveJson()
        {
            string basePath = AppContext.BaseDirectory;
            string inputFilePath = Path.Combine(basePath, "Resources", "Inputs", "input.json");

            try
            {
                var fileContent = File.ReadAllText(inputFilePath);
                var rootObject = JsonConvert.DeserializeObject<RootObject>(fileContent);
                var aliens = rootObject.Data;

                var groupedAliens = aliens.GroupBy(alien => this.ruleSet.GetTheAffinity(alien))
                                          .Where(group => group.Key != null);

                foreach (var group in groupedAliens)
                {
                    string filePath = Path.Combine(basePath, "Resources", "Outputs", $"{group.Key.ToLower()}.json");
                    
                    Console.WriteLine($"Writing {group.Count()} aliens to {filePath}");
                    File.WriteAllText(filePath, JsonConvert.SerializeObject(group.ToList(), Formatting.Indented));
                }

                Console.WriteLine("Classification and saving complete.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"An error occurred: {ex.Message}");
            }
        }
    }
    }

