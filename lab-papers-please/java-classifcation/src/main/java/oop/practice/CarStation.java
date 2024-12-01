package oop.practice;

import java.util.List;

// Car Station Class
public class CarStation {
    private Queue<Car> queue;
    private Refuelable refuelable;

    public CarStation(Queue<Car> queue, Refuelable refuelable) {
        this.queue = queue;
        this.refuelable = refuelable;
    }

    public void serveCars(Dineable dineable) {
        List<Car> sortedQueue = queue.getQueueList();
        sortedQueue.sort((car1, car2) -> Integer.compare(car1.getId(), car2.getId()));

        System.out.println("Queue before serving:");
        for (Car car : sortedQueue) {
            System.out.println("Car ID: " + car.getId());
        }

        for (Car car : sortedQueue) {
            System.out.println("Serving car " + car.getId());
            dineable.serveDinner(car.getId());
            refuelable.refuel(car.getId());
        }
    }

    public void addCar(Car car) {
        queue.enqueue(car);
    }

    public List<Car> getQueueList() {
        return queue.getQueueList();
    }

    public int getQueueSize() {
        return queue.size();
    }
}
