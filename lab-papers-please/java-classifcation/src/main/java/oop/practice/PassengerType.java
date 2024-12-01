package oop.practice;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PassengerType {
    PEOPLE, ROBOTS;

    @JsonCreator
    public static PassengerType fromString(String value) {
        return PassengerType.valueOf(value.toUpperCase());
    }
}
