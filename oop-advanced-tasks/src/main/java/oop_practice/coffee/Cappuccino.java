package oop_practice.coffee;

class Cappuccino extends Coffee {
    private int mlOfMilk;
    private final String coffee = "Cappuccino";

    public Cappuccino() {
        super();
        this.mlOfMilk = 0;
    }

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }

    public String getCoffee() {
        return coffee;
    }

    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Cappuccino milk: " + getMlOfMilk() + " ml");
    }
}
