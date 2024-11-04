public class PumpkinSpiceLatte : Cappuccino
{
    public int MgOfPumpkinSpice { get; set; }
    public new const string CoffeeName = "PumpkinSpiceLatte";

    public PumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) : base(intensity, mlOfMilk)
    {
        MgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails(); 
        Console.WriteLine($"{CoffeeName} pumpkin spice: {MgOfPumpkinSpice} mg");
    }
}