package oop.practice;

import java.util.List;

public class People {
    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private List<String> traits;

    // Constructor
    public People(int id, boolean isHumanoid, String planet, int age, List<String> traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHumanoid() {
        return isHumanoid;
    }

    public void setHumanoid(boolean humanoid) {
        isHumanoid = humanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getTraits() {
        return traits;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
    }

    // Method to describe the person
    @Override
    public String toString() {
        return "ID: " + id + "\n" +
               "Humanoid: " + isHumanoid + "\n" +
               "Planet: " + planet + "\n" +
               "Age: " + age + "\n" +
               "Traits: " + String.join(", ", traits);
    }
}
