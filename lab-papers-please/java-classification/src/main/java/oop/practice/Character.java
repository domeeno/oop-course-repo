package oop.practice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.util.List;

enum BooleanState {
    TRUE, FALSE, UNKNOWN
}

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Character {

    @JsonProperty("id")
    private int id;

    @JsonProperty("isHumanoid")
    @JsonDeserialize(using = BooleanStateDeserializer.class)
    private BooleanState isHumanoid = BooleanState.UNKNOWN;

    @JsonProperty("planet")
    private String planet = "UNKNOWN";

    @JsonProperty("age")
    private int age;

    @JsonProperty("traits")
    private List<String> traits;

    public Character(int id, boolean isHumanoid, String planet, int age, List<String> traits) {
        this.id = id;
        if(isHumanoid){
            this.isHumanoid = BooleanState.TRUE;
        } else if (isHumanoid) {
            this.isHumanoid = BooleanState.FALSE;
        }        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    public Character() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BooleanState getIsHumanoid() {
        return isHumanoid;
    }

    public void setIsHumanoid(BooleanState isHumanoid) {
        this.isHumanoid = isHumanoid;
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

    @Override
    public String toString() {
        return "\nIndividual" +
                " ID:" + id + "\n{" +
                "\nisHumanoid=" + isHumanoid +
                "\nplanet='" + planet + '\'' +
                "\nage=" + age +
                "\ntraits=" + (traits == null ? "UNKNOWN" : traits) +
                "\n}";
    }
}

class BooleanStateDeserializer extends JsonDeserializer<BooleanState> {
    @Override
    public BooleanState deserialize(JsonParser p, DeserializationContext context)
            throws IOException, JsonProcessingException {
        Boolean value = p.getBooleanValue();
        return value != null ? (value ? BooleanState.TRUE : BooleanState.FALSE) : BooleanState.UNKNOWN;
    }
}
