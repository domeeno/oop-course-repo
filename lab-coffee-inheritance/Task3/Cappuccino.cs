public class Cappuccino : Coffee
{
    public int MlOfMilk { get; set; }
    public const string CoffeeName = "Cappuccino";

    protected Cappuccino(Intensity intensity, int mlOfMilk) : base(intensity)
    {
        MlOfMilk = mlOfMilk;
    }

    public static Cappuccino MakeCappuccino(Intensity intensity, int mlOfMilk)
    {
        var cappuccino = new Cappuccino(intensity, mlOfMilk);
        cappuccino.MakeCoffee(); 
        Console.WriteLine($"Adding {mlOfMilk} ml of milk");
        return cappuccino;
    }

    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails(); 
        Console.WriteLine($"{CoffeeName} milk: {MlOfMilk} ml");
    }

    protected override void MakeCoffee()
    {
        Console.WriteLine($"Making {CoffeeName}"); 
        Console.WriteLine($"Intensity set to {CoffeeIntensity}");
    }
}