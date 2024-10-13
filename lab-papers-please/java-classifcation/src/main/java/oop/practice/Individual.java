package oop.practice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Individual {
    
    @JsonProperty("id")
    private int id;
    @JsonProperty("isHumanoid")
    private BooleanState isHumanoid = BooleanState.UNKNOWN;
    @JsonProperty("planet")
    private String planet;
    @JsonProperty("age")
    private int age;
    @JsonProperty("traits")
    private ArrayList<String> traits;

    public Individual(){

    }
    public Individual(int id, boolean humanoid, String planet, int age, ArrayList<String> traits) {
        this.id = id;
        if(humanoid){
            this.isHumanoid = BooleanState.TRUE;
        } else if (!humanoid) {
            this.isHumanoid = BooleanState.FALSE;
        }

        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BooleanState getHumanoidStatus() {
        return isHumanoid;
    }

    public void setHumanoid(BooleanState humanoid) {
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

    @Override
    public String toString() {
        return "Individual{" +
                "id=" + id +
                ", isHumanoid=" + isHumanoid +
                ", planet='" + planet + '\'' +
                ", age=" + age +
                ", traits=" + traits +
                '}';
    }
}
