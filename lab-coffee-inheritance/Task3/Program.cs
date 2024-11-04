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
        
        var cappuccino = Cappuccino.MakeCappuccino(Intensity.MEDIUM, 100);
        cappuccino.PrintCoffeeDetails();

        
        var pumpkinSpiceLatte = PumpkinSpiceLatte.MakePumpkinSpiceLatte(Intensity.MEDIUM, 100, 50);
        pumpkinSpiceLatte.PrintCoffeeDetails();

        
        var americano = Americano.MakeAmericano(Intensity.LIGHT, 200);
        americano.PrintCoffeeDetails();

        
        var syrupCappuccino = SyrupCappuccino.MakeSyrupCappuccino(Intensity.STRONG, 100, SyrupType.VANILLA);
        syrupCappuccino.PrintCoffeeDetails();
    }
}
