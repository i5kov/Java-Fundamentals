package moreexercise_tasks;

import java.util.Scanner;

public class ME02_FromLeftToTheRight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= lines; i++) {
            double[] twoNumbers = inputFromConsoleSeparatedBySpace(scanner.nextLine());
            double greaterNumber = Math.max(twoNumbers[0], twoNumbers[1]);
            printSumOfAllDigits(greaterNumber);
        }
    }

    public static double[] inputFromConsoleSeparatedBySpace(String input) {
        String[] splitAsString = input.split("\\s+");
        double[] result = new double[splitAsString.length];
        for (int i = 0; i < splitAsString.length; i++) {
            result[i] = Double.parseDouble(splitAsString[i]);
        }
        return result;
    }

    public static void printSumOfAllDigits(double number) {
        int sum = 0;
        while (number != 0) {
            double digit = number % 10;
            sum += digit;
            number /= 10;
        }
        System.out.println(Math.abs(sum));
    }
}
