package moreexercise_tasks;

import java.util.Scanner;

public class ME03_FloatingEquality {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber = Double.parseDouble(scanner.nextLine());
        double secondNumber = Double.parseDouble(scanner.nextLine());
        double eps = 0.000001;

        if (Math.abs(firstNumber - secondNumber) <= eps) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
