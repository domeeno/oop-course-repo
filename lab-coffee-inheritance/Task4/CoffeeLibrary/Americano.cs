namespace CoffeeLibrary
{
    internal class Americano : Coffee
    {
        internal int MlOfWater { get; private set; }
        internal const string CoffeeName = "Americano";

        protected Americano(Intensity intensity, int mlOfWater) : base(intensity)
        {
            MlOfWater = mlOfWater;
        }

        internal static Americano MakeAmericano(Intensity intensity, int mlOfWater)
        {
            var americano = new Americano(intensity, mlOfWater);
            americano.MakeCoffee();
            Console.WriteLine($"Adding {mlOfWater} ml of water");
            return americano;
        }

        internal override void PrintCoffeeDetails()
        {
            base.PrintCoffeeDetails(); 
            Console.WriteLine($"Water: {MlOfWater} ml");
        }

        protected override void MakeCoffee()
        {
            Console.WriteLine($"Making {CoffeeName}");
            Console.WriteLine($"Intensity set to {CoffeeIntensity}");
        }
    }
}
