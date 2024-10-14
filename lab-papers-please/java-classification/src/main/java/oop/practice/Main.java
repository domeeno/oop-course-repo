package oop.practice;

import com.fasterxml.jackson.core.type.TypeReference;
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
    File inputFile = new File("./lab-papers-please/java-classification/src/main/resources/input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    List<Character> charactersList = mapper.readValue(data.toString(), new TypeReference<List<Character>>() {});

    Scanner scanner = new Scanner(System.in);

//    for(JsonNode entry : data){
//
//      FilePrint.printEntry(entry);
//
//    }

    for (Character individuals : charactersList) {

      JsonNode entry = mapper.valueToTree(individuals);
      switch (Classification.getClassification(individuals)) {
        case 1:
          starWars.individuals().add(entry);
          break;
        case 2:
          marvel.individuals().add(entry);
          break;
        case 3:
          hitchhikers.individuals().add(entry);
          break;
        case 4:
          rings.individuals().add(entry);
          break;
        default:
          System.out.println("Something went wrong for id: " + individuals.getId());      }
    }

    scanner.close();
    mapper.writeValue(new File("./lab-papers-please/output/starwars.json"), starWars);
    mapper.writeValue(new File("./lab-papers-please/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("./lab-papers-please/output/rings.json"), rings);
    mapper.writeValue(new File("./lab-papers-please/output/marvel.json"), marvel);


    System.out.println("\n");
    View.showStarWars();

    System.out.println("\n");
    View.showHitchhiker();

    System.out.println("\n");
    View.showMarvel();

    System.out.println("\n");
    View.showRings();
  }
}

record Universe(
    String name,
    List<JsonNode> individuals
) { }
