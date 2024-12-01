package oop.practice;

// Robot Dinner Class
public class RobotDinner implements Dineable {
    private int robotsServed = 0;
    private Queue<Car> queue;

    public RobotDinner(Queue<Car> queue) {
        this.queue = queue;
    }

    @Override
    public void serveDinner(int carId) {
        Car car = getCarByIdFromQueue(carId);

        if (car == null) {
            System.out.println("Car with ID " + carId + " not found.");
            return;
        }

        if (!car.isDining() || car.getPassengers() != PassengerType.ROBOTS) {
            System.out.println("Robots in car " + carId + " don't want to eat.");
        } else {
            System.out.println("Serving dinner to robots in car " + carId + ".");
            robotsServed++;
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

    public int getRobotsServed() {
        return robotsServed;
    }
}
