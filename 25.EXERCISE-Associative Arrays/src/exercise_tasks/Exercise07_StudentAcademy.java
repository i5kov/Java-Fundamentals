package exercise_tasks;

import java.util.*;

public class Exercise07_StudentAcademy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String name = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students.entrySet()
                .stream()
                .filter(e -> e.getValue().stream().mapToDouble(g -> g).average().getAsDouble() >= 4.50)
                .sorted((f, s) -> {
                    double firstAverageGrade = f.getValue().stream().mapToDouble(g -> g).average().getAsDouble();
                    double secondAverageGrade = s.getValue().stream().mapToDouble(g -> g).average().getAsDouble();
                    return Double.compare(secondAverageGrade, firstAverageGrade);
                })
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue().stream().mapToDouble(g -> g).average().getAsDouble()));
    }
}
