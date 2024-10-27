using System;
using System.Collections.Generic;

public class Assistant
{
    private string assistantName;
    private List<Display> assignedDisplays = new List<Display>();

    public Assistant(string name)
    {
        assistantName = name;
    }

    public void AssignDisplay(Display d)
    {
        assignedDisplays.Add(d);
        Console.WriteLine($"{d.model} has been assigned to {assistantName}");
    }

    public void Assist()
    {
        if (assignedDisplays.Count < 2)
        {
            Console.WriteLine("Not enough displays to compare.");
            return;
        }

        Console.WriteLine($"{assistantName} is assisting with comparisons:");

        for (int i = 0; i < assignedDisplays.Count - 1; i++)
        {
            Display current = assignedDisplays[i];
            Display next = assignedDisplays[i + 1];
            current.CompareWithMonitor(next);
        }
        if (assignedDisplays.Count > 2)
        {
            Display current = assignedDisplays[assignedDisplays.Count-1];
            Display next = assignedDisplays[0];
            current.CompareWithMonitor(next);
        }
    }

    public Display BuyDisplay(Display d)
    {
        if (assignedDisplays.Remove(d))
        {
            Console.WriteLine($"{d.model} has been removed from {assistantName}'s list.");
            return d;
        }
        else
        {
            Console.WriteLine($"{d.model} was not found in the list.");
            return null;
        }
    }
}
