package oop_practice.coffee;

class Americano extends Coffee {
    private int mlOfWater;
    private final String coffeeName = "Americano";

    public Americano() {
        super();
        this.mlOfWater = 0;
    }

    public Americano(Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public void setMlOfWater(int mlOfWater) {
        this.mlOfWater = mlOfWater;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Americano water: " + getMlOfWater() + " ml");
    }
}
