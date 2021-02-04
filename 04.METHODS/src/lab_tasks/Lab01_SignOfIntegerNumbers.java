package lab_tasks;

import java.util.Scanner;

public class Lab01_SignOfIntegerNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        printSignOfNumber(inputNumber);
    }

    private static void printSignOfNumber(int number) {
        String positiveOrNegativeOrZero;
        if (number > 0) {
            positiveOrNegativeOrZero = "positive";
        } else if (number < 0) {
            positiveOrNegativeOrZero = "negative";
        } else {
            positiveOrNegativeOrZero = "zero";
        }
        System.out.printf("The number %d is %s.%n", number, positiveOrNegativeOrZero);
    }

}
