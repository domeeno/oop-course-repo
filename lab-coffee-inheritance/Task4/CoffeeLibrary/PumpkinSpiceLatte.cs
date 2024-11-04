namespace CoffeeLibrary
{
    internal class PumpkinSpiceLatte : Cappuccino
    {
        internal int MgOfPumpkinSpice { get; private set; }
        internal const string CoffeeName = "PumpkinSpiceLatte";

        protected PumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) 
            : base(intensity, mlOfMilk)
        {
            MgOfPumpkinSpice = mgOfPumpkinSpice;
        }

        internal static PumpkinSpiceLatte MakePumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice)
        {
            var pumpkinSpiceLatte = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
            pumpkinSpiceLatte.MakeCoffee();
            Console.WriteLine($"Adding {mlOfMilk} ml of milk");
            Console.WriteLine($"Adding {mgOfPumpkinSpice} mg of pumpkin spice");
            return pumpkinSpiceLatte;
        }

        internal override void PrintCoffeeDetails()
        {
            base.PrintCoffeeDetails();  
            Console.WriteLine($"Pumpkin Spice: {MgOfPumpkinSpice} mg");
        }

        protected override void MakeCoffee()
        {
            Console.WriteLine($"Making {CoffeeName}");
            Console.WriteLine($"Intensity set to {CoffeeIntensity}");
        }
    }
}
