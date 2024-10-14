package oop.practice;

import java.util.List;

public class Classifier {
    public static void clasiffyIndividuals(Individual individual, List<Universe> universes) {
        if (isWookie(individual)) {
            universes.get(0).addIndividual(individual);
        } else if (isEwok(individual)) {
            universes.get(0).addIndividual(individual);
        } else if (isAsgardian(individual)) {
            universes.get(1).addIndividual(individual);
        } else if (isBetelgeusian(individual)) {
            universes.get(2).addIndividual(individual);
        } else if (isVogon(individual)) {
            universes.get(2).addIndividual(individual);
        } else if (isElf(individual)) {
            universes.get(3).addIndividual(individual);
        } else if (isDwarf(individual)) {
            universes.get(3).addIndividual(individual);
        } else  {
            System.out.println("Individual could not be classified: " + individual.getName());
        }
    }

    private static boolean isWookie(Individual individual) {
        return  (individual.getPlanet() == null || "Kashyyyk".equals(individual.getPlanet())) &&
                (individual.getTraits() == null || (individual.getTraits().contains("HAIRY") && individual.getTraits().contains("TALL"))) &&
                (individual.getAge() == null || individual.getAge() <= 400) &&
                !individual.isHumanoid();
    }

    private static boolean isEwok(Individual individual) {
        return (individual.getPlanet() == null || "Endor".equals(individual.getPlanet())) &&
                (individual.getTraits() == null || (individual.getTraits().contains("SHORT") && individual.getTraits().contains("HAIRY"))) &&
                (individual.getAge() == null || individual.getAge() <= 60) &&
                !individual.isHumanoid();
    }

    private static boolean isAsgardian(Individual individual) {
        return (individual.getPlanet() == null || "Asgard".equals(individual.getPlanet())) &&
                (individual.getTraits() == null || (individual.getTraits().contains("BLONDE") && individual.getTraits().contains("TALL"))) &&
                (individual.getAge() == null || individual.getAge() <= 5000) &&
                individual.isHumanoid();
    }

    private static boolean isBetelgeusian(Individual individual) {
        return (individual.getPlanet() == null || "Betelgeuse".equals(individual.getPlanet())) &&
                (individual.getTraits() == null || (individual.getTraits().contains("EXTRA_ARMS") && individual.getTraits().contains("EXTRA_HEAD"))) &&
                (individual.getAge() == null || individual.getAge() <= 100) &&
                individual.isHumanoid();
    }

    private static boolean isVogon(Individual individual) {
        return (individual.getPlanet() == null || "Vogsphere".equals(individual.getPlanet())) &&
                (individual.getTraits() == null || (individual.getTraits().contains("GREEN") && individual.getTraits().contains("BULKY"))) &&
                (individual.getAge() == null || individual.getAge() <= 200) &&
                !individual.isHumanoid();
    }

    private static boolean isElf(Individual individual) {
        return (individual.getPlanet() == null || "Earth".equals(individual.getPlanet())) &&
                (individual.getTraits() == null || (individual.getTraits().contains("BLONDE") && individual.getTraits().contains("POINTY_EARS"))) &&
                individual.isHumanoid();
    }

    private static boolean isDwarf(Individual individual) {
        return (individual.getPlanet() == null || "Earth".equals(individual.getPlanet())) &&
                (individual.getTraits() == null || (individual.getTraits().contains("SHORT") && individual.getTraits().contains("BULKY"))) &&
                (individual.getAge() == null || individual.getAge() <= 200) &&
                individual.isHumanoid();
    }
}
