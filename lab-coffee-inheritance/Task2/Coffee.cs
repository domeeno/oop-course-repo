public class Coffee
{
    public Intensity CoffeeIntensity { get; set; }
    public const string Name = "Coffee";

    public Coffee(Intensity coffeeIntensity)
    {
        CoffeeIntensity = coffeeIntensity;
    }

    public virtual void PrintCoffeeDetails()
    {
        Console.WriteLine($"{Name} intensity: {CoffeeIntensity}");
    }
}