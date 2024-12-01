package oop.practice;

// Semaphore Class
public class Semaphore {
    private CarStation carStation;

    public Semaphore(CarStation carStation) {
        this.carStation = carStation;
    }

    public void assignCarToStation(Car car) {
        carStation.addCar(car);
    }
}
