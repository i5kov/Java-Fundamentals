package exercise_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise05_TopIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            boolean isBigger = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (!(numbers[i] > numbers[j])) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                System.out.printf("%d ", numbers[i]);
            }
        }
    }
}
