import java.util.Scanner;

public class Lab02_Grades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        printGradeInWords(grade);
    }

    private static void printGradeInWords(double grade) {
        String gradeAsWord = "";
        if (grade >= 2.00 && grade <= 2.99) {
            gradeAsWord = "Fail";
        } else if (grade <= 3.49) {
            gradeAsWord = "Poor";
        } else if (grade <= 4.49) {
            gradeAsWord = "Good";
        } else if (grade <= 5.49) {
            gradeAsWord = "Very good";
        } else if (grade <= 6.00) {
            gradeAsWord = "Excellent";
        }
        System.out.println(gradeAsWord);
    }
}
