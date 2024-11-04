namespace CoffeeLibrary
{
    internal class SyrupCappuccino : Cappuccino
    {
        internal SyrupType Syrup { get; private set; }
        internal new const string CoffeeName = "SyrupCappuccino";

        protected SyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup)
            : base(intensity, mlOfMilk)
        {
            Syrup = syrup;
        }

        internal static SyrupCappuccino MakeSyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup)
        {
            var syrupCappuccino = new SyrupCappuccino(intensity, mlOfMilk, syrup);
            syrupCappuccino.MakeCoffee();
            Console.WriteLine($"Adding {mlOfMilk} ml of milk");
            Console.WriteLine($"Adding syrup: {syrup}");
            return syrupCappuccino;
        }

        internal override void PrintCoffeeDetails()
        {
            base.PrintCoffeeDetails();  // Calls Cappuccino's PrintCoffeeDetails for intensity and milk
            Console.WriteLine($"Syrup: {Syrup}");
        }

        protected override void MakeCoffee()
        {
            Console.WriteLine($"Making {CoffeeName}");
            Console.WriteLine($"Intensity set to {CoffeeIntensity}");
        }
    }
}
