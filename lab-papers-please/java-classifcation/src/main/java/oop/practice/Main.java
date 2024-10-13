package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void classifyCreature(Creature creature, Universe starWars, Universe marvel, Universe hitchhikers, Universe rings){

    //initial score
    int starWarsScore = 0;
    int marvelScore = 0;
    int hitchhikersScore = 0;
    int ringsScore = 0;

    //isHumanoid
    if (creature.isHumanoid() != null) {
      if (creature.isHumanoid()) {
        marvelScore++;
        hitchhikersScore++;
        ringsScore++;
      } else {
        starWarsScore++;
      }
    }

    //planet
    String planet = creature.getPlanet();
    if (planet !=null){
    switch (planet) {
      case "Earth":
        marvelScore++;
        ringsScore++;
        break;

      case "Asgard":
        marvelScore++;
        break;

      case "Betelgeuse":

      case "Vogsphere":
        hitchhikersScore++;
        break;
      case "Kashyyyk":

      case "Endor":
        starWarsScore++;
        break;

      default:
        break;
    }}

    //age range
    Integer age = creature.getAge();
    if (age != null) {
      if (age <= 200) {
        marvelScore++;
        hitchhikersScore++;
        starWarsScore++;
        ringsScore++;
      } else if (age > 200 && age < 500) {
        ringsScore++;
        starWarsScore++;
        marvelScore++;
      } else if (age >= 500 && age < 5000) {
        marvelScore++;
      } else if (age > 5000) {
        ringsScore++;
      }
    }

    //traits
    List<String> traits = creature.getTraits();
    if (traits != null && !traits.isEmpty()) {
    if (traits.contains("HAIRY")) {
      starWarsScore++;
    }
    if (traits.contains("TALL")) {
      marvelScore++;
      starWarsScore++;
    }
    if (traits.contains("SHORT")) {
      hitchhikersScore++;
    }
    if (traits.contains("BLONDE")) {
      marvelScore++;
    }
    if (traits.contains("EXTRA_ARMS")) {
      hitchhikersScore++;
    }
    if (traits.contains("EXTRA_HEAD")) {
      hitchhikersScore++;
    }
    if (traits.contains("GREEN")) {
      starWarsScore++;
      hitchhikersScore++;
    }
    if (traits.contains("BULKY")) {
      starWarsScore++;
    }
    if (traits.contains("POINTY_EARS")) {
      ringsScore++;
    }}


    System.out.println("Creature ID: " + creature.getId());
    System.out.println("Scores - Star Wars: " + starWarsScore + ", Marvel: " + marvelScore +
            ", Hitchhiker's: " + hitchhikersScore + ", Lord of the Rings: " + ringsScore);

    int maxScore = Math.max(Math.max(starWarsScore, marvelScore), Math.max(hitchhikersScore, ringsScore));
    System.out.println("Max Score: " + maxScore);

    if (maxScore == 0) {
      System.out.println("Could not classify creature with ID: " + creature.getId());
      return;
    }


    if (maxScore == starWarsScore) {
      starWars.getIndividuals().add(creature);
    } else if (maxScore == marvelScore) {
      marvel.getIndividuals().add(creature);
    } else if (maxScore == hitchhikersScore) {
      hitchhikers.getIndividuals().add(creature);
    } else if (maxScore == ringsScore) {
      rings.getIndividuals().add(creature);
    }
  }

  public static void main(String[] args) throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    File inputFile = new File("D:/POO Labs/oop-course-repo/lab-papers-please/java-classifcation/src/main/resources/input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");
    Scanner scanner = new Scanner(System.in);

    List<Creature> creatures = new ArrayList<>();
    int maxId = 0;

    // loop through the JSON data and create Creature objects
    for (JsonNode entry : data) {
      int id = entry.get("id").asInt();
      boolean isHumanoid = entry.has("isHumanoid") && entry.get("isHumanoid").asBoolean();
      String planet = entry.has("planet") ? entry.get("planet").asText() : null;
      int age = entry.has("age") ? entry.get("age").asInt() : 0;

      List<String> traits = new ArrayList<>();
      if (entry.has("traits")) {
        for (JsonNode trait : entry.get("traits")) {
          traits.add(trait.asText());
        }
      }

      Creature creature = new Creature(id, isHumanoid, planet, age, traits.isEmpty() ? null : traits);
      creatures.add(creature);

      if (id > maxId) {
        maxId = id;
      }
    }

    String menuChoice = "";
    while (!menuChoice.equals("0")) {

    System.out.println("Menu:");
    System.out.println("1. Display all creatures.");
    System.out.println("2. Add new creature.");
    System.out.println("3. Display creature by id.");
    System.out.println("4. Display creatures with even or odd id");
      System.out.println("5. Classify creature in their own universe");
    System.out.println("0. Exit...");

    System.out.print("Chose a number: ");
    menuChoice = scanner.nextLine();

    switch (menuChoice){
      case "1":
        for (Creature creature : creatures) {
          creature.displayAllCreatureDetails();
        }
        break;

      case "2":
        Creature newCreature = new Creature(0, false, null, 0, new ArrayList<>());
        newCreature.addNewCreature(creatures, maxId, inputFile,mapper);
        maxId++;
        break;

      case "3":
        System.out.print("Enter the ID of the creature you want to display: ");
        int searchId = Integer.parseInt(scanner.nextLine());
        Creature.displayCreatureById(creatures, searchId);
        break;

      case "4":
        System.out.print("Even or odd (e/o)?");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("e")) {
          System.out.println("Displaying creatures with even IDs:");
          for (Creature creature : creatures) {
            if (creature.getId() % 2 == 0) {
              creature.displayAllCreatureDetails();
            }
          }
        } else if (choice.equals("o")) {
          System.out.println("Displaying creatures with odd IDs:");
          for (Creature creature : creatures) {
            if (creature.getId() % 2 != 0) {
              creature.displayAllCreatureDetails();
            }
          }
        } else {
          System.out.println("Invalid choice. Please select 'e' for even or 'o' for odd.");
        }
        break;

      case "5":
        Universe starWars = new Universe("starWars", new ArrayList<>());
        Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
        Universe marvel = new Universe("marvel", new ArrayList<>());
        Universe rings = new Universe("rings", new ArrayList<>());

        for (Creature creature : creatures) {
          classifyCreature(creature, starWars, marvel, hitchhikers, rings);
        }


        File outputDir = new File("src/main/resources/output");
        if (!outputDir.exists()) {
          outputDir.mkdirs();  // Create the directory
        }

        mapper.writeValue(new File("D:/POO Labs/oop-course-repo/lab-papers-please/output/starwars.json"), starWars);
        mapper.writeValue(new File("D:/POO Labs/oop-course-repo/lab-papers-please/output/hitchhiker.json"), hitchhikers);
        mapper.writeValue(new File("D:/POO Labs/oop-course-repo/lab-papers-please/output/rings.json"), rings);
        mapper.writeValue(new File("D:/POO Labs/oop-course-repo/lab-papers-please/output/marvel.json"), marvel);

        break;

      case "0":
        System.out.println("Exiting program.");
        break;

      default:
        System.out.println("Invalid choice. Please select 1, 2, or 3.");
    }
    }

    scanner.close();



  }
};

