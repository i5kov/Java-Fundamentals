package finalexam_05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task03_Pirates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, int[]> cities = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] cityInfo = input.split("\\|\\|");
            String city = cityInfo[0];
            int population = Integer.parseInt(cityInfo[1]);
            int gold = Integer.parseInt(cityInfo[2]);

            int[] populationAndGold = new int[]{population, gold};

            if (!cities.containsKey(city)) {
                cities.put(city, populationAndGold);
            } else {
                cities.get(city)[0] += population;
                cities.get(city)[1] += gold;
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] events = input.split("=>");
            String command = events[0];
            String town = events[1];

            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(events[2]);
                    int gold = Integer.parseInt(events[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                    cities.get(town)[0] -= people;
                    cities.get(town)[1] -= gold;

                    if (cities.get(town)[0] <= 0 || cities.get(town)[1] <= 0) {
                        System.out.printf("%s has been wiped off the map!%n", town);
                        cities.remove(town);
                    }
                    break;
                case "Prosper":
                    int prosperGold = Integer.parseInt(events[2]);
                    if (prosperGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        cities.get(town)[1] += prosperGold;
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                prosperGold, town, cities.get(town)[1]);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.entrySet()
                    .stream()
                    .sorted((f, s) -> {
                        int result = Integer.compare(s.getValue()[1], f.getValue()[1]);
                        if (result == 0) {
                            result = f.getKey().compareTo(s.getKey());
                        }
                        return result;
                    })
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            e.getKey(), e.getValue()[0], e.getValue()[1]));
        }
    }
}
