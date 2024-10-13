package oop.practice;

import java.util.List;

public class Classification {

    public static int getClassification(Character individuals) {
        BooleanState isHumanoid = individuals.getIsHumanoid();
        String planet = individuals.getPlanet();
        int age = individuals.getAge();
        List<String> traits = individuals.getTraits();

        // Print out the current values for debugging
        System.out.println(" ID:" + individuals.getId() + "\n{" +
                "\nisHumanoid=" + isHumanoid +
                "\nplanet='" + planet + '\'' +
                "\nage=" + age +
                "\ntraits=" + traits);



        // Default classification value
        int classification = -1;

        // Handle Star Wars Classification
        if (isHumanoid == null || isHumanoid == BooleanState.FALSE) {
            if ("Kashyyyk".equalsIgnoreCase(planet) && age > 0 && traits != null && traits.contains("HAIRY")) {
                return 1; // Wookie
            } else if ("Endor".equalsIgnoreCase(planet) && age > 0 && traits != null && traits.contains("HAIRY")) {
                return 1; // Ewok
            }
        } else if (isHumanoid != null && isHumanoid == BooleanState.TRUE) {
            if ("Asgard".equalsIgnoreCase(planet) && age > 0 && traits != null && traits.contains("BLONDE")) {
                return 2; // Asgardian
            } else if ("Betelgeuse".equalsIgnoreCase(planet) && age > 0 && traits != null &&
                    (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD"))) {
                return 3; // Betelgeusian
            } else if ("Earth".equalsIgnoreCase(planet)) {
                if (traits != null) {
                    if (traits.contains("BLONDE") && traits.contains("POINTY_EARS")) {
                        return 4; // Elf
                    } else if (traits.contains("SHORT") && traits.contains("BULKY")) {
                        return 4; // Dwarf
                    }
                }
            }
        }

        // Handle cases with missing planets
        if (planet == null || "UNKNOWN".equalsIgnoreCase(planet)) {
            if (isHumanoid == null || isHumanoid == BooleanState.FALSE) {
                if (age > 0 && traits != null && traits.contains("BULKY")) {
                    return 3; // Likely a Vogon
                }
            } else if (isHumanoid != null && isHumanoid == BooleanState.TRUE) {
                if (traits != null && (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD"))) {
                    return 3; // Likely a Betelgeusian
                }
            }
        }

        // If no specific classification fits, check for general traits
        if (traits != null) {
            if (traits.contains("GREEN") && (isHumanoid == null || isHumanoid == BooleanState.FALSE)) {
                return 3; // Vogons
            } else if (traits.contains("HAIRY") && age > 0) {
                return 1; // General classification for hairy beings
            }
        }

        // Default to the closest classification if none are met
        if (isHumanoid != null) {
            if (isHumanoid == BooleanState.TRUE) {
                return 2; // Default to Asgardian for humanoids if nothing else matches
            } else {
                return 3; // Default to Vogon for non-humanoids if nothing else matches
            }
        }

        // If still no classification, return 4 (as a catch-all for unspecified)
        return -1; // Unspecified fallback
    }
}