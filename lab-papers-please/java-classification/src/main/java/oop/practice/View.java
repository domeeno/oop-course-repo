package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class View {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void showStarWars(String pathname) throws IOException {
        File inputFile = new File(pathname);
        JsonNode data = mapper.readTree(inputFile).get("individuals");
        System.out.println("--------- Star Wars ---------");
        for(JsonNode entry : data){

            FilePrint.printEntry(entry);

        }
        System.out.println("-----------------------------");
    }
    public static void showHitchhiker(String pathname) throws IOException{
        File inputFile = new File(pathname);
        JsonNode data = mapper.readTree(inputFile).get("individuals");
        System.out.println("--------- Hitchhiker ---------");
        for(JsonNode entry : data){

            FilePrint.printEntry(entry);

        }
        System.out.println("------------------------------");
    }
    public static void showMarvel(String pathname) throws IOException{
        File inputFile = new File(pathname);
        JsonNode data = mapper.readTree(inputFile).get("individuals");
        System.out.println("----------- Marvel -----------");
        for(JsonNode entry : data){

            FilePrint.printEntry(entry);

        }
        System.out.println("------------------------------");
    }
    public static void showRings(String pathname) throws IOException{
        File inputFile = new File(pathname);
        JsonNode data = mapper.readTree(inputFile).get("individuals");
        System.out.println("----- Lord of the Rings ------");
        for(JsonNode entry : data){

            FilePrint.printEntry(entry);

        }
        System.out.println("------------------------------");
    }
}