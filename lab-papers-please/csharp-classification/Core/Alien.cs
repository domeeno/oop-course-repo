
namespace csharp_classification.Core
{
    public class Alien
    {
        public int Id { get; set; }
        public string? Name { get; set; } = string.Empty;
        public string? Planet { get; set; } = string.Empty;
        public bool? IsHumanoid { get; set; }
        public List<string>? Traits { get; set; } = new List<string>();
        public double? Age { get; set; }
    }
}
