using System;

public class Display
{
    public int width;
    public int height;
    public float ppi;
    public string model;

    public Display(int width, int height, float ppi, string model)
    {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public void CompareSize(Display other)
    {
        if (this.width * this.height > other.width * other.height)
            Console.WriteLine($"{this.model} is larger than {other.model}");
        else if (this.width * this.height < other.width * other.height)
            Console.WriteLine($"{other.model} is larger than {this.model}");
        else
            Console.WriteLine($"{this.model} and {other.model} are the same size.");
    }

    public void CompareSharpness(Display other)
    {
        if (this.ppi > other.ppi)
            Console.WriteLine($"{this.model} is sharper than {other.model}");
        else if (this.ppi < other.ppi)
            Console.WriteLine($"{other.model} is sharper than {this.model}");
        else
            Console.WriteLine($"{this.model} and {other.model} have the same sharpness.");
    }

    public void CompareWithMonitor(Display other)
    {
        CompareSize(other);
        CompareSharpness(other);
    }
}