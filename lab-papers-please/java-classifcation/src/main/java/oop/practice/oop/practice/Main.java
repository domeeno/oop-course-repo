import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

enum Universe {
    STAR_WARS,
    MARVEL,
    HITCHHIKER,
    LORD_OF_THE_RINGS,
    UNDEFINED
}

class Individual {
    private int id;
    private Boolean isHumanoid;
    private String originPlanet;
    private Integer age;
    private List<String> physicalTraits;
    private Universe universe;

    public Individual() {}

    public void setIsHumanoid(Boolean isHumanoid) {
        this.isHumanoid = isHumanoid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOriginPlanet(String originPlanet) {
        this.originPlanet = originPlanet;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhysicalTraits(List<String> physicalTraits) {
        this.physicalTraits = physicalTraits;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public int getId() {
        return id;
    }

    public Boolean isHumanoid() {
        return isHumanoid;
    }

    public String getOriginPlanet() {
        return originPlanet;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getPhysicalTraits() {
        return physicalTraits;
    }

    public Universe getUniverse() {
        return universe;
    }
}

class Files {
    List<Individual> readJsonFile(File obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Individual> individuals = mapper.readValue(
                    obj, new TypeReference<List<Individual>>() {}
            );
            return individuals;
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + obj.getName());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    void writeJsonFile(String filename, UniverseOutput output) {
        File file = new File(filename);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(file, output);
            System.out.println("File written successfully: " + filename);
        }
        catch (IOException e) {
            System.out.println("Error writing file: " + filename);
            e.printStackTrace();
        }
    }
}

class UniverseOutput {
    private String name;
    private List<Individual> individuals;

    public UniverseOutput(String name, List<Individual> individuals) {
        this.name = name;
        this.individuals = individuals;
    }

    public String getName() {
        return name;
    }

    public List<Individual> getIndividuals() {
        return individuals;
    }
}

public class Main {

    // scoring logic from message.txt
    private static int matchScore(Individual ind, String planet, Boolean humanoid, int maxAge, String... traits) {
        int score = 0;

        if (ind.getOriginPlanet() != null && ind.getOriginPlanet().equals(planet))
            score += 3;

        if (ind.isHumanoid() != null && ind.isHumanoid().equals(humanoid))
            score += 1;

        if (ind.getAge() != null && ind.getAge() <= maxAge)
            score += 1;

        if (ind.getPhysicalTraits() != null) {
            for (String t : ind.getPhysicalTraits()) {
                for (String req : traits) {
                    if (t.equals(req)) score++;
                }
            }
        }

        return score;
    }

    private static boolean canBeAsgardian(Individual ind) {
        int score = matchScore(ind, "ASGARD", true, 5000, "BLONDE", "TALL");
        if (ind.getOriginPlanet() != null && ind.getOriginPlanet().equals("ASGARD")) return true;
        return score > 0;
    }

    private static boolean canBeWookie(Individual ind) {
        int score = matchScore(ind, "KASHYYYK", false, 400, "HAIRY", "TALL");
        if (ind.getOriginPlanet() != null && ind.getOriginPlanet().equals("KASHYYYK")) return true;
        return score > 0;
    }

    private static boolean canBeEwok(Individual ind) {
        int score = matchScore(ind, "ENDOR", false, 60, "SHORT", "HAIRY");
        if (ind.getOriginPlanet() != null && ind.getOriginPlanet().equals("ENDOR")) return true;
        return score > 0;
    }

    private static boolean canBeBetelgeusian(Individual ind) {
        int score = matchScore(ind, "BETELGEUSE", true, 100, "EXTRA_ARMS", "EXTRA_HEAD");
        if (ind.getOriginPlanet() != null && ind.getOriginPlanet().equals("BETELGEUSE")) return true;
        return score > 0;
    }

    private static boolean canBeVogon(Individual ind) {
        int score = matchScore(ind, "VOGSPHERE", false, 200, "GREEN", "BULKY");
        if (ind.getOriginPlanet() != null && ind.getOriginPlanet().equals("VOGSPHERE")) return true;
        return score > 0;
    }

    private static boolean canBeElf(Individual ind) {
        int score = matchScore(ind, "EARTH", true, Integer.MAX_VALUE, "BLONDE", "POINTY_EARS");
        if (ind.getOriginPlanet() != null && ind.getOriginPlanet().equals("EARTH")) return true;
        return score > 0;
    }

    private static boolean canBeDwarf(Individual ind) {
        int score = matchScore(ind, "EARTH", true, 200, "SHORT", "BULKY");
        if (ind.getOriginPlanet() != null && ind.getOriginPlanet().equals("EARTH")) return true;
        return score > 0;
    }

    // FINAL classification logic copied from message.txt behavior
    private static void classifyIndividual(Individual ind) {

        class Species {
            Universe u;
            String planet;
            Boolean humanoid;
            int maxAge;
            String[] traits;

            Species(Universe u, String p, Boolean h, int m, String... t) {
                this.u = u; this.planet = p; this.humanoid = h; this.maxAge = m; this.traits = t;
            }
        }

        List<Species> species = List.of(
                new Species(Universe.STAR_WARS, "KASHYYYK", false, 400, "HAIRY", "TALL"),
                new Species(Universe.STAR_WARS, "ENDOR", false, 60, "SHORT", "HAIRY"),
                new Species(Universe.MARVEL, "ASGARD", true, 5000, "BLONDE", "TALL"),
                new Species(Universe.HITCHHIKER, "BETELGEUSE", true, 100, "EXTRA_ARMS", "EXTRA_HEAD"),
                new Species(Universe.HITCHHIKER, "VOGSPHERE", false, 200, "GREEN", "BULKY"),
                new Species(Universe.LORD_OF_THE_RINGS, "EARTH", true, Integer.MAX_VALUE, "BLONDE", "POINTY_EARS"),
                new Species(Universe.LORD_OF_THE_RINGS, "EARTH", true, 200, "SHORT", "BULKY")
        );

        // planet match = forced classification
        for (Species sp : species) {
            if (ind.getOriginPlanet() != null && ind.getOriginPlanet().equals(sp.planet)) {
                ind.setUniverse(sp.u);
                return;
            }
        }

        int bestScore = -1;
        List<Species> best = new ArrayList<>();

        for (Species sp : species) {
            int score = matchScore(ind, sp.planet, sp.humanoid, sp.maxAge, sp.traits);

            if (score > bestScore) {
                bestScore = score;
                best.clear();
                best.add(sp);
            } else if (score == bestScore) {
                best.add(sp);
            }
        }

        if (bestScore == 0) {
            ind.setUniverse(Universe.UNDEFINED);
            return;
        }

        Universe uni = best.get(0).u;
        for (Species s : best) {
            if (s.u != uni) {
                ind.setUniverse(Universe.UNDEFINED);
                return;
            }
        }

        ind.setUniverse(uni);
    }

    public static void main(String[] args) {
        Files files = new Files();

        File fileObj = new File("lab-papers-please/input.json");
        List<Individual> individuals = files.readJsonFile(fileObj);
        System.out.println("Total individuals: " + individuals.size());

        System.out.println("\nClassifying Individuals");
        for (Individual individual : individuals) {
            classifyIndividual(individual);
        }

        int starWarsCount = 0;
        int marvelCount = 0;
        int hitchhikerCount = 0;
        int lordOfTheRingsCount = 0;
        int undefinedCount = 0;

        for (Individual individual : individuals) {
            switch (individual.getUniverse()) {
                case STAR_WARS:
                    starWarsCount++;
                    break;
                case MARVEL:
                    marvelCount++;
                    break;
                case HITCHHIKER:
                    hitchhikerCount++;
                    break;
                case LORD_OF_THE_RINGS:
                    lordOfTheRingsCount++;
                    break;
                case UNDEFINED:
                    undefinedCount++;
                    break;
            }
        }

        System.out.println("\n----STAR WARS Universe (" + starWarsCount + " individuals)");
        for (Individual individual : individuals) {
            if (individual.getUniverse() == Universe.STAR_WARS) {
                System.out.println("ID: " + individual.getId() + ", from " + individual.getOriginPlanet());
            }
        }

        System.out.println("\nMARVEL Universe (" + marvelCount + " individuals)");
        for (Individual individual : individuals) {
            if (individual.getUniverse() == Universe.MARVEL) {
                System.out.println("ID: " + individual.getId() + ", from " + individual.getOriginPlanet());
            }
        }

        System.out.println("\nHITCHHIKER Universe (" + hitchhikerCount + " individuals)");
        for (Individual individual : individuals) {
            if (individual.getUniverse() == Universe.HITCHHIKER) {
                System.out.println("ID: " + individual.getId() + ", from " + individual.getOriginPlanet());
            }
        }

        System.out.println("\nLORD OF THE RINGS Universe (" + lordOfTheRingsCount + " individuals)");
        for (Individual individual : individuals) {
            if (individual.getUniverse() == Universe.LORD_OF_THE_RINGS) {
                System.out.println("ID: " + individual.getId() + ", from " + individual.getOriginPlanet());
            }
        }

        System.out.println("\nUNDEFINED Universe (" + undefinedCount + " individuals)");
        for (Individual individual : individuals) {
            if (individual.getUniverse() == Universe.UNDEFINED) {
                System.out.println("ID: " + individual.getId() + " - Insufficient information");
            }
        }

        System.out.println("Total individuals processed: " + individuals.size());
        System.out.println("Star Wars:        " + starWarsCount);
        System.out.println("Marvel:           " + marvelCount);
        System.out.println("Hitchhiker:       " + hitchhikerCount);
        System.out.println("Lord of the Rings: " + lordOfTheRingsCount);
        System.out.println("Undefined:        " + undefinedCount);

        System.out.println("\nWriting output files...");

        List<Individual> starWarsIndividuals = new ArrayList<>();
        List<Individual> marvelIndividuals = new ArrayList<>();
        List<Individual> hitchhikerIndividuals = new ArrayList<>();
        List<Individual> lordOfTheRingsIndividuals = new ArrayList<>();

        for (Individual individual : individuals) {
            switch (individual.getUniverse()) {
                case MARVEL:
                    marvelIndividuals.add(individual);
                    break;
                case HITCHHIKER:
                    hitchhikerIndividuals.add(individual);
                    break;
                case LORD_OF_THE_RINGS:
                    lordOfTheRingsIndividuals.add(individual);
                    break;
                case STAR_WARS:
                    starWarsIndividuals.add(individual);
                    break;
            }
        }

        UniverseOutput starWarsOutput = new UniverseOutput("starWars", starWarsIndividuals);
        UniverseOutput marvelOutput = new UniverseOutput("marvel", marvelIndividuals);
        UniverseOutput hitchhikerOutput = new UniverseOutput("hitchhiker", hitchhikerIndividuals);
        UniverseOutput lordOfTheRingsOutput = new UniverseOutput("lordOfTheRings", lordOfTheRingsIndividuals);

        files.writeJsonFile("lab-papers-please/java-classification/src/output/starWars.json", starWarsOutput);
        files.writeJsonFile("lab-papers-please/java-classification/src/output/marvel.json", marvelOutput);
        files.writeJsonFile("lab-papers-please/java-classification/src/output/hitchhiker.json", hitchhikerOutput);
        files.writeJsonFile("lab-papers-please/java-classification/src/output/lordOfTheRings.json", lordOfTheRingsOutput);
    }
}
