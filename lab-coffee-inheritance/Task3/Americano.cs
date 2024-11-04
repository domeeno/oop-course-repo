public class Americano : Coffee
{
    public int MlOfWater { get; set; }
    public const string CoffeeName = "Americano";

    protected Americano(Intensity intensity, int mlOfWater) : base(intensity)
    {
        MlOfWater = mlOfWater;
    }

    public static Americano MakeAmericano(Intensity intensity, int mlOfWater)
    {
        var americano = new Americano(intensity, mlOfWater);
        americano.MakeCoffee();
        Console.WriteLine($"Adding {mlOfWater} ml of water");
        return americano;
    }

    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails();
        Console.WriteLine($"{CoffeeName} water: {MlOfWater} ml");
    }

    protected override void MakeCoffee()
    {
        Console.WriteLine($"Making {CoffeeName}"); 
        Console.WriteLine($"Intensity set to {CoffeeIntensity}");
    }
}