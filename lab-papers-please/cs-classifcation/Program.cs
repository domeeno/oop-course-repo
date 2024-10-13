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
        
    }

public string ClassifyByUniverse()
{
    
    var traitsList = Traits ?? new List<string>();
    var isHumanoidValue = IsHumanoid;
    var planetValue = Planet ?? string.Empty;
    var ageValue = Age;

    
    string classification = "Unknown Universe";

    
    if (isHumanoidValue == false)
    {
        if (planetValue == "Kashyyyk")
        {
            classification = "Star Wars Universe (Wookie)";
        }
        else if (planetValue == "Endor")
        {
            classification = "Star Wars Universe (Ewok)";
        }
        else if (planetValue == "Vogsphere")
        {
            classification = "Hitchhiker's Universe (Vogons)";
        }
        else
        {
            if (ageValue > 200)
            {
                classification = "Star Wars Universe (Wookie)";
            }
            else if (ageValue > 60)
            {
                if (traitsList.Contains("HAIRY") || traitsList.Contains("TALL"))
                {
                    classification = "Star Wars Universe (Wookie)";
                }
                else if (traitsList.Contains("BULKY") || traitsList.Contains("GREEN"))
                {
                    classification = "Hitchhiker's Universe (Vogons)";
                }
            }
            else
            {
                if (traitsList.Contains("BULKY") || traitsList.Contains("GREEN"))
                {
                    classification = "Hitchhiker's Universe (Vogons)";
                }
                else if (traitsList.Contains("TALL"))
                {
                    classification = "Star Wars Universe (Wookie)";
                }
                else if (traitsList.Contains("SHORT"))
                {
                    classification = "Star Wars Universe (Ewok)";
                }
            }
        }
    }
    else if (isHumanoidValue == true)
    {
        if (planetValue == "Asgard")
        {
            classification = "Marvel Universe (Asgardian)";
        }
        else if (planetValue == "Betelgeuse")
        {
            classification = "Hitchhiker's Universe (Betelgeusian)";
        }
        else if (planetValue == "Earth")
        {
            if (ageValue>200)
            {
                classification = "Lord of the Rings Universe (Elf)";
            }
            else
            {
                if (traitsList.Contains("BLONDE") || traitsList.Contains("POINTY_EARS"))
                {
                    classification = "Lord of the Rings Universe (Elf)";
                }
                else if (traitsList.Contains("SHORT") || traitsList.Contains("BULKY"))
                {
                    classification = "Lord of the Rings Universe (Dwarf)";
                }
            }
        }
        else
        {
            if (ageValue>5000)
            {
                classification = "Lord of the Rings Universe (Elf)";
            }
            else if (ageValue>200)
            {
                if (traitsList.Contains("TALL"))
                {
                    classification = "Marvel Universe (Asgardian)";
                }
                else if (traitsList.Contains("POINTY_EARS"))
                {
                    classification = "Lord of the Rings Universe (Elf)";
                }
            }
            else
            {
                if (traitsList.Contains("EXTRA_ARMS") || traitsList.Contains("EXTRA_HEAD"))
                {
                    classification = "Hitchhiker's Universe (Betelgeusian)";
                }
                else if (traitsList.Contains("SHORT") || traitsList.Contains("BULKY"))
                {
                    classification = "Lord of the Rings Universe (Dwarf)";
                }
                else if (traitsList.Contains("TALL"))
                {
                    classification = "Marvel Universe (Asgardian)";
                }
                else if (traitsList.Contains("POINTY_EARS"))
                {
                    classification = "Lord of the Rings Universe (Elf)";
                }
            }
        }
    }
    else
    {
        if (planetValue == "Kashyyyk")
        {
            classification = "Star Wars Universe (Wookie)";
        }
        else if (planetValue == "Endor")
        {
            classification = "Star Wars Universe (Ewok)";
        }
        else if (planetValue == "Asgard")
        {
            classification = "Marvel Universe (Asgardian)";
        }
        else if (planetValue == "Betelgeuse")
        {
            classification = "Hitchhiker's Universe (Betelgeusian)";
        }
        else if (planetValue == "Vogsphere")
        {
            classification = "Hitchhiker's Universe (Vogons)";
        }
        else if (planetValue == "Earth")
        {
            if (ageValue>200)
            {
                classification = "Lord of the Rings Universe (Elf)";
            }
            else
            {
                if (traitsList.Contains("BLONDE") || traitsList.Contains("POINTY_EARS"))
                {
                    classification = "Lord of the Rings Universe (Elf)";
                }
                else if (traitsList.Contains("SHORT") || traitsList.Contains("BULKY"))
                {
                    classification = "Lord of the Rings Universe (Dwarf)";
                }
            }
        }
        else
        {
            if (ageValue>5000)
            {
                classification = "Lord of the Rings Universe (Elf)";
            }
            else if (ageValue>400)
            {
                if (traitsList.Contains("TALL"))
                {
                    classification = "Marvel Universe (Asgardian)";
                }
                else if (traitsList.Contains("POINTY_EARS"))
                {
                    classification = "Lord of the Rings Universe (Elf)";
                }
            }
            else if (ageValue>60)
            {
                if (traitsList.Contains("EXTRA_ARMS") || traitsList.Contains("EXTRA_HEAD"))
                {
                    classification = "Hitchhiker's Universe (Betelgeusian)";
                }
                else if (traitsList.Contains("GREEN"))
                {
                    classification = "Hitchhiker's Universe (Vogons)";
                }
                else if (traitsList.Contains("SHORT"))
                {
                    classification = "Lord of the Rings Universe (Dwarf)";
                }
                else if (traitsList.Contains("HAIRY"))
                {
                    classification = "Star Wars Universe (Wookie)";
                }
                else if (traitsList.Contains("POINTY_EARS"))
                {
                    classification = "Lord of the Rings Universe (Elf)";
                }
                else if (traitsList.Contains("BLONDE") && traitsList.Contains("TALL"))
                {
                    classification = "Marvel Universe (Asgardian)";
                }
            }
            else
            {
                if (traitsList.Contains("EXTRA_ARMS") || traitsList.Contains("EXTRA_HEAD"))
                {
                    classification = "Hitchhiker's Universe (Betelgeusian)";
                }
                else if (traitsList.Contains("GREEN"))
                {
                    classification = "Hitchhiker's Universe (Vogons)";
                }
                else if (traitsList.Contains("SHORT") && traitsList.Contains("BULKY"))
                {
                    classification = "Lord of the Rings Universe (Dwarf)";
                }
                else if (traitsList.Contains("HAIRY") && traitsList.Contains("TALL"))
                {
                    classification = "Star Wars Universe (Wookie)";
                }
                else if (traitsList.Contains("POINTY_EARS"))
                {
                    classification = "Lord of the Rings Universe (Elf)";
                }
                else if (traitsList.Contains("BLONDE") && traitsList.Contains("TALL"))
                {
                    classification = "Marvel Universe (Asgardian)";
                }
                else if (traitsList.Contains("SHORT") && traitsList.Contains("HAIRY"))
                {
                    classification = "Marvel Universe (Asgardian)";
                }
            }
        }
    }

    return classification;
}

}

public class Program
{
    public static void Main(string[] args)
    {
        string filePath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "..\\..\\..\\..\\input.json");
        string outputDir = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "..\\..\\..\\..\\output");

        try
        {
            
            if (!Directory.Exists(outputDir))
            {
                Directory.CreateDirectory(outputDir);
            }

            string jsonString = File.ReadAllText(filePath);
            var options = new JsonSerializerOptions
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            };

            LaboratoryDataWrapper dataWrapper = JsonSerializer.Deserialize<LaboratoryDataWrapper>(jsonString, options);

            
            List<LaboratoryData> hitchhikerList = new List<LaboratoryData>();
            List<LaboratoryData> marvelList = new List<LaboratoryData>();
            List<LaboratoryData> ringsList = new List<LaboratoryData>();
            List<LaboratoryData> starWarsList = new List<LaboratoryData>();

            foreach (var data in dataWrapper.Input)
            {
                data.PrintInfo();
                string classification = data.ClassifyByUniverse();
                

                
                switch (classification)
                {
                    case "Hitchhiker's Universe (Vogons)":
                    case "Hitchhiker's Universe (Betelgeusian)":
                        hitchhikerList.Add(data);
                        break;
                    case "Marvel Universe (Asgardian)":
                        marvelList.Add(data);
                        break;
                    case "Lord of the Rings Universe (Elf)":
                    case "Lord of the Rings Universe (Dwarf)":
                        ringsList.Add(data);
                        break;
                    case "Star Wars Universe (Wookie)":
                    case "Star Wars Universe (Ewok)":
                        starWarsList.Add(data);
                        break;
                }
            }

            
            WriteToJsonFile(Path.Combine(outputDir, "hitchhiker.json"), hitchhikerList);
            WriteToJsonFile(Path.Combine(outputDir, "marvel.json"), marvelList);
            WriteToJsonFile(Path.Combine(outputDir, "rings.json"), ringsList);
            WriteToJsonFile(Path.Combine(outputDir, "starwars.json"), starWarsList);
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

    
    private static void WriteToJsonFile(string filePath, List<LaboratoryData> data)
    {
        var options = new JsonSerializerOptions
        {
            WriteIndented = true
        };
        string json = JsonSerializer.Serialize(data, options);
        File.WriteAllText(filePath, json);
    }
}