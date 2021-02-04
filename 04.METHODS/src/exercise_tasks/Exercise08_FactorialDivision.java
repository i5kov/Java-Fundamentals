package exercise_tasks;

import java.util.Scanner;

public class Exercise08_FactorialDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNum = Integer.parseInt(scanner.nextLine());
        double secondNum = Integer.parseInt(scanner.nextLine());
        double divide = (1.0 * getFactorial(firstNum)) / getFactorial(secondNum);
        System.out.printf("%.2f", divide);
    }

    public static long getFactorial(double number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
