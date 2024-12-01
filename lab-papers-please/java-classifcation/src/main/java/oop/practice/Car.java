package oop.practice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private int id;
    private FuelType fuelType;
    private PassengerType passengers;
    private boolean isDining;
    private double consumption;

    @JsonCreator
    public Car(
            @JsonProperty("id") int id,
            @JsonProperty("type") FuelType fuelType,
            @JsonProperty("passengers") PassengerType passengers,
            @JsonProperty("isDining") boolean isDining,
            @JsonProperty("consumption") double consumption
    ) {
        this.id = id;
        this.fuelType = fuelType;
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    public int getId() {
        return id;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public PassengerType getPassengers() {
        return passengers;
    }

    public boolean isDining() {
        return isDining;
    }

    public double getConsumption() {
        return consumption;
    }
}
