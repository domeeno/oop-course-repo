package com.yourproject.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yourproject.model.Individual;
import java.util.List;

public class View {

    private ObjectMapper objectMapper;

    // Constructor
    public View() {
        this.objectMapper = new ObjectMapper();
    }

    // Method to print list of Individuals as JSON
    public void printIndividualsAsJson(List<Individual> individuals) {
        try {
            String json = objectMapper.writeValueAsString(individuals);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
