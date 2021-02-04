package exercise_tasks;

import java.util.Scanner;

public class Exercise07_NxNMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        printNxNMatrix(inputNumber);
    }

    private static void printNxNMatrix(int number) {
        for (int rows = 0; rows < number; rows++) {
            System.out.print(number + " ");
            for (int cols = 1; cols < number; cols++) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
