package lab_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Lab03_SumEvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int sumOfEvenNumbers = getSumOfEvenNumbers(numbers);
        System.out.println(sumOfEvenNumbers);
    }

    private static int getSumOfEvenNumbers(int[] numbers) {
        int sum = 0;
        for (int currentNumber : numbers) {
            if (currentNumber % 2 == 0) {
                sum += currentNumber;
            }
        }
        return sum;
    }
}
