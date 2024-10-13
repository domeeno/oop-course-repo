package oop.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Creature {
  private int id;
  private Boolean isHumanoid;
  private String planet;
  private Integer age;
  private List<String> traits;

  // Constructor
  public Creature(int id, boolean isHumanoid, String planet, int age, List<String> traits) {
    this.id = id;
    this.isHumanoid = isHumanoid;
    this.planet = planet;
    this.age = age;
    this.traits = traits;
  }


  public int getId() {
    return id;
  }

  public Boolean isHumanoid() {
    return isHumanoid;
  }

  public String getPlanet() {
    return planet;
  }

  public Integer getAge() {
    return age;
  }

  public List<String> getTraits() {
    return traits;
  }

  public void displayAllCreatureDetails() {
    System.out.println("ID: " + id);
    System.out.println("Is Humanoid: " + isHumanoid);
    System.out.println("Planet: " + (planet != null ? planet : "Unknown"));
    System.out.println("Age: " + age);
    System.out.println("Traits: " + (traits != null ? traits : "None"));
    System.out.println();
  }

  public void addNewCreature(List<Creature> creatures, int currentMaxId, File inputFile, ObjectMapper mapper) throws IOException{
    Scanner scanner = new Scanner(System.in);

      int id = currentMaxId + 1; //assign as the next available id

      System.out.print("Is Humanoid (true/false): ");
      boolean isHumanoid = scanner.nextBoolean();

      System.out.print("Enter Planet (or leave blank for none): ");
      scanner.nextLine();
      String planet = scanner.nextLine();

      System.out.print("Enter Age: ");
      int age = scanner.nextInt();

      scanner.nextLine(); // consume newline

      List<String> traits = new ArrayList<>();
      System.out.print("Enter traits (separate by commas, leave blank if none): ");
      String traitsInput = scanner.nextLine();

      if (!traitsInput.isEmpty()) {
        String[] traitsArray = traitsInput.split(",");
        for (String trait : traitsArray) {
          traits.add(trait.trim());
        }
      }

      Creature newCreature = new Creature(id, isHumanoid, planet.isEmpty() ? null : planet, age, traits.isEmpty() ? null : traits);

      creatures.add(newCreature);

      System.out.println("New Creature Added:");
      newCreature.displayAllCreatureDetails();

      saveCreaturesToJson(creatures, inputFile, mapper);

  }

  public void saveCreaturesToJson(List<Creature> creatures, File inputFile, ObjectMapper mapper) throws IOException {
    ArrayNode updatedData = mapper.createArrayNode();

    for (Creature creature : creatures) {
      ObjectNode creatureNode = mapper.createObjectNode();
      creatureNode.put("id", creature.getId());
      creatureNode.put("isHumanoid", creature.isHumanoid());
      if (creature.getPlanet() != null) {
        creatureNode.put("planet", creature.getPlanet());
      }
      creatureNode.put("age", creature.getAge());

      if (creature.getTraits() != null && !creature.getTraits().isEmpty()) {
        ArrayNode traitsNode = creatureNode.putArray("traits");
        for (String trait : creature.getTraits()) {
          traitsNode.add(trait);
        }
      }

      updatedData.add(creatureNode);
    }

    // Create the root node and add the updated data array
    ObjectNode root = mapper.createObjectNode();
    root.set("data", updatedData);

    // Write the updated JSON to the file
    mapper.writeValue(inputFile, root);
    System.out.println("Modifications saved to " + inputFile.getPath());
  }

  public static void displayCreatureById(List<Creature> creatures, int searchId) {
    for (Creature creature : creatures) {
      if (creature.getId() == searchId) {
        creature.displayAllCreatureDetails();
        return;  // Exit the method once the creature is found
      }
    }
    System.out.println("No creature found with ID: " + searchId);
  }

}
