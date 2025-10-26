package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("src/main/resources/input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");

        // Create Universes
        Universe starWars = new Universe("starwars", new ArrayList<>());
        Universe hitchhikers = new Universe("hitchhikers", new ArrayList<>());
        Universe marvel = new Universe("marvel", new ArrayList<>());
        Universe rings = new Universe("rings", new ArrayList<>());

        // Classify aliens
        new Category(data, starWars, hitchhikers, marvel, rings);

        // Write the classified data back to JSON files
        mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
        mapper.writeValue(new File("src/main/resources/output/hitchhikers.json"), hitchhikers);
        mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);
        mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);
    }
}

// Category class to hold the classification logic
class Category {
    public Category(JsonNode data, Universe starWars, Universe hitchhikers, Universe marvel, Universe rings) {
        for (JsonNode entry : data) {
            boolean isHumanoid = entry.has("isHumanoid") && !entry.get("isHumanoid").isNull() && entry.get("isHumanoid").asBoolean();
            String planet = entry.has("planet") && !entry.get("planet").isNull() ? entry.get("planet").asText() : "unknown";
            int age = entry.has("age") && !entry.get("age").isNull() ? entry.get("age").asInt() : -1;

            List<String> traits = new ArrayList<>();
            if (entry.has("traits") && !entry.get("traits").isNull()) {
                entry.get("traits").forEach(traitNode -> traits.add(traitNode.asText()));
            }

            // Classification rules
            if (!isHumanoid && planet.equals("Kashyyyk") && age >= 0 && age <= 400 && traits.contains("HAIRY") && traits.contains("TALL")) {
                starWars.individuals().add(entry);
            } else if (!isHumanoid && planet.equals("Endor") && age >= 0 && age <= 60 && traits.contains("HAIRY") && traits.contains("SHORT")) {
                starWars.individuals().add(entry);
            } else if (isHumanoid && planet.equals("Asgard") && age >= 0 && age <= 5000 && traits.contains("BLONDE") && traits.contains("TALL")) {
                marvel.individuals().add(entry);
            } else if (isHumanoid && planet.equals("Betelgeuse") && age >= 0 && age <= 100 && traits.contains("EXTRA_ARMS") && traits.contains("EXTRA_HEAD")) {
                hitchhikers.individuals().add(entry);
            } else if (!isHumanoid && planet.equals("Vogsphere") && age >= 0 && age <= 200 && traits.contains("GREEN") && traits.contains("BULKY")) {
                hitchhikers.individuals().add(entry);
            } else if (isHumanoid && planet.equals("Earth") && traits.contains("BLONDE") && traits.contains("POINTY_EARS")) {
                rings.individuals().add(entry);
            } else if (isHumanoid && planet.equals("Earth") && age >= 0 && age <= 200 && traits.contains("SHORT") && traits.contains("BULKY")) {
                rings.individuals().add(entry);
            } else {
                System.out.println("Unknown classification for entry: " + entry.toPrettyString());
            }
        }
    }
}

// Universe class to hold classified aliens
record Universe(String name, List<JsonNode> individuals) {
    public Universe(String name, List<JsonNode> individuals) {
        this.name = name;
        this.individuals = individuals;
    }
}
