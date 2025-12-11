import oop_practice.coffee.*;

public class Main {
    public static void main (String[] args) {
        Barista b = new Barista();
        var coffee = b.makeCappuccino(Intensity.NORMAL, 40); // valid
    }
}
