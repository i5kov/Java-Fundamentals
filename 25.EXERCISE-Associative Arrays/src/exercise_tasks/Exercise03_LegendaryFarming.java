package exercise_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise03_LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        boolean isObtained = false;

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        while (true) {
            String[] tokens = input.split("\\s+");

            for (int i = 0; i < tokens.length - 1; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if (isKeyMaterial(material)) {
                    int updatedQuantity = keyMaterials.get(material) + quantity;
                    keyMaterials.put(material, updatedQuantity);
                    if (keyMaterials.get(material) >= 250) {
                        System.out.printf("%s obtained!%n", getObtainedItem(material));
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        isObtained = true;
                        break;
                    }
                } else {
                    junkMaterials.putIfAbsent(material, 0);
                    junkMaterials.put(material, junkMaterials.get(material) + quantity);
                }
            }
            if (isObtained) {
                break;
            }

            input = scanner.nextLine();
        }

        keyMaterials.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(s.getValue(), f.getValue());
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junkMaterials
                .forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static String getObtainedItem(String material) {
        switch (material) {
            case "shards":
                return "Shadowmourne";
            case "fragments":
                return "Valanyr";
            case "motes":
                return "Dragonwrath";
            default:
                return "";
        }
    }

    private static boolean isKeyMaterial(String material) {
        return material.equalsIgnoreCase("Shards")
                || material.equalsIgnoreCase("Fragments")
                || material.equalsIgnoreCase("Motes");
    }
}
