public class Americano : Coffee
{
    public int MlOfWater { get; set; }
    public const string CoffeeName = "Americano";

    public Americano(Intensity intensity, int mlOfWater) : base(intensity)
    {
        MlOfWater = mlOfWater;
    }

    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails();
        Console.WriteLine($"{CoffeeName} water: {MlOfWater} ml");
    }
}