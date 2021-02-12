package exercise_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise04_ArrayRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {
            int firstElement = numbers[0];
            int j = 0;
            while (j < numbers.length - 1) {
                numbers[j] = numbers[j + 1];
                j++;
            }
            numbers[numbers.length - 1] = firstElement;
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
