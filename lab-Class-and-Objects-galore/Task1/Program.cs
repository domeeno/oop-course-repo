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