package lab_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Lab05_EvenAndOddSubtraction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int sumEvenNumbers = 0;
        int sumOddNumbers = 0;

        for (int currentNumber : numbers) {
            if (currentNumber % 2 == 0) {
                sumEvenNumbers += currentNumber;
            } else {
                sumOddNumbers += currentNumber;
            }
        }
        System.out.println(sumEvenNumbers - sumOddNumbers);
    }
}
