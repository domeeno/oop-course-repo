package oop.practice;

import java.util.ArrayList;
import java.util.List;

public class Classification {

//    public static int getClassification(Individual individual){
//
//        String planet = individual.getPlanet();
//        BooleanState isHumanoid = individual.getHumanoidStatus();
//        Integer age = individual.getAge();
//        List<String> traits = individual.getTraits();
//
////        // Star Wars Classification
////        if (planet.equalsIgnoreCase("Kashyyk") && (isHumanoid == null || isHumanoid == BooleanState.FALSE)) {
////            return 1; // Wookie
////        } else if (planet.equalsIgnoreCase("Endor") && (isHumanoid == null || isHumanoid == BooleanState.FALSE)) {
////            return 1;// Ewok
////        }
////
////        // Marvel Classification
////        if (planet.equalsIgnoreCase("Asgard") && (isHumanoid != null && isHumanoid == BooleanState.TRUE)) {
////            return 2; // Asgardian
////        }
////
////        // Hitchhiker's Classification
////        if (planet.equalsIgnoreCase("BETELGEUSE") && (isHumanoid != null && isHumanoid == BooleanState.TRUE)) {
////            return 3; // Betelgeusian
////        } else if (planet.equalsIgnoreCase("Vogsphere") && (isHumanoid == null || isHumanoid == BooleanState.FALSE)) {
////            return 3; // Vogons
////        }
////
////        // Lord of the Rings Classification
////        if (planet.equalsIgnoreCase("Earth")) {
////            if (isHumanoid != null && isHumanoid == BooleanState.TRUE) {
////                if (traits != null && traits.contains("POINTY_EARS")) {
////                    return 4; // Elf
////                } else {
////                    return 4; // Dwarf
////                }
////            }
////        }
//
//        // Generalized Classification
//        // Generalized Classification without Strict Property Dependencies
//        if (isHumanoid != null) {
//            if (isHumanoid == BooleanState.FALSE) {
//                if (planet != null) {
//                    if (planet.equalsIgnoreCase("Kashyyk")) {
//                        // Wookie
//                        if (age >= 0 && age <= 400) {
//                            if (traits != null && traits.contains("HAIRY") && traits.contains("TALL")) {
//                                return 1; // Wookie
//                            }
//                        }
//                    } else if (planet.equalsIgnoreCase("Endor")) {
//                        // Ewok
//                        if (age >= 0 && age <= 60) {
//                            if (traits != null && traits.contains("SHORT") && traits.contains("HAIRY")) {
//                                return 1; // Ewok
//                            }
//                        }
//                    } else if (planet.equalsIgnoreCase("Vogsphere")) {
//                        // Vogons
//                        if (age >= 0 && age <= 200) {
//                            if (traits != null && traits.contains("GREEN") && traits.contains("BULKY")) {
//                                return 3; // Vogons
//                            }
//                        }
//                    }
//                }
//            } else if (isHumanoid == BooleanState.TRUE) {
//                if (planet != null) {
//                    if (planet.equalsIgnoreCase("Asgard")) {
//                        // Asgardian
//                        if (age >= 0 && age <= 5000) {
//                            return 2; // Asgardian
//                        }
//                    } else if (planet.equalsIgnoreCase("BETELGEUSE")) {
//                        // Betelgeusian
//                        if (age >= 0 && age <= 100) {
//                            return 3; // Betelgeusian
//                        }
//                    } else if (planet.equalsIgnoreCase("Earth")) {
//                        // Check for Elves or Dwarves
//                        if (age >= 0) { // Indefinite age handling
//                            if (traits != null) {
//                                if (traits.contains("POINTY_EARS")) {
//                                    return 4; // Elf
//                                } else if (traits.contains("SHORT") && traits.contains("BULKY")) {
//                                    return 4; // Dwarf
//                                }
//                            }
//                        }
//                    }
//                }
//
//                // Additional trait checks for Betelgeusians if no planet is specified
//                if (traits != null && (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD"))) {
//                    return 3; // Betelgeusian
//                }
//            }
//        }
//
//// Fallback classification for unknown objects
//        return -1; // Unknown classification
//
//    }

    public static int getClassification(Individual individual) {
        BooleanState isHumanoid = individual.getHumanoidStatus();
        String planet = individual.getPlanet();
        int age = individual.getAge();
        List<String> traits = individual.getTraits();

        // Print out the current values for debugging
//        System.out.println("ID: " + individual.getId() +
//                ", isHumanoid: " + isHumanoid +
//                ", planet: " + planet +
//                ", age: " + age +
//                ", traits: " + traits);

        // Default classification value


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
