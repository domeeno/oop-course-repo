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
    File inputFile = new File("D:/POO Labs/oop-course-repo/lab-papers-please/java-classifcation/src/main/resources/test-input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    List<Creature> creatures = new ArrayList<>();
    int maxId = 0;

    // loop through the json data
    for (JsonNode entry : data) {
      int id = entry.get("id").asInt();
      boolean isHumanoid = entry.has("isHumanoid") && entry.get("isHumanoid").asBoolean();
      String planet = entry.has("planet") ? entry.get("planet").asText() : null;
      int age = entry.has("age") ? entry.get("age").asInt() : 0;

      //if the traits exist we map them otherwise set as null
      List<String> traits = new ArrayList<>();
      if (entry.has("traits")) {
        for (JsonNode trait : entry.get("traits")){
          traits.add(trait.asText());
        }
      }
      Creature creature= new Creature(id, isHumanoid,planet,age,traits);

      creatures.add(creature);

      if (id > maxId) {
        maxId = id;
      }

      creature.displayCreatureDetails();
    }

    Creature newCreature = new Creature(0, false, null, 0, new ArrayList<>());
    newCreature.addNewCreature(creatures, maxId, inputFile,mapper);

    for (Creature creature : creatures) {
      creature.displayCreatureDetails();
    }

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    Scanner scanner = new Scanner(System.in);

    for (JsonNode entry : data) {
      String entryAsString = entry.toString();
      System.out.println(entryAsString);
      String userInput = scanner.nextLine();
      switch (userInput) {
        case "1":
          starWars.individuals().add(entry);
          break;
        case "2":
          hitchhikers.individuals().add(entry);
          break;
        case "3":
          marvel.individuals().add(entry);
          break;
        case "4":
          rings.individuals().add(entry);
          break;
        default:
          System.out.println("Invalid input");
      }
    }

    scanner.close();
    mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
    mapper.writeValue(new File("src/main/resources/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);
    mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);

  }
};
record Universe(
    String name,
    List<JsonNode> individuals
) { }

