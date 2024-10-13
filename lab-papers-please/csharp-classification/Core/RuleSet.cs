namespace csharp_classification.Core
{
    public class RuleSet
    {
        private Dictionary<string, List<Subspecies>> rulesForUniverses = new Dictionary<string, List<Subspecies>> { };

        public RuleSet(Dictionary<string, List<Subspecies>> subspecies)
        {
            rulesForUniverses = subspecies;
        }

        public string? GetTheAffinity(Alien alien)
        {
          
            foreach (KeyValuePair<string, List<Subspecies>> entry in this.rulesForUniverses)
            {
                foreach (var subspecies in entry.Value)
                {
                    if (alien.IsHumanoid.HasValue && subspecies.IsHumanoid.HasValue && alien.IsHumanoid != subspecies.IsHumanoid)
                        continue;

                    if (!string.IsNullOrEmpty(alien.Planet) && !string.Equals(alien.Planet, subspecies.Planet, StringComparison.OrdinalIgnoreCase))
                        continue;

                    if (alien.Age.HasValue && alien.Age > subspecies.MaxAge)
                        continue;

                    if (alien.Traits != null && alien.Traits.Any() && (subspecies.Traits == null || !alien.Traits.All(trait => subspecies.Traits.Contains(trait))))
                        continue;

                    return entry.Key;
                }
            }
            return null;
        }
    }

    

}

