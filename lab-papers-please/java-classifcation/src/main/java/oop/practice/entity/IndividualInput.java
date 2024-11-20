package oop.practice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record IndividualInput(
    @JsonProperty("data") List<Individual> data
) {
}
