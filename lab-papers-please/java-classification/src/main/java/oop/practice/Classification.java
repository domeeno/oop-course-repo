package oop.practice;

import java.util.List;

public class Classification {

    public static int getClassification(Character individuals) {
        BooleanState isHumanoid = individuals.getIsHumanoid();
        String planet = individuals.getPlanet();
        int age = individuals.getAge();
        List<String> traits = individuals.getTraits();

        // Handle Star Wars Classification
        if (isHumanoid == null || isHumanoid == BooleanState.FALSE) {
            if (planet != null && planet.equalsIgnoreCase("Kashyyyk") && age > 0 && traits != null && traits.contains("HAIRY")) {
                return 1; // Wookie
            } else if (planet != null && planet.equalsIgnoreCase("Endor") && age > 0 && traits != null && traits.contains("HAIRY")) {
                return 1; // Ewok
            }
        }

        // Handle Marvel Universe
        if (isHumanoid != null && isHumanoid == BooleanState.TRUE) {
            if (planet != null && planet.equalsIgnoreCase("Asgard") && age > 0 && traits != null && traits.contains("BLONDE")) {
                return 2; // Asgardian
            }
        }

        // Handle Hitchhiker's Guide Universe
        if (planet != null && planet.equalsIgnoreCase("Betelgeuse") && age > 0 && traits != null &&
                (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD"))) {
            return 3; // Betelgeusian
        }

        // Handle Lord of the Rings Universe
        if (planet != null && planet.equalsIgnoreCase("Earth")) {
            if (traits != null) {
                if (traits.contains("BLONDE") && traits.contains("POINTY_EARS")) {
                    return 4; // Elf
                } else if (traits.contains("SHORT") && traits.contains("BULKY")) {
                    return 4; // Dwarf
                }
            }
        }

        // Handle unknown planets with traits
        if (planet == null || planet.equalsIgnoreCase("UNKNOWN")) {
            if (isHumanoid == BooleanState.FALSE && age > 0 && traits != null && traits.contains("BULKY")) {
                return 3; // Vogon (likely from Vogsphere)
            }
        }

        // Default classification for certain traits
        if (traits != null) {
            if (traits.contains("GREEN") && (isHumanoid == null || isHumanoid == BooleanState.FALSE)) {
                return 3; // Vogon
            } else if (traits.contains("HAIRY") && age > 0) {
                return 1; // General classification for hairy beings
            }
        }

        // Default to humanoid classification
        if (isHumanoid != null) {
            if (isHumanoid == BooleanState.TRUE) {
                return 2; // Default to Asgardian for humanoids
            } else {
                return 3; // Default to Vogon for non-humanoids
            }
        }

        // If still no classification, return -1 (as a catch-all for unspecified)
        return -1; // Unspecified fallback
    }
}
