package com.yourproject.controller;

import com.yourproject.model.Individual;
import com.yourproject.view.View;
import java.util.ArrayList;
import java.util.List;

public class ClassificationController {

    private View view;

    public ClassificationController(View view) {
        this.view = view;
    }

    // Method to classify individuals based on their universe
    public List<Individual> classifyIndividuals() {
        List<Individual> individuals = new ArrayList<>();

        // Adding data for Hitchhikers
        individuals.add(new Individual(2, false, "Kashyyyk", 128, List.of("GREEN")));
        individuals.add(new Individual(4, false, "Endor", 26, List.of("EXTRA_ARMS")));
        individuals.add(new Individual(5, false, "Unknown", 0, List.of("BULKY")));

        // Adding data for Marvel
        // Currently empty, but you can add more if needed
        individuals.add(new Individual(0, true, "Asgard", 2034, List.of("BLONDE", "TALL")));

        // Adding data for Star Wars (Rings universe)
        individuals.add(new Individual(1, false, "Endor", 22, List.of()));

        // Adding data for Rings
        individuals.add(new Individual(3, true, "Earth", 200, List.of("SHORT", "BULKY")));

        // Add more classification logic here if needed

        return individuals;
    }

    // Method to start the classification and print results
    public void startClassification() {
        List<Individual> classifiedIndividuals = classifyIndividuals();
        view.printIndividualsAsJson(classifiedIndividuals);
    }
}
