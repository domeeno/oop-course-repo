package oop.practice;
import java.util.List;
import java.util.ArrayList;

public class Universe {
    private String name;
    private List<Individual> individuals;

    public Universe(String name, List<Individual> individuals) {
        this.name = name;
        this.individuals = new ArrayList<>();
    }

    public void addIndividual(Individual individual) {
        individuals.add(individual);
    }

    public String getName(){
        return name;
    }

    public List<Individual> getIndividuals(){
        return individuals;
    }

    @Override
    public String toString() {
        return "Universe{" +
                "name='" + name + '\n' +
                ", individuals=" + individuals +
                '}';
    }
}
