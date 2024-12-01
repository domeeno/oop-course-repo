package oop.practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarStationTest {

    @Test
    void testAssignCarToStation() {

        CarStation gasStation = new CarStation(new SimpleQueue<>(), new PeopleDinner(), new GasStation());
        CarStation electricStation = new CarStation(new SimpleQueue<>(), new RobotDinner(), new ElectricStation());

        Car gasCar = new Car("1", FuelType.GAS);
        Car electricCar = new Car("2", FuelType.ELECTRIC);

        gasStation.addCar(gasCar);
        electricStation.addCar(electricCar);

        assertEquals(FuelType.GAS, gasCar.getFuelType(), "Gas car should be assigned to Gas Station");

        assertEquals(FuelType.ELECTRIC, electricCar.getFuelType(), "Electric car should be assigned to Electric Station");
    }

    @Test
    void testServingCars() {

        CarStation gasStation = new CarStation(new SimpleQueue<>(), new PeopleDinner(), new GasStation());
        CarStation electricStation = new CarStation(new SimpleQueue<>(), new RobotDinner(), new ElectricStation());
        Semaphore semaphore = new Semaphore(gasStation, electricStation);

        Car gasCar = new Car("1", FuelType.GAS);
        Car electricCar = new Car("2", FuelType.ELECTRIC);

        semaphore.assignCarToStation(gasCar);
        semaphore.assignCarToStation(electricCar);

        assertEquals(1, gasStation.getQueueSize(), "Gas station should have 1 car in the queue");
        assertEquals(1, electricStation.getQueueSize(), "Electric station should have 1 car in the queue");

        gasStation.serveCars();
        electricStation.serveCars();

        assertEquals(0, gasStation.getQueueSize(), "Gas station queue should be empty after serving");
        assertEquals(0, electricStation.getQueueSize(), "Electric station queue should be empty after serving");
    }
}
