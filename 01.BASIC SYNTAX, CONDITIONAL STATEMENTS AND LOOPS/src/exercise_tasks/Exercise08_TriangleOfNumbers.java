package exercise_tasks;

import java.util.Scanner;

public class Exercise08_TriangleOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= inputNumber; i++) {
            System.out.print(i + " ");
            for (int j = 1; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
