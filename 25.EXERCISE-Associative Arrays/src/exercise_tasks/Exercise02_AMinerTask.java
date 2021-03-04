package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise02_AMinerTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String resource = command;
            Integer quantity = Integer.parseInt(scanner.nextLine());

            Integer occurrenceOfResource = resources.get(resource);
            if (occurrenceOfResource == null) {
                occurrenceOfResource = 0;
            }
            resources.put(resource, occurrenceOfResource + quantity);

            command = scanner.nextLine();
        }

        resources.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
