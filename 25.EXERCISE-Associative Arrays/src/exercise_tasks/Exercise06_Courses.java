package exercise_tasks;

import java.util.*;

public class Exercise06_Courses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, List<String>> courses = new HashMap<>();

        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];

            courses.putIfAbsent(courseName, new ArrayList<>());
            courses.get(courseName).add(studentName);

            input = scanner.nextLine();
        }

        courses.entrySet()
                .stream()
                .sorted((f, s) -> Integer.compare(s.getValue().size(), f.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted(Comparator.naturalOrder())
                            .forEach(s -> System.out.println("-- " + s));
                });
    }
}
