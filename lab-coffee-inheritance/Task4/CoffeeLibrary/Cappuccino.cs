namespace CoffeeLibrary
{
    internal class Cappuccino : Coffee
    {
        internal int MlOfMilk { get; private set; }
        internal const string CoffeeName = "Cappuccino";

        protected Cappuccino(Intensity intensity, int mlOfMilk) : base(intensity)
        {
            MlOfMilk = mlOfMilk;
        }

        internal static Cappuccino MakeCappuccino(Intensity intensity, int mlOfMilk)
        {
            var cappuccino = new Cappuccino(intensity, mlOfMilk);
            cappuccino.MakeCoffee();
            Console.WriteLine($"Adding {mlOfMilk} ml of milk");
            return cappuccino;
        }

        internal override void PrintCoffeeDetails()
        {
            base.PrintCoffeeDetails();  
            Console.WriteLine($"Milk: {MlOfMilk} ml");
        }

        protected override void MakeCoffee()
        {
            Console.WriteLine($"Making {CoffeeName}");
            Console.WriteLine($"Intensity set to {CoffeeIntensity}");
        }
    }
}
