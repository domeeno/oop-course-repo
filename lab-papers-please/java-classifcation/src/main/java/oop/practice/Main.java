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
    File inputFile = new File("src/main/resources/input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());


    //FileManager.readAndPrint();
    List<Individual> individualsList = mapper.readValue(data.toString(), new TypeReference<>() {
    });
    //Print all the data
//    System.out.println("All Individuals: ");
//    for (Individual obj: individualsList){
//
//      System.out.println(obj.toString());
//    }
//
//    System.out.println("\nIndividuals with even id: ");
//    //Print only the objects with even ids
//    for (Individual obj: individualsList){
//      if(obj.getId() % 2 == 0){
//        System.out.println(obj.toString());
//      }
//    }
//    System.out.println("\nIndividuals with known planets: ");
//    //Print only the objects with even ids
//    for (Individual obj: individualsList){
//      if(!obj.getPlanet().equals("UNKNOWN")){
//        System.out.println(obj.toString());
//      }
//    }


    for (Individual individual : individualsList) {
      JsonNode jsonNode = mapper.valueToTree(individual);
      switch (Classification.getClassification(individual)) {
        case 1:

          starWars.individuals().add(jsonNode);
          break;
        case 2:
          marvel.individuals().add(jsonNode);
          break;
        case 3:
          hitchhikers.individuals().add(jsonNode);
          break;
        case 4:
          rings.individuals().add(jsonNode);
          break;
        default:
          System.out.println("Something went wrong for id: " + individual.getId());
      }
    }


    mapper.writeValue(new File("C:/Users/catal/OneDrive/Desktop/UNI/OOP/Lab1_oop_papers_please/lab-papers-please/output/starwars.json"), starWars);
    mapper.writeValue(new File("C:/Users/catal/OneDrive/Desktop/UNI/OOP/Lab1_oop_papers_please/lab-papers-please/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("C:/Users/catal/OneDrive/Desktop/UNI/OOP/Lab1_oop_papers_please/lab-papers-please/output/rings.json"), rings);
    mapper.writeValue(new File("C:/Users/catal/OneDrive/Desktop/UNI/OOP/Lab1_oop_papers_please/lab-papers-please/output/marvel.json"), marvel);

    System.out.println("\n");
    ViewOutput.showStarWars();
    System.out.println("\n");
    ViewOutput.showHitchhiker();
    System.out.println("\n");
    ViewOutput.showMarvel();
    System.out.println("\n");
    ViewOutput.showRings();
  }
}

record Universe(
    String name,
    List<JsonNode> individuals
) { }
