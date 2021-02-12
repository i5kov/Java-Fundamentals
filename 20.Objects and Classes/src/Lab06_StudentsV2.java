import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab06_StudentsV2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<StudentV2> studentsV2 = new ArrayList<>();

        while (!input.equals("end")) {
            String[] studentInfo = input.split("\\s+");

            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            int age = Integer.parseInt(studentInfo[2]);
            String hometown = studentInfo[3];

            StudentV2 studentV2 = new StudentV2(firstName, lastName, age, hometown);

            if (isStudentExist(studentsV2, firstName, lastName)) {
                StudentV2 existingStudent = studentV2.getStudent(studentsV2, firstName, lastName);
                existingStudent.setAge(age);
                existingStudent.setHometown(hometown);
            } else {
                studentsV2.add(studentV2);
            }

            input = scanner.nextLine();
        }
        String cityName = scanner.nextLine();

        for (StudentV2 studentV2 : studentsV2) {
            if (studentV2.getHometown().equals(cityName)) {
                System.out.printf("%s %s is %d years old%n", studentV2.getFirstName(), studentV2.getLastName(), studentV2.getAge());
            }
        }

    }

    private static boolean isStudentExist(List<StudentV2> students, String firstName, String lastName) {
        boolean isStudentExist = false;
        for (StudentV2 student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                isStudentExist = true;
                break;
            }
        }
        return isStudentExist;
    }
}

class StudentV2 {

    String firstName;
    String lastName;
    int age;
    String hometown;

    public StudentV2(String firstName, String lastName, int age, String hometown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public StudentV2 getStudent(List<StudentV2> studentV2s, String firstName, String lastName) {
        StudentV2 existingStudent = null;

        for (StudentV2 studentV2 : studentV2s) {
            if (studentV2.getFirstName().equals(firstName) && studentV2.getLastName().equals(lastName)) {
                existingStudent = studentV2;
            }
        }
        return existingStudent;
    }
}
