package exercise_tasks;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise10_SoftUniExamResults {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> users = new TreeMap<>();
        Map<String, Integer> submissions = new TreeMap<>();

        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            String username = tokens[0];

            if (!input.contains("banned")) {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);

                if (!users.containsKey(username)) {
                    users.put(username, points);
                    if (!submissions.containsKey(language)) {
                        submissions.put(language, 1);
                    } else {
                        submissions.put(language, submissions.get(language) + 1);
                    }
                } else {
                    if (points >= users.get(username)) {
                        users.put(username, points);
                    }
                    submissions.put(language, submissions.get(language) + 1);
                }
            } else {
                users.remove(username);
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        users
                .entrySet()
                .stream()
                .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                .forEach(m -> System.out.printf("%s | %d%n", m.getKey(), m.getValue()));
        System.out.println("Submissions:");
        submissions
                .entrySet()
                .stream()
                .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                .forEach(m -> System.out.printf("%s - %d%n", m.getKey(), m.getValue()));
    }
}
