package oop.practice;
import java.util.List;

public class Individual {
    private String name;
    private boolean isHumanoid;
    private String planet;
    private Integer age;
    private List<String> traits;

    public Individual(String name, boolean isHumanoid, String planet, int age, List<String> traits){
        this.name = name;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    public String getName() {
        return name;
    }

    public boolean isHumanoid() {
        return isHumanoid;
    }

    public String getPlanet(){
        return planet;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getTraits() {
        return traits;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "isHumanoid: " + isHumanoid + "\n" +
                "Planet: " + planet + "\n" +
                "Age: " + age + "\n" +
                "Traits: " + traits;
    }
}
