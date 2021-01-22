package exercise_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise03_LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        boolean isObserved = false;

        while (!isObserved) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if (isKeyMaterial(material)) {
                    keyMaterials.putIfAbsent(material, 0);
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    if (keyMaterials.get(material) >= 250) {
                        System.out.printf("%s obtained!%n", getObtainedMaterial(material));
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        isObserved = true;
                        break;
                    }
                } else {
                    junkMaterials.putIfAbsent(material, 0);
                    junkMaterials.put(material, junkMaterials.get(material) + quantity);
                }
            }
        }
        keyMaterials.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junkMaterials.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static boolean isKeyMaterial(String material) {
        return material.equals("shards") || material.equals("fragments") || material.equals("motes");
    }

    private static String getObtainedMaterial(String material) {
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
}
