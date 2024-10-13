package oop.practice;

import java.util.ArrayList;

public class Individual {
    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private ArrayList<String> traits;


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

    public ArrayList<String> getTraits() {
        return traits;
    }

    public void setTraits(ArrayList<String> traits) {
        this.traits = traits;
    }
}
