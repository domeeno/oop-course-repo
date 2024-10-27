using System;

public class Program
{
    public static void Main()
    {
        Display display1 = new Display(1920, 1080, 100, "Display A");
        Display display2 = new Display(2560, 1440, 120, "Display B");
        Display display3 = new Display(3840, 2160, 140, "Display C");
        
        Assistant assistant = new Assistant("OOP Assistant");
        assistant.AssignDisplay(display1);
        assistant.AssignDisplay(display2);
        assistant.AssignDisplay(display3);

        assistant.Assist();

        assistant.BuyDisplay(display2);

        assistant.Assist();
    }
}