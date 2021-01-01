package lab_tasks;

import java.util.Scanner;

public class Lab10_MultiplicationTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n", inputNumber, i, inputNumber * i);
        }
    }
}
