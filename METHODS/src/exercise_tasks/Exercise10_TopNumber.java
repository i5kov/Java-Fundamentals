package exercise_tasks;

import java.util.Scanner;

public class Exercise10_TopNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= inputNumber; i++) {
            if (isTopNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isTopNumber(int number) {
        return isSumOfDigitsDivisibleByEight(number) && isHoldAtLeastOneOddDigit(number);
    }

    private static boolean isSumOfDigitsDivisibleByEight(int number) {
        int sumOfDigits = 0;
        while (number > 0) {
            int digit = number % 10;
            sumOfDigits += digit;
            number /= 10;
        }
        return sumOfDigits % 8 == 0;
    }

    private static boolean isHoldAtLeastOneOddDigit(int number) {
        boolean hasAtLeastOneOddDigit = false;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 1) {
                hasAtLeastOneOddDigit = true;
                break;
            }
            number /= 10;
        }
        return hasAtLeastOneOddDigit;
    }
}
