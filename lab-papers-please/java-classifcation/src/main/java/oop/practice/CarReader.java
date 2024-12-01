package oop.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CarReader {

    public List<Car> readCarsFromJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Car> cars = null;

        try {
            cars = objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, Car.class));
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }

        return cars;
    }
}

