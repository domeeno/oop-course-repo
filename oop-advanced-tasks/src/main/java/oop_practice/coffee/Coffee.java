package oop_practice.coffee;

class Coffee {
    private Intensity coffeeIntensity;
    private final String name = "coffee";

    public Coffee() {
        this.coffeeIntensity = Intensity.NORMAL;
    }

    public Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public void setCoffeeIntensity(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public String getName() {
        return name;
    }

    public void printCoffeeDetails() {
        System.out.println("Coffee intensity: " + coffeeIntensity);
    }

}

