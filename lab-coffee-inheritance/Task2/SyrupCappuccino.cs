public class SyrupCappuccino : Cappuccino
{
    public SyrupType Syrup { get; set; }
    public new const string CoffeeName = "SyrupCappuccino";

    public SyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) : base(intensity, mlOfMilk)
    {
        Syrup = syrup;
    }

    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails();
        Console.WriteLine($"{CoffeeName} syrup: {Syrup}");
    }
}