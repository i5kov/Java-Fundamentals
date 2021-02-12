package exercise_tasks;

import java.util.Scanner;

public class Exercise04_SumOfChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < numberOfLines; i++) {
            char letter = scanner.nextLine().charAt(0);
            sum += letter;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
