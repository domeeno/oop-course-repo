package oop.practice;

public class GasStation implements Refuelable {
    private int gasCarsRefueled = 0;

    @Override
    public void refuel(int carId) {
        System.out.println("Refueling gas car " + carId + ".");
        gasCarsRefueled++;
    }

    public int getGasCarsRefueled() {
        return gasCarsRefueled;
    }
}
