package lab_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Lab06_EqualArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        boolean areArraysEquals = true;

        for (int index = 0; index < firstArray.length; index++) {
            if (firstArray[index] != secondArray[index]) {
                areArraysEquals = false;
                System.out.printf("Arrays are not identical. Found difference at %d index.%n", index);
                break;
            } else {
                sum += firstArray[index];
            }
        }
        if (areArraysEquals) {
            System.out.printf("Arrays are identical. Sum: %d%n", sum);
        }
    }
}
