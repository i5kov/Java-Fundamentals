package exercise_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise06_EqualSums {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean isSumEquals = false;

        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = i - 1; j >= 0; j--) {
                leftSum += numbers[j];
            }
            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }

            if (rightSum == leftSum) {
                System.out.println(i);
                isSumEquals = true;
                break;
            }
        }
        if (!isSumEquals) {
            System.out.println("no");
        }
    }
}
