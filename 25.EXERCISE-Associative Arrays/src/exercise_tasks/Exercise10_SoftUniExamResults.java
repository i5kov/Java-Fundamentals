package exercise_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise10_SoftUniExamResults {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> usersAndPoints = new HashMap<>();
        Map<String, Integer> languageAndSubmissions = new HashMap<>();

        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            String username = tokens[0];

            if (input.contains("banned")) {
                usersAndPoints.remove(username);
            } else {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);

                languageAndSubmissions.putIfAbsent(language, 0);
                languageAndSubmissions.put(language, languageAndSubmissions.get(language) + 1);

                usersAndPoints.putIfAbsent(username, points);
                if (points > usersAndPoints.get(username)) {
                    usersAndPoints.put(username, points);
                }
            }

            input = scanner.nextLine();
        }
        System.out.println("Results:");
        printMapOrderedDescendingByValuesThenByKeys(usersAndPoints, '|');

        System.out.println("Submissions:");
        printMapOrderedDescendingByValuesThenByKeys(languageAndSubmissions, '-');
    }

    private static void printMapOrderedDescendingByValuesThenByKeys(Map<String, Integer> map, char characterForPrinting) {
        map.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(s.getValue(), f.getValue());
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.printf("%s %c %d%n", e.getKey(), characterForPrinting, e.getValue()));
    }
}
