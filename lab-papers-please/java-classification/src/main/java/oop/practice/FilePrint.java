package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FilePrint {
    public static void readAndPrint() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("src/main/resources/input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");
        for(JsonNode entry : data){
            printEntry(entry);
        }

    }
    static void printEntry(JsonNode entry) {
        int id = entry.has("id") ? entry.get("id").asInt() : -1;

        String planet = entry.has("planet") ? entry.get("planet").asText() : "no data";

        BooleanState isHumanoid = BooleanState.UNKNOWN;

        int age = entry.has("age") ? entry.get("age").asInt() : -1;

        JsonNode traits = entry.has("traits") ? entry.get("traits") : null;
        System.out.println("\n");
        System.out.println("ID: " + id);
        System.out.println("Is Humanoid: " + entry.get("isHumanoid").asText());
        System.out.println("Planet: " + planet);
        System.out.println("Age: " + (age > 0 ? age : "UNKNOWN"));
        System.out.println("Traits: " + (traits != null ? traits : "UNKNOWN"));
        System.out.println("\n");
    }
}


