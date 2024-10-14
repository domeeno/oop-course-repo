package oop.practice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {

    // TODO read/write logic should be separated into a separate class
    // use File class to handle input path
    File inputFile = new File("src/main/resources/test-input.json");
    // create an instance of ObjectMapper and configure it to accept case-insensitive enums
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true); // accept case-insensitive enums enabled for planet enum ex. Asgard -> Planet.ASGARD
    // read the input file and map it to the IndividualsInput record class
    IndividualsInput input = mapper.readValue(inputFile, IndividualsInput.class);

    // TODO avoid duplication
    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    // Instantiate a scanner class to read input from the console
    Scanner scanner = new Scanner(System.in);

    // TODO give each input to a classifier class to process the entry
    // ex: classifier.classify(entry) or classifier.classify(input.data()) depending on the implementation of choice
    for (Individual entry : input.data()) {
      String entryAsString = entry.toString();
      System.out.println(entryAsString);

      switch (execute(scanner)) {
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

    // close the scanner to avoid memory leaks
    scanner.close();

    // TODO remove duplication and separate read/write logic into a separate class
    mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
    mapper.writeValue(new File("src/main/resources/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);
    mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);
  }

  // TODO give proper name
  private static String execute(Scanner scanner) {
    return scanner.nextLine();
  }
}

// TODO extract to separate files
record Universe(
    String name,
    List<Individual> individuals
) {
}

record IndividualsInput(
    @JsonProperty("data") List<Individual> data
) {
}

record Individual (
  @JsonProperty("name") String name,
  @JsonProperty("planet") Planet planet,
  @JsonProperty("traits") List<String> traits,
  @JsonProperty("isHumanoid") Boolean isHumanoid,
  @JsonProperty("id") Integer id,
  @JsonProperty("age") Integer age
) {}

enum Planet {
  EARTH,
  ASGARD,
  ENDOR,
  KASHYYYK,
  BETELGEUSE,
  VOGSPHERE
}