public class Display
{
    private int width;
    private int height;
    private float ppi;
    private string model;

    public Display(int width, int height, float ppi, string model)
    {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public void CompareSize(Display other)
    {
        int thisSize = this.width * this.height;
        int otherSize = other.width * other.height;

        if (thisSize > otherSize)
        {
            Console.WriteLine($"{this.model} is larger than {other.model}.");
        }
        else if (thisSize < otherSize)
        {
            Console.WriteLine($"{other.model} is larger than {this.model}.");
        }
        else
        {
            Console.WriteLine($"{this.model} and {other.model} are the same size.");
        }
    }

    public void CompareSharpness(Display other)
    {
        if (this.ppi > other.ppi)
        {
            Console.WriteLine($"{this.model} has a higher sharpness than {other.model}.");
        }
        else if (this.ppi < other.ppi)
        {
            Console.WriteLine($"{other.model} has a higher sharpness than {this.model}.");
        }
        else
        {
            Console.WriteLine($"{this.model} and {other.model} have the same sharpness.");
        }
    }

    public void CompareWithMonitor(Display other)
    {
        Console.WriteLine($"Comparing {this.model} with {other.model}:");
        CompareSize(other);
        CompareSharpness(other);
    }
}

public class Program
{
    public static void Main()
    {
        Display display1 = new Display(1920, 1080, 300, "Display1");
        Display display2 = new Display(2560, 1440, 350, "Display2");
        Display display3 = new Display(1920, 1080, 280, "Display3");

        display1.CompareWithMonitor(display2); 
        display2.CompareWithMonitor(display3); 
        display1.CompareWithMonitor(display3); 
    }
}
