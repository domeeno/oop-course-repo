package task1;

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(1920, 1080, 300, "Monitor A");
        Display display2 = new Display(2560, 1440, 350, "Monitor B");
        Display display3 = new Display(1920, 1080, 280, "Monitor C");

        display1.compareWithMonitor(display2); // Compare display1 object with display2 parameter and so on
        display1.compareWithMonitor(display3);
        display2.compareWithMonitor(display3);
    }
}
