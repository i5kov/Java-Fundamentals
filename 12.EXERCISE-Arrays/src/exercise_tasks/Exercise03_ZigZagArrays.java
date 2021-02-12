package exercise_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise03_ZigZagArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[lines];
        int[] secondArray = new int[lines];

        for (int i = 0; i < lines; i++) {
            int[] inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            if (i % 2 == 0) {
                firstArray[i] = inputNumbers[0];
                secondArray[i] = inputNumbers[1];
            } else {
                firstArray[i] = inputNumbers[1];
                secondArray[i] = inputNumbers[0];
            }
        }
        printArrayElements(firstArray);
        printArrayElements(secondArray);
    }

    private static void printArrayElements(int[] array) {
        for (int element : array) {
            System.out.printf("%d ", element);
        }
        System.out.println();
    }
}
