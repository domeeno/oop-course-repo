public class PumpkinSpiceLatte : Cappuccino
{
    public int MgOfPumpkinSpice { get; set; }
    public new const string CoffeeName = "PumpkinSpiceLatte";

    protected PumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) 
        : base(intensity, mlOfMilk)
    {
        MgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public static PumpkinSpiceLatte MakePumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice)
    {
        var latte = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
        latte.MakeCoffee();
        Console.WriteLine($"Adding {mlOfMilk} ml of milk");
        Console.WriteLine($"Adding {mgOfPumpkinSpice} mg of pumpkin spice");
        return latte;
    }

    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails();
        Console.WriteLine($"{CoffeeName} pumpkin spice: {MgOfPumpkinSpice} mg");
    }

    protected override void MakeCoffee()
    {
        Console.WriteLine($"Making {CoffeeName}");
        Console.WriteLine($"Intensity set to {CoffeeIntensity}");
    }
}