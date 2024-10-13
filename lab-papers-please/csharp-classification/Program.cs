using csharp_classification.Core;
using System;
using System.Collections.Generic;

class Program
{
    static void Main(string[] args)
    {
        var rulesForUniverses = new Dictionary<string, List<Subspecies>>
        {
            { "StarWars", new List<Subspecies> {
                new Subspecies { IsHumanoid = false, Planet = "Kashyyyk", MaxAge = 400, Traits = new List<string> { "HAIRY", "TALL" }},
                new Subspecies { IsHumanoid = false, Planet = "Endor", MaxAge = 60, Traits = new List<string> { "HAIRY", "SHORT" }}
            }},
            { "Marvel", new List<Subspecies> {
                new Subspecies { IsHumanoid = true, Planet = "Asgard", MaxAge = 5000, Traits = new List<string> { "BLONDE", "TALL" }}
            }},
            { "Rings", new List<Subspecies> {
                new Subspecies { IsHumanoid = true, Planet = "Earth", MaxAge = Double.PositiveInfinity, Traits = new List<string> { "BLONDE", "POINTY_EARS" }},
                new Subspecies { IsHumanoid = true, Planet = "Earth", MaxAge = 200, Traits = new List<string> { "SHORT", "BULKY" }}
            }},
            { "HitchHiker", new List<Subspecies>
            {
                new Subspecies { IsHumanoid = true, Planet = "Betelgeuse", MaxAge = 100, Traits = new List<string> { "EXTRA_ARMS", "EXTRA_HEAD"}},
                new Subspecies { IsHumanoid = false, Planet = "Vogsphere", MaxAge = 200, Traits = new List<string> { "GREEN", "BULKY" }},

            }

            }

        };

        var ruleSet = new RuleSet(rulesForUniverses);
        var fileReader = new FileReader(ruleSet);
        fileReader.ClassifyAndSaveJson();

        Console.WriteLine("\nClassification complete. Press any key to exit...");
        Console.ReadKey();
    }
}
