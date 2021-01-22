package exercise_tasks;

import java.util.*;

public class Exercise06_Courses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");
            String course = tokens[0];
            String studentName = tokens[1];

            if (!courses.containsKey(course)) {
                courses.put(course, new ArrayList<>());
            }
            courses.get(course).add(studentName);
            input = scanner.nextLine();
        }

        courses.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted(Comparator.naturalOrder())
                            .forEach(n -> System.out.println("-- " + n));
                });
    }
}
