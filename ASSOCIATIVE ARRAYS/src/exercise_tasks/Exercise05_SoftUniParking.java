package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise05_SoftUniParking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, String> allUsers = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "register":
                    String carNumber = tokens[2];
                    if (!allUsers.containsKey(username)) {
                        allUsers.put(username, carNumber);
                        System.out.printf("%s registered %s successfully%n", username, carNumber);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", carNumber);
                    }
                    break;
                case "unregister":
                    if (allUsers.containsKey(username)) {
                        allUsers.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }
                    break;
            }
        }
        allUsers.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
