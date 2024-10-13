namespace csharp_classification.Core
{
    public class Subspecies
    {
        public bool? IsHumanoid { get; set; }
        public string? Planet { get; set; }
        public double? MaxAge { get; set; }
        public List<string> Traits { get; set; } = new List<string>();
    }
    }
