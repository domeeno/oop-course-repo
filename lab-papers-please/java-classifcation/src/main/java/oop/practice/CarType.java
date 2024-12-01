package oop.practice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CarType {
    ELECTRIC, GAS;

    @JsonCreator
    public static CarType fromString(String value) {
        for (CarType carType : CarType.values()) {
            if (carType.name().equalsIgnoreCase(value)) {
                return carType;
            }
        }
        throw new IllegalArgumentException("Unknown car type: " + value);
    }

    @JsonValue
    public String toJson() {
        return name().toLowerCase();
    }
}
