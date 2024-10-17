package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("src/main/resources/test-input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");

        Universe starWars = new Universe("starWars", new ArrayList<>());
        Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
        Universe marvel = new Universe("marvel", new ArrayList<>());
        Universe rings = new Universe("rings", new ArrayList<>());

        Scanner scanner = new Scanner(System.in);

        for (JsonNode entry : data) {
            // Extract data from the JSON and map it to a People object
            People person = new People(
                    entry.get("id").asInt(),
                    entry.has("isHumanoid") && entry.get("isHumanoid").asBoolean(),
                    entry.has("planet") ? entry.get("planet").asText() : "Unknown",
                    entry.has("age") ? entry.get("age").asInt() : 0,
                    entry.has("traits") ? new ArrayList<>() : new ArrayList<>()
            );

            // Extract the traits if they exist
            if (entry.has("traits")) {
                for (JsonNode trait : entry.get("traits")) {
                    person.getTraits().add(trait.asText());
                }
            }

            // Display the person details
            System.out.println(person);
            System.out.println("Choose a category:");
            System.out.println("1. Star Wars");
            System.out.println("2. Hitchhikers");
            System.out.println("3. Marvel");
            System.out.println("4. Rings");
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    starWars.individuals().add(person);
                    break;
                case "2":
                    hitchhikers.individuals().add(person);
                    break;
                case "3":
                    marvel.individuals().add(person);
                    break;
                case "4":
                    rings.individuals().add(person);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

        scanner.close();

        // Save the categorized data to different JSON files
        mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
        mapper.writeValue(new File("src/main/resources/output/hitchhiker.json"), hitchhikers);
        mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);
        mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);
    }
}

record Universe(
        String name,
        List<People> individuals
) { }
