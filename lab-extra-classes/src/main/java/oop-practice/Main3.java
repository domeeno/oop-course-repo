import java.util.ArrayList;
import java.util.List;

class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
        System.out.println("Display '" + d.getModel() + "' has been assigned to " + assistantName);
    }

    public void assist() {
        if (assignedDisplays.isEmpty()) {
            System.out.println(assistantName + ": No displays to compare");
            return;
        }

        if (assignedDisplays.size() == 1) {
            System.out.println(assistantName + ": Only one display: " + assignedDisplays.get(0).getModel());
            return;
        }

        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            var current = assignedDisplays.get(i);
            var next = assignedDisplays.get(i + 1);
            current.compareWithMonitor(next);
        }
    }


    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println(assistantName + ": You've purchased " + d.getModel() + "!");
            System.out.println("This display has been removed from the list.");
            return d;
        } else {
            System.out.println(assistantName + ": Sorry, no display with that name in the list.");
            return null;
        }
    }

    public Display buyBiggestDisplay() {
        if (assignedDisplays.isEmpty()) {
            System.out.println(assistantName + ": No displays to compare");
            return null;
        }
        var biggestDisplay = assignedDisplays.get(0);
        for (Display d : assignedDisplays) {
            if (d.getDiagonal() > biggestDisplay.getDiagonal()) {
                biggestDisplay = d;
            }
        }
        return buyDisplay(biggestDisplay);
    }
}

public class Main3 {
    public static void main(String[] args) {
        var assistant1 = new Assistant("Bogdan");

        var d1 = new Display(1920, 1080, 90, "Cool Monitor");
        var d2 = new Display(2560, 1440, 90, "Premium Monitor");
        var d3 = new Display(3840, 2160, 120, "Ultra Monitor");

        assistant1.assignDisplay(d1);
        assistant1.assignDisplay(d2);
        assistant1.assignDisplay(d3);

        assistant1.assist();

        var purchased = assistant1.buyDisplay(d1);
        assistant1.buyBiggestDisplay();
    }
}