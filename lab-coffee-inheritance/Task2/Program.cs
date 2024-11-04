public enum Intensity
{
    LIGHT,
    MEDIUM,
    STRONG
}

public enum SyrupType
{
    MACADAMIA,
    VANILLA,
    COCONUT,
    CARAMEL,
    CHOCOLATE,
    POPCORN
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
