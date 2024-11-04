namespace CoffeeLibrary
{
    internal enum Intensity
    {
        LIGHT,
        MEDIUM,
        STRONG
    }

    internal enum SyrupType
    {
        MACADAMIA,
        VANILLA,
        COCONUT,
        CARAMEL,
        CHOCOLATE,
        POPCORN
    }

    internal class Coffee
    {
        internal Intensity CoffeeIntensity { get; private set; }
        internal const string Name = "Coffee";

        protected Coffee(Intensity coffeeIntensity)
        {
            CoffeeIntensity = coffeeIntensity;
        }

        internal virtual void PrintCoffeeDetails()
        {
            Console.WriteLine($"Intensity: {CoffeeIntensity}");
        }

        protected virtual void MakeCoffee()
        {
            Console.WriteLine($"Making {Name}");
            Console.WriteLine($"Intensity set to {CoffeeIntensity}");
        }
    }
}