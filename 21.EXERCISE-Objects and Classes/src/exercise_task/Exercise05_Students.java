package exercise_task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exercise05_Students {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] studentInfo = scanner.nextLine().split("\\s+");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            double grade = Double.parseDouble(studentInfo[2]);

            students.add(new Student(firstName, lastName, grade));
        }
        students.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .forEach(student -> System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getLastName(), student.getGrade()));
    }
}

class Student {

    String firstName;
    String lastName;
    double grade;

    public Student(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
