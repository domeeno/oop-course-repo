package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileManager {
    public static void readAndPrint() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("src/main/resources/test-input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");
        for(JsonNode entry : data){
            printEntry(entry);
        }
//        for(JsonNode entry : data){
//
//            int id;
//            String planet = "no data";
//            BooleanState isHumanoid = BooleanState.UNKNOWN;
//            int age = -1;
//            JsonNode traits = null;
//
//            //System.out.println(entry);
//
//            id = entry.get("id").asInt();
//            if(entry.has("isHumanoid")){
//                isHumanoid = entry.get("isHumanoid").asBoolean() ? BooleanState.TRUE : BooleanState.FALSE;
//            }
//            if(entry.has("planet")) {
//                planet = entry.get("planet").asText();
//            }
//            if(entry.has("age")){
//                age = entry.get("age").asInt();
//            }
//            if(entry.has("traits")){
//                traits = entry.get("traits");
//            }
//
//            System.out.println("ID: " + id);
//            System.out.println("Is Humanoid: " + isHumanoid);
//            System.out.println("Planet: " + planet);
//            if(age > 1){
//                System.out.println("Age: " + age);
//            } else {
//                System.out.println("Age: no data");
//            }
//            if(traits != null){
//                System.out.println("Traits: " + traits);
//            } else {
//                System.out.println("Traits: no data");
//            }

    }
    static void printEntry(JsonNode entry) {
        int id = entry.has("id") ? entry.get("id").asInt() : -1;

        String planet = entry.has("planet") ? entry.get("planet").asText() : "no data";

        BooleanState isHumanoid = BooleanState.UNKNOWN;

        if (entry.has("isHumanoid")) {
            isHumanoid = entry.get("isHumanoid").asBoolean() ? BooleanState.TRUE : BooleanState.FALSE;
        }

        int age = entry.has("age") ? entry.get("age").asInt() : -1;

        JsonNode traits = entry.has("traits") ? entry.get("traits") : null;
        System.out.println("\n");
        System.out.println("ID: " + id);
        System.out.println("Is Humanoid: " + isHumanoid);
        System.out.println("Planet: " + planet);
        System.out.println("Age: " + (age > 0 ? age : "UNKNOWN"));
        System.out.println("Traits: " + (traits != null ? traits : "UNKNOWN"));

    }




}



