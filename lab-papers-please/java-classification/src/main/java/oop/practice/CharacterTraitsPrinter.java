package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CharacterTraitsPrinter {

    public void printCharacterTraits(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File(filePath);
        JsonNode data = mapper.readTree(inputFile).get("data");

        if (data.isArray()) {
            for (JsonNode character : data) {
                int id = character.get("id").asInt();
                System.out.print("Character ID: " + id + " - Traits: ");

                JsonNode traitsNode = character.get("traits");//gest the traits from the character
                if (traitsNode != null && traitsNode.isArray()) {
                    for (JsonNode trait : traitsNode) {
                        System.out.print(trait.asText() + " ");
                    }
                } else {
                    System.out.print("No traits available");
                }

                System.out.println();
            }
        } else {
            System.out.println("No character data found in the input file.");
        }
    }
}
