public class Cappuccino : Coffee
{
    public int MlOfMilk { get; set; }
    public const string CoffeeName = "Cappuccino";

    public Cappuccino(Intensity intensity, int mlOfMilk) : base(intensity)
    {
        MlOfMilk = mlOfMilk;
    }

    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails(); 
        Console.WriteLine($"{CoffeeName} milk: {MlOfMilk} ml");
    }
}