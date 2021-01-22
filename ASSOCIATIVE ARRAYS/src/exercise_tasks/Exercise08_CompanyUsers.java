package exercise_tasks;

import java.util.*;

public class Exercise08_CompanyUsers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> companiesAndEmployees = new TreeMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String employeeId = tokens[1];

            if (!companiesAndEmployees.containsKey(company)) {
                companiesAndEmployees.put(company, new ArrayList<>());
            }
            if (!companiesAndEmployees.get(company).contains(employeeId)) {
                companiesAndEmployees.get(company).add(employeeId);
            }
            input = scanner.nextLine();
        }

        companiesAndEmployees.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(v -> System.out.println("-- " + v));
        });
    }
}
