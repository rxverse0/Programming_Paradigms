import java.util.*;

class Attraction {
    private String name;
    private String location;

    public Attraction(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }
}

class TouristicPackage {
    private String name;
    private int id;
    private double price;
    private List<Attraction> attractions;

    public TouristicPackage(String name, int id, double price, List<Attraction> attractions) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.attractions = attractions;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create attractions
        Attraction attraction1 = new Attraction("Paltinis", "Sibiu");
        Attraction attraction2 = new Attraction("Castelul Bran", "Brasov");
        Attraction attraction3 = new Attraction("Transfagarasan", "Arges");

        // Create touristic packages
        List<TouristicPackage> touristicPackages = new ArrayList<>();
        touristicPackages.add(new TouristicPackage("Package1", 1, 100.0, Arrays.asList(attraction1, attraction2)));
        touristicPackages.add(new TouristicPackage("Package2", 2, 150.0, Arrays.asList(attraction2, attraction3)));
        touristicPackages.add(new TouristicPackage("Package3", 3, 120.0, Arrays.asList(attraction1, attraction2, attraction3)));
        touristicPackages.add(new TouristicPackage("Package4", 4, 180.0, Arrays.asList(attraction2, attraction3)));
        touristicPackages.add(new TouristicPackage("Package5", 5, 140.0, Arrays.asList(attraction1, attraction2, attraction3)));
        touristicPackages.add(new TouristicPackage("Package6", 6, 150.0, Arrays.asList(attraction3, attraction2)));
        touristicPackages.add(new TouristicPackage("Package7", 7, 170.0, Arrays.asList(attraction1, attraction3)));
        touristicPackages.add(new TouristicPackage("Package8", 8, 180.0, Arrays.asList(attraction1, attraction2, attraction3)));
        touristicPackages.add(new TouristicPackage("Package9", 9, 120.0, Arrays.asList(attraction1, attraction3)));
        touristicPackages.add(new TouristicPackage("Package10", 10, 100.0, Arrays.asList(attraction2, attraction3)));

        // Count how many times each attraction was bought
        Map<Attraction, Integer> attractionBoughtCount = new HashMap<>();
        for (TouristicPackage touristicPackage : touristicPackages) {
            for (Attraction attraction : touristicPackage.getAttractions()) {
                attractionBoughtCount.put(attraction, attractionBoughtCount.getOrDefault(attraction, 0) + 1);
            }
        }

        // Calculate relative popularity
        Map<Attraction, Double> relativePopularity = new HashMap<>();
        int totalPackages = touristicPackages.size() * touristicPackages.get(0).getAttractions().size();
        for (Map.Entry<Attraction, Integer> entry : attractionBoughtCount.entrySet()) {
            Attraction attraction = entry.getKey();
            int boughtCount = entry.getValue();
            double popularity = (double) boughtCount / totalPackages;
            relativePopularity.put(attraction, popularity);
        }

        // Print results
        System.out.println("Attraction Statistics:");
        for (Attraction attraction : attractionBoughtCount.keySet()) {
            int boughtCount = attractionBoughtCount.get(attraction);
            double popularity = relativePopularity.get(attraction);
            System.out.println(attraction.getName() + " - Bought: " + boughtCount + " times, Relative Popularity: " + popularity);
        }
    }
}
