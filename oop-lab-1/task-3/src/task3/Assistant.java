package task3;

import task1.Display;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    // Adds a Display object to the assignedDisplays list
    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
        System.out.println("Assigned display: " + d.getModel());
    }

    // Iterates through assignedDisplays, comparing each Display with every other Display
    public void assist() {
        System.out.println("\nAssisting with display comparison for " + assistantName + "...");
        if (assignedDisplays.isEmpty()) {
            System.out.println("No displays assigned.");
            return;
        }

        // Compare each display with every other display
        for (int i = 0; i < assignedDisplays.size(); i++) {
            Display currentDisplay = assignedDisplays.get(i);
            for (int j = i + 1; j < assignedDisplays.size(); j++) {
                Display otherDisplay = assignedDisplays.get(j);
                System.out.println("\nComparing " + currentDisplay.getModel() + " with " + otherDisplay.getModel() + ":");
                currentDisplay.compareWithMonitor(otherDisplay);
            }
        }
    }

    // Removes a display from the list and returns it
    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println("Purchased display: " + d.getModel());
            return d;
        } else {
            System.out.println("Display not found.");
            return null;
        }
    }

    // Returns the number of assigned displays
    public int getAssignedDisplaysCount() {
        return assignedDisplays.size();
    }

    // Returns the Display object at the specified index
    public Display getDisplayByIndex(int index) {
        return assignedDisplays.get(index);
    }

    // Lists all available displays for purchase
    public void listAvailableDisplays() {
        if (assignedDisplays.isEmpty()) {
            System.out.println("No displays available for purchase.");
            return;
        }

        for (int i = 0; i < assignedDisplays.size(); i++) {
            System.out.println((i + 1) + ". " + assignedDisplays.get(i).getModel());
        }
    }
}



