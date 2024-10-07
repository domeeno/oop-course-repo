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

    // TODO remove repetitions
    Universe starWars = new Universe("starwars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchhikers", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    for (JsonNode entry : data) {
      String entryAsString = entry.toString();
      System.out.println(entryAsString);
      Scanner scanner = new Scanner(System.in);
      String userInput = scanner.nextLine();
      // TODO handle missinput
      // TODO print the number and its universe
      switch (userInput) {
        case "1":
          starWars.individuals().add(entryAsString);
          break;
        case "2":
          hitchhikers.individuals().add(entryAsString);
          break;
        case "3":
          marvel.individuals().add(entryAsString);
          break;
        case "4":
          rings.individuals().add(entryAsString);
          break;
        default:
          System.out.println("Invalid input");
      }
    }

    mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
    mapper.writeValue(new File("src/main/resources/output/hitchhikers.json"), hitchhikers);
    mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);
    mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);
  }
}

record Universe(
    String name,
    List<String> individuals
) { }
