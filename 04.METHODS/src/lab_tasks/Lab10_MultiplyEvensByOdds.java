package lab_tasks;

import java.util.Scanner;

public class Lab10_MultiplyEvensByOdds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        int multipleOfEvensAndOdds = getMultipleOfEvensAndOdds(Math.abs(inputNumber));
        System.out.println(multipleOfEvensAndOdds);
    }

    private static int getMultipleOfEvensAndOdds(int number) {
        int sumOfEventDigits = getSumOfEventDigits(number);
        int sumOfOddDigits = getSumOfOddDigits(number);
        return sumOfEventDigits * sumOfOddDigits;
    }

    private static int getSumOfEventDigits(int number) {
        int evenSum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                evenSum += lastDigit;
            }
            number /= 10;
        }
        return evenSum;
    }

    private static int getSumOfOddDigits(int number) {
        int oddSum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 1) {
                oddSum += lastDigit;
            }
            number /= 10;
        }
        return oddSum;
    }
}
