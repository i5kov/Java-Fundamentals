package exercise_tasks;

import java.util.*;

public class Exercise07_StudentAcademy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new HashMap<>();

        for (int i = 0; i < lines; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(studentName)) {
                students.put(studentName, new ArrayList<>());
            }
            students.get(studentName).add(grade);
        }

        students.entrySet()
                .stream()
                .filter(e -> e.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50)
                .sorted((f, s) -> {
                    double secondAverage = s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double firstAverage = f.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(secondAverage, firstAverage);
                }).forEach(s -> {
                    double averageGrade = s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            System.out.printf("%s -> %.2f%n", s.getKey(), averageGrade);
        });
    }
}
