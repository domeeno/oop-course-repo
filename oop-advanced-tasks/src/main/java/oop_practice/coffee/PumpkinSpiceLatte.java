package oop_practice.coffee;

class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;
    private final String name = "Pumpkin Spice Latte";

    public PumpkinSpiceLatte() {
        super();
        this.mgOfPumpkinSpice = 0;
    }

    public PumpkinSpiceLatte(Intensity intensityOfCoffee, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensityOfCoffee, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    public void setMgOfPumpkinSpice(int mgOfPumpkinSpice) {
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public String getName() {
        return name;
    }

    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Pumpkin spice: "  + getMgOfPumpkinSpice() + " mg");
    }
}