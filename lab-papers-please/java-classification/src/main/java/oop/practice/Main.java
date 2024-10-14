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

//    System.out.println("All Characters: ");
//    for (Character obj: charactersList){
//
//      System.out.println(obj.toString());
//    }
//
//    System.out.println("\nCharacters with odd id: ");
//    for (Character obj: charactersList){
//      if(obj.getId() % 2 != 0){
//        System.out.println(obj.toString());
//      }
//    }
//    System.out.println("\nCharacters with specified age: ");
//    for (Character obj: charactersList){
//      if (obj.getAge() > 0) {
//        System.out.println(obj.toString());
//      } else {
//        System.out.println("\nCharacter with unknown age (age = 0): " + obj.toString());
//      }
//    }
    Scanner scanner = new Scanner(System.in);

    for(JsonNode entry : data){

      FilePrint.printEntry(entry);

    }

    for (Character individuals : charactersList) {

      JsonNode entry = mapper.valueToTree(individuals);
      switch (Classification.getClassification(individuals)) {
        case 1:
          starWars.individuals().add(entry);
          break;
        case 2:
          hitchhikers.individuals().add(entry);
          break;
        case 3:
          marvel.individuals().add(entry);
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
  }
}

record Universe(
    String name,
    List<JsonNode> individuals
) { }
