namespace csharp_classification.Core
{
    public class Alien
    {
        public int Id { get; set; }
        public string? Planet { get; set; } = string.Empty;
        public bool? IsHumanoid { get; set; }
        public double? Age { get; set; }
        public List<string>? Traits { get; set; } = new List<string>();


        public override string ToString()
        {
            return $"ID: {Id},, Planet: {Planet}, Is Humanoid: {IsHumanoid}, Age: {Age}, Traits: {string.Join(", ", Traits)}";

        }
    }


}
