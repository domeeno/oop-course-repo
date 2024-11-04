public class Coffee
{
    public Intensity CoffeeIntensity { get; set; }
    public const string Name = "Coffee";

    protected Coffee(Intensity coffeeIntensity)
    {
        CoffeeIntensity = coffeeIntensity;
    }

    public virtual void PrintCoffeeDetails()
    {
        Console.WriteLine($"{Name} intensity: {CoffeeIntensity}");
    }

    protected virtual void MakeCoffee()
    {
        Console.WriteLine($"Making {Name}");
        Console.WriteLine($"Intensity set to {CoffeeIntensity}");
    }
}