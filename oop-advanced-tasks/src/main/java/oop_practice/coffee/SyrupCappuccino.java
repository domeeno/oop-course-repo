package oop_practice.coffee;

class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    private final String coffeeName = "Syrup Cappuccino";

    public SyrupCappuccino() {
        super();
        this.syrup = SyrupType.VANILLA;
    }

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
    }

    public void setSyrup(SyrupType syrup) {
        this.syrup = syrup;
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    public String  getCoffeeName() {
        return coffeeName;
    }

    public void  printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Syrup in the cappuccino: " + syrup);
    }
}
