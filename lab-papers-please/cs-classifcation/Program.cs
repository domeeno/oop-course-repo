namespace YourProjectName
{
    public class LaboratoryData
    {
        public int Id { get; set; }
        public bool? IsHumanoid { get; set; }  
        public string Planet { get; set; }
        public int? Age { get; set; }           
        public List<string> Traits { get; set; }

        
        public LaboratoryData(int id, bool? isHumanoid, string planet, int? age, List<string> traits)
        {
            Id = id;
            IsHumanoid = isHumanoid;
            Planet = planet;
            Age = age;
            Traits = traits ?? new List<string>(); 
        }

        
        public void Print()
        {
            Console.WriteLine($"ID: {Id}, IsHumanoid: {IsHumanoid}, Planet: {Planet}, Age: {Age}, Traits: {string.Join(", ", Traits)}");
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            
            var labData1 = new LaboratoryData(0, false, "Kashyyyk", 253, new List<string> { "HAIRY", "TALL" });
            var labData2 = new LaboratoryData(1, false, "Endor", 34, new List<string> { "HAIRY", "SHORT" });
            var labData3 = new LaboratoryData(2, true, "Asgard", 2034, new List<string> { "BLONDE", "TALL" });

            
            labData1.Print();
            labData2.Print();
            labData3.Print();
        }
    }
}
