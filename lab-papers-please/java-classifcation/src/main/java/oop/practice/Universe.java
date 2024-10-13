package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public record Universe(String name, List<Creature> individuals) {
    public List<Creature> getIndividuals() {
        return individuals;
    }
}
