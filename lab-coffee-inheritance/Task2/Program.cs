using System;

// Enum for Coffee Intensity Levels
public enum Intensity
{
    LIGHT,
    MEDIUM,
    STRONG
}

// Enum for Syrup Types
public enum SyrupType
{
    MACADAMIA,
    VANILLA,
    COCONUT,
    CARAMEL,
    CHOCOLATE,
    POPCORN
}

// Base Coffee class
public class Coffee
{
    public Intensity CoffeeIntensity { get; set; }
    public const string Name = "Coffee";

    // Constructor for Coffee
    public Coffee(Intensity coffeeIntensity)
    {
        CoffeeIntensity = coffeeIntensity;
    }

    // Virtual method to print coffee details, will be overridden in subclasses
    public virtual void PrintCoffeeDetails()
    {
        Console.WriteLine($"{Name} intensity: {CoffeeIntensity}");
    }
}

// Cappuccino class inheriting from Coffee
public class Cappuccino : Coffee
{
    public int MlOfMilk { get; set; }
    public const string CoffeeName = "Cappuccino";

    // Constructor for Cappuccino
    public Cappuccino(Intensity intensity, int mlOfMilk) : base(intensity)
    {
        MlOfMilk = mlOfMilk;
    }

    // Override to print cappuccino details
    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails();  // Call parent class method
        Console.WriteLine($"{CoffeeName} milk: {MlOfMilk} ml");
    }
}

// PumpkinSpiceLatte class inheriting from Cappuccino
public class PumpkinSpiceLatte : Cappuccino
{
    public int MgOfPumpkinSpice { get; set; }
    public new const string CoffeeName = "PumpkinSpiceLatte";

    // Constructor for PumpkinSpiceLatte
    public PumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) : base(intensity, mlOfMilk)
    {
        MgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    // Override to print PumpkinSpiceLatte details
    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails();  // Call Cappuccino's PrintCoffeeDetails
        Console.WriteLine($"{CoffeeName} pumpkin spice: {MgOfPumpkinSpice} mg");
    }
}

// Americano class inheriting from Coffee
public class Americano : Coffee
{
    public int MlOfWater { get; set; }
    public const string CoffeeName = "Americano";

    // Constructor for Americano
    public Americano(Intensity intensity, int mlOfWater) : base(intensity)
    {
        MlOfWater = mlOfWater;
    }

    // Override to print Americano details
    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails();  // Call Coffee's PrintCoffeeDetails
        Console.WriteLine($"{CoffeeName} water: {MlOfWater} ml");
    }
}

// SyrupCappuccino class inheriting from Cappuccino
public class SyrupCappuccino : Cappuccino
{
    public SyrupType Syrup { get; set; }
    public new const string CoffeeName = "SyrupCappuccino";

    // Constructor for SyrupCappuccino
    public SyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) : base(intensity, mlOfMilk)
    {
        Syrup = syrup;
    }

    // Override to print SyrupCappuccino details
    public override void PrintCoffeeDetails()
    {
        base.PrintCoffeeDetails();  // Call Cappuccino's PrintCoffeeDetails
        Console.WriteLine($"{CoffeeName} syrup: {Syrup}");
    }
}

public class Program
{
    public static void Main()
    {
        var cappuccino = new Cappuccino(Intensity.MEDIUM, 50);
        cappuccino.PrintCoffeeDetails();

        var pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.STRONG, 60, 10);
        pumpkinSpiceLatte.PrintCoffeeDetails();

        var americano = new Americano(Intensity.LIGHT, 100);
        americano.PrintCoffeeDetails();

        var syrupCappuccino = new SyrupCappuccino(Intensity.MEDIUM, 50, SyrupType.VANILLA);
        syrupCappuccino.PrintCoffeeDetails();
    }
}
