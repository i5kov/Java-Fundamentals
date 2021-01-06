package exercise_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise08_MagicSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int inputNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == inputNumber) {
                    System.out.printf("%d %d%n", numbers[i], numbers[j]);
                }
            }
        }
    }
}
