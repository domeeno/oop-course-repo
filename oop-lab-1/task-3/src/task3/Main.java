package task3;

import task1.Display;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Assistant assistant = new Assistant("Display Assistant");

        // Create multiple Display objects
        Display display1 = new Display(1920, 1080, 24.5f, "Dell 24 Monitor");
        Display display2 = new Display(2560, 1440, 27.0f, "LG UltraFine 27");
        Display display3 = new Display(3840, 2160, 32.0f, "Samsung UHD 32");
        Display display4 = new Display(5120, 2880, 27.0f, "Apple Pro Display XDR");
        Display display5 = new Display(1920, 1080, 21.5f, "HP Pavilion 22");

        // Assign displays to the assistant
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);
        assistant.assignDisplay(display4);
        assistant.assignDisplay(display5);

        // Assist with display comparison
        assistant.assist();

        // Buy a display
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAvailable displays to purchase:");
        assistant.listAvailableDisplays();  // Added method to list available displays

        System.out.print("\nEnter the number of the display to buy (1-" + assistant.getAssignedDisplaysCount() + "): ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= assistant.getAssignedDisplaysCount()) {
            Display selectedDisplay = assistant.getDisplayByIndex(choice - 1);
            assistant.buyDisplay(selectedDisplay);
        } else {
            System.out.println("Invalid choice. Please select a valid display number.");
        }

        // Print remaining displays
        System.out.println("\nRemaining displays:");
        assistant.listAvailableDisplays();

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}

