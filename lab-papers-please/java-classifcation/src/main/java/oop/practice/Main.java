package oop.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File folder = new File("/Users/viktorianicologlo/Downloads/oop-course-repo3/lab-car-service/queue");
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));

        List<Car> carList = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Car car = objectMapper.readValue(file, Car.class);
                    carList.add(car);
                    System.out.println("Loaded car from file: " + file.getName());
                } catch (Exception e) {
                    System.out.println("Error reading file " + file.getName() + ": " + e.getMessage());
                }
            }

            CarStation carStation = new CarStation(new SimpleQueue(), new GasStation());
            Semaphore semaphore = new Semaphore(carStation);

            carList.sort(Comparator.comparingInt(Car::getId));
            for (Car car : carList) {
                System.out.println("Adding car " + car.getId() + " to the queue.");
                semaphore.assignCarToStation(car);
            }

            Dineable peopleDinner = new PeopleDinner(new SimpleQueue());
            Dineable robotDinner = new RobotDinner(new SimpleQueue());

            carStation.serveCars(peopleDinner);
            carStation.serveCars(robotDinner);
        }
    }
}
