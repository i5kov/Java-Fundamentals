package lab_tasks;

import java.util.Scanner;

public class Lab10_SpecialNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= inputNumber; i++) {
            int currentNumber = i;
            int sum = 0;

            while (currentNumber > 0) {
                int lastDigit = currentNumber % 10;
                sum += lastDigit;
                currentNumber /= 10;
            }
            System.out.printf("%d -> %s%n", i, isSpecialNumber(sum));
        }
    }

    private static String isSpecialNumber(int sum) {
        if (sum == 5 || sum == 7 || sum == 11) {
            return "True";
        }
        return "False";
    }
}
