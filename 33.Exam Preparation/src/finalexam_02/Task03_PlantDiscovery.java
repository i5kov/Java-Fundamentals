package finalexam_02;

import java.util.*;

public class Task03_PlantDiscovery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantsRarity = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRating = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] plantInfo = scanner.nextLine().split("<->");
            String plant = plantInfo[0];
            int rarity = Integer.parseInt(plantInfo[1]);

            plantsRarity.putIfAbsent(plant, 0);
            plantsRating.putIfAbsent(plant, new ArrayList<>());
            plantsRarity.put(plant, plantsRarity.get(plant) + rarity);
        }
        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] tokens = input.split("[:-]");
            input = scanner.nextLine();
            String command = tokens[0];
            String plant = tokens[1].trim();

            switch (command) {
                case "Rate":
                    double rating = Double.parseDouble(tokens[2].trim());
                    List<Double> ratings = plantsRating.get(plant);
                    if (ratings != null) {
                        ratings.add(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(tokens[2].trim());
                    plantsRarity.put(plant, newRarity);
                    break;
                case "Reset":
                    List<Double> ratingsForClear = plantsRating.get(plant);
                    if (ratingsForClear != null) {
                        ratingsForClear.clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
            }
        }
        System.out.println("Plants for the exhibition:");
        plantsRarity.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0) {
                        double firstPlantAverageRating = plantsRating.get(f.getKey()).stream().mapToDouble(x -> x).average().orElse(0);
                        double secondPlantAverageRating = plantsRating.get(s.getKey()).stream().mapToDouble(x -> x).average().orElse(0);
                        result = Double.compare(secondPlantAverageRating, firstPlantAverageRating);
                    }
                    return result;
                }).forEach(e -> {
            double averageRating = plantsRating.get(e.getKey()).stream().mapToDouble(x -> x).average().orElse(0);
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(), e.getValue(), averageRating);
        });
    }
}
