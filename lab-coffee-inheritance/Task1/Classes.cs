public enum Intensity
{
    LIGHT,
    NORMAL,
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

public class Coffee
{
    protected Intensity coffeeIntensity;
    protected const string name = "Coffee";

    public Coffee(Intensity coffeeIntensity)
    {
        this.coffeeIntensity = coffeeIntensity;
    }

    public string GetName()
    {
        return name;
    }

    public Intensity GetIntensity()
    {
        return coffeeIntensity;
    }

    public void SetIntensity(Intensity intensity)
    {
        coffeeIntensity = intensity;
    }
}

public class Cappuccino : Coffee
{
    protected int mlOfMilk;
    protected const string coffee = "Cappuccino";

    public Cappuccino(Intensity intensity, int mlOfMilk) : base(intensity)
    {
        this.mlOfMilk = mlOfMilk;
    }

    public string GetCoffeeName()
    {
        return coffee;
    }

    public int GetMlOfMilk()
    {
        return mlOfMilk;
    }

    public void SetMlOfMilk(int mlOfMilk)
    {
        this.mlOfMilk = mlOfMilk;
    }
}

public class PumpkinSpiceLatte : Cappuccino
{
    protected int mgOfPumpkinSpice;
    protected const string name = "PumpkinSpiceLatte";

    public PumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) : base(intensity, mlOfMilk)
    {
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public string GetCoffeeName()
    {
        return name;
    }

    public int GetMgOfPumpkinSpice()
    {
        return mgOfPumpkinSpice;
    }

    public void SetMgOfPumpkinSpice(int mgOfPumpkinSpice)
    {
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }
}

public class Americano : Coffee
{
    protected int mlOfWater;
    protected const string coffeeName = "Americano";

    public Americano(Intensity intensity, int mlOfWater) : base(intensity)
    {
        this.mlOfWater = mlOfWater;
    }

    public string GetCoffeeName()
    {
        return coffeeName;
    }

    public int GetMlOfWater()
    {
        return mlOfWater;
    }

    public void SetMlOfWater(int mlOfWater)
    {
        this.mlOfWater = mlOfWater;
    }
}

public class SyrupCappuccino : Cappuccino
{
    protected SyrupType syrup;
    protected const string coffee = "SyrupCappuccino";

    public SyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) : base(intensity, mlOfMilk)
    {
        this.syrup = syrup;
    }

    public string GetCoffeeName()
    {
        return coffee;
    }

    public SyrupType GetSyrup()
    {
        return syrup;
    }

    public void SetSyrup(SyrupType syrup)
    {
        this.syrup = syrup;
    }
}
