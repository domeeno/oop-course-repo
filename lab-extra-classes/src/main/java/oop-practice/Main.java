import java.lang.Math;

class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getPpi() {
        return ppi;
    }

    public String getModel() {
        return model;
    }

    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }


    public void compareSize(Display m) {
        System.out.println("Comparing display sizes");
        System.out.println();
        System.out.println(this.model + "'s diagonal: " + this.getDiagonal());
        System.out.println(m.model + "'s diagonal: " + m.getDiagonal());
        System.out.println();

        if (this.getDiagonal() > m.getDiagonal()) {
            System.out.println(this.model + " is bigger than " + m.model);
        }

        else if (this.getDiagonal() < m.getDiagonal()) {
            System.out.println(m.model + " is bigger than " + this.model);
        }

        else {
            System.out.println(this.model + " has the same size as " + m.model);
        }

        System.out.println();

    }

    public void compareSharpness(Display m) {
        System.out.println("Comparing PPI");
        System.out.println();
        System.out.println(this.model + "'s PPI: " + this.ppi);
        System.out.println(m.model + "'s PPI: " + m.ppi);
        System.out.println();

        if (this.ppi > m.ppi) {
            System.out.println(this.model + " is more sharper than " + m.model);
        }

        else if (this.ppi < m.ppi) {
            System.out.println(m.model + " is more sharper than " + this.model);
        }

        else  {
            System.out.println(this.model + " has the same sharpness as " + m.model);
        }

        System.out.println();
    }

    public void compareWithMonitor(Display m) {
        System.out.println("Comparing monitors");

        System.out.println("\nSize comparison");
        System.out.println(this.model + "'s diagonal: " + this.getDiagonal());
        System.out.println(m.model + "'s diagonal: " + m.getDiagonal());

        System.out.println("\nSharpness comparison");
        System.out.println(this.model + "'s PPI: " + this.ppi);
        System.out.println(m.model + "'s PPI: " + m.ppi);

        System.out.println();

        if ((this.ppi > m.ppi) && (this.getDiagonal() > m.getDiagonal())) {
            System.out.println(this.model + " is BOTH sharper and bigger than " + m.model);
        }

        else if ((this.ppi > m.ppi) && (this.getDiagonal() < m.getDiagonal())) {
            System.out.println(this.model + " is sharper, but smaller than " + m.model);
        }

        else if ((this.ppi < m.ppi) && (this.getDiagonal() > m.getDiagonal())) {
            System.out.println(m.model + " is sharper, but smaller than " + this.model);
        }

        else if ((this.ppi < m.ppi) && (this.getDiagonal() < m.getDiagonal())) {
            System.out.println(m.model + " is BOTH sharper and bigger than " + this.model);
        }

        else {
            System.out.println("Displays are the same in terms of specs! ");
        }
        System.out.println();

    }
}

public class Main {
    public static void main(String[] args) {
        var display1 = new Display(1920, 1080, 50, "Preekol Ultra");
        var display2 = new Display(1920, 1080, 80, "Rzhaka Omega Super");
        var display3 = new Display(2440, 1440, 90, "Mega Cool Monitor");
        display1.compareSize(display2);
        display2.compareSharpness(display1);
        display3.compareWithMonitor(display1);
    }
}