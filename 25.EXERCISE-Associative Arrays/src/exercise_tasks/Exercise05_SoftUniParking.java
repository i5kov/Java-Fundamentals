package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise05_SoftUniParking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, String> users = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "register":
                    String licensePlateNumber = tokens[2];
                    String registered = users.putIfAbsent(username, licensePlateNumber);
                    if (registered != null) {
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                    } else {
                        System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (!users.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                    } else {
                        users.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }
                    break;
            }
        }
        users.forEach((k, v) -> System.out.printf("%s => %s%n", k, v));
    }
}
