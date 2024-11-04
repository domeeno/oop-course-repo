public class SyrupCappuccino : Cappuccino
{
    public SyrupType Syrup { get; set; }
    public new const string CoffeeName = "SyrupCappuccino";

    
    protected SyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) 
        : base(intensity, mlOfMilk)
    {
        Syrup = syrup;
    }

    
    public static SyrupCappuccino MakeSyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup)
    {
        var syrupCappuccino = new SyrupCappuccino(intensity, mlOfMilk, syrup);
        syrupCappuccino.MakeCoffee();  
        Console.WriteLine($"Adding {mlOfMilk} ml of milk");
        Console.WriteLine($"Adding syrup: {syrup}");
        return syrupCappuccino;
    }

    
    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails();  
        Console.WriteLine($"{CoffeeName} syrup: {Syrup}");
    }

    
    protected override void MakeCoffee()
    {
        Console.WriteLine($"Making {CoffeeName}"); 
        Console.WriteLine($"Intensity set to {CoffeeIntensity}");
    }
}