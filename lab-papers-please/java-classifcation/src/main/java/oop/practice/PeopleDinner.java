package oop.practice;

// People Dinner Class
public class PeopleDinner implements Dineable {
    private int peopleServed = 0;
    private Queue<Car> queue;

    public PeopleDinner(Queue<Car> queue) {
        this.queue = queue;
    }

    @Override
    public void serveDinner(int carId) {
        Car car = getCarByIdFromQueue(carId);

        if (car == null) {
            System.out.println("Car with ID " + carId + " not found.");
            return;
        }

        if (!car.isDining() || car.getPassengers() != PassengerType.PEOPLE) {
            System.out.println("People in car " + carId + " don't want to eat.");
        } else {
            System.out.println("Serving dinner to people in car " + carId + ".");
            peopleServed++;
        }
    }

    private Car getCarByIdFromQueue(int carId) {
        for (Car car : queue.getQueueList()) {
            if (car.getId() == carId) {
                return car;
            }
        }
        return null;
    }

    public int getPeopleServed() {
        return peopleServed;
    }
}
