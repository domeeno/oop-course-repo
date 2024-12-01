package oop.practice;

// Electric Station Class
public class ElectricStation implements Refuelable {
    private int electricCarsRefueled = 0;

    @Override
    public void refuel(int carId) {
        System.out.println("Refueling electric car " + carId + ".");
        electricCarsRefueled++;
    }

    public int getElectricCarsRefueled() {
        return electricCarsRefueled;
    }
}
