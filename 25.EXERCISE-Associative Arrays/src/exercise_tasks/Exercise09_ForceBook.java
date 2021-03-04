package exercise_tasks;

import java.util.*;

public class Exercise09_ForceBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> sidesAndUsers = new TreeMap<>();

        while (!input.equals("Lumpawaroo")) {
            String[] tokens;
            String forceSide;
            String forceUser;

            if (input.contains(" | ")) {
                tokens = input.split(" \\| ");
                forceSide = tokens[0];
                forceUser = tokens[1];

                boolean isExist = false;
                for (Map.Entry<String, List<String>> current : sidesAndUsers.entrySet()) {
                    if (current.getValue().contains(forceUser)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    if (!sidesAndUsers.containsKey(forceSide)) {
                        sidesAndUsers.put(forceSide, new ArrayList<>());
                    }
                    if (!sidesAndUsers.get(forceSide).contains(forceUser)) {
                        sidesAndUsers.get(forceSide).add(forceUser);
                    }
                }
            } else if (input.contains(" -> ")) {
                tokens = input.split(" -> ");
                forceUser = tokens[0];
                forceSide = tokens[1];

                for (Map.Entry<String, List<String>> entry : sidesAndUsers.entrySet()) {
                    entry.getValue().remove(forceUser);
                }
                if (!sidesAndUsers.containsKey(forceSide)) {
                    sidesAndUsers.put(forceSide, new ArrayList<>());
                }
                sidesAndUsers.get(forceSide).add(forceUser);
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
            input = scanner.nextLine();
        }

        sidesAndUsers
                .entrySet()
                .stream()
                .filter(users -> users.getValue().size() > 0)
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed())
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
                    s.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(person -> System.out.printf("! %s%n", person));
                });

    }
}
