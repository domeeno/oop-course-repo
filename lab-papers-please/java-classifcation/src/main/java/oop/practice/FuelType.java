package oop.practice;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FuelType {
    ELECTRIC, GAS;

    @JsonCreator
    public static FuelType fromString(String value) {
        return FuelType.valueOf(value.toUpperCase());
    }
}
