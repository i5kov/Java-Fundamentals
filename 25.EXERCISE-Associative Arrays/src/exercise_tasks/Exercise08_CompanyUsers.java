package exercise_tasks;

import java.util.*;

public class Exercise08_CompanyUsers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, List<String>> companyAndEmployees = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String companyName = tokens[0];
            String employeeId = tokens[1];

            companyAndEmployees.putIfAbsent(companyName, new ArrayList<>());
            if (!companyAndEmployees.get(companyName).contains(employeeId)) {
                companyAndEmployees.get(companyName).add(employeeId);
            }

            input = scanner.nextLine();
        }
        companyAndEmployees
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().forEach(id -> System.out.printf("-- %s%n", id));
                });
    }
}
