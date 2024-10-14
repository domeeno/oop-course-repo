package oop.practice;

import java.util.List;

public class Classification {

    public static int getClassification(Character individuals) {
        BooleanState isHumanoid = individuals.getIsHumanoid();
        String planet = individuals.getPlanet();
        int age = individuals.getAge();
        List<String> traits = individuals.getTraits();

        // Star Wars Universe Classification
        if (isHumanoid == BooleanState.FALSE) {
            if ("Kashyyyk".equalsIgnoreCase(planet) && ageInRange(age, 0, 400) && containsTraits(traits, "HAIRY", "TALL")) {
                return 1; // Wookie
            } else if ("Endor".equalsIgnoreCase(planet) && ageInRange(age, 0, 60) && containsTraits(traits, "SHORT", "HAIRY")) {
                return 1; // Ewok
            }
        }

        // Marvel Universe Classification
        if (isHumanoid == BooleanState.TRUE) {
            if ("Asgard".equalsIgnoreCase(planet) && ageInRange(age, 0, 5000) && containsTraits(traits, "BLONDE", "TALL")) {
                return 3; // Asgardian
            }
        }

        // Hitchhiker's Guide to the Galaxy Universe Classification
        if (isHumanoid == BooleanState.TRUE) {
            if ("Betelgeuse".equalsIgnoreCase(planet) && ageInRange(age, 0, 100) && containsTraits(traits, "EXTRA_ARMS", "EXTRA_HEAD")) {
                return 2; // Betelgeusian
            }
        }
        if (isHumanoid == BooleanState.FALSE) {
            if ("Vogsphere".equalsIgnoreCase(planet) && ageInRange(age, 0, 200) && containsTraits(traits, "GREEN", "BULKY")) {
                return 2; // Vogon
            }
        }

        // Lord of the Rings Universe Classification
        if (isHumanoid == BooleanState.TRUE) {
            if ("Earth".equalsIgnoreCase(planet) && containsTraits(traits, "BLONDE", "POINTY_EARS")) {
                return 4; // Elf
            } else if ("Earth".equalsIgnoreCase(planet) && ageInRange(age, 0, 200) && containsTraits(traits, "SHORT", "BULKY")) {
                return 4; // Dwarf
            }
        }

        // Default case for unidentified characters
        return -1; // Unclassified or unknown
    }

    // Utility method to check if the age falls within a certain range
    private static boolean ageInRange(int age, int min, int max) {
        return age >= min && age <= max;
    }

    // Utility method to check if the traits list contains all specified traits
    private static boolean containsTraits(List<String> traits, String... requiredTraits) {
        if (traits == null) {
            return false;
        }
        for (String trait : requiredTraits) {
            if (!traits.contains(trait)) {
                return false;
            }
        }
        return true;
    }
}
