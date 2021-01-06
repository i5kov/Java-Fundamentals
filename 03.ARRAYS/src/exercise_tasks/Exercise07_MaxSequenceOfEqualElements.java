package exercise_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise07_MaxSequenceOfEqualElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int bestSequenceCount = 0;
        int index = 0;

        for (int i = 0; i < numbers.length; i++) {
            int currentSequenceCount = 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    currentSequenceCount++;
                    if (currentSequenceCount > bestSequenceCount) {
                        bestSequenceCount = currentSequenceCount;
                        index = i;
                    }
                } else {
                    break;
                }
            }

        }
        for (int i = 0; i < bestSequenceCount; i++) {
            System.out.print(numbers[i + index ] + " ");
        }
    }
}
