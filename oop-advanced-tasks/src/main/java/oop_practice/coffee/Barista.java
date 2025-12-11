package oop_practice.coffee;

public class Barista {

    private void brewCoffee(Intensity intensity) {
        System.out.println("Intensity set to " + intensity);
    }

    private void addMilk(int mlOfMilk) {
        System.out.println("Adding " + mlOfMilk + " ml of milk");
    }

    public Coffee makeCoffee(Intensity intensity) {
        System.out.println("Making Coffee");
        brewCoffee(intensity);

        var coffee = new Coffee(intensity);
        coffee.printCoffeeDetails();
        return coffee;
    }

    public Cappuccino makeCappuccino(Intensity intensity, int mlOfMilk) {
        System.out.println("Making Cappuccino");
        brewCoffee(intensity);
        addMilk(mlOfMilk);

        var drink = new Cappuccino(intensity, mlOfMilk);
        drink.printCoffeeDetails();
        return drink;
    }

    public PumpkinSpiceLatte makePumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        System.out.println("Making Pumpkin Spice Latte");
        brewCoffee(intensity);
        addMilk(mlOfMilk);
        System.out.println("Adding " + mgOfPumpkinSpice + " mg of pumpkin spice");

        var drink = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
        drink.printCoffeeDetails();
        return drink;
    }

    public SyrupCappuccino makeSyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) {
        System.out.println("Making Syrup Cappuccino");
        brewCoffee(intensity);
        addMilk(mlOfMilk);
        System.out.println("Syrup set to " + syrup);

        var drink = new SyrupCappuccino(intensity, mlOfMilk, syrup);
        drink.printCoffeeDetails();
        return drink;
    }

    public Americano makeAmericano(Intensity intensity, int mlOfWater) {
        System.out.println("Making Americano");
        brewCoffee(intensity);
        System.out.println("Adding " + mlOfWater + " ml of water");

        var drink = new Americano(intensity, mlOfWater);
        drink.printCoffeeDetails();
        return drink;
    }
}
