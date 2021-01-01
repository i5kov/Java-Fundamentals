package lab_tasks;

import java.util.Scanner;

public class Lab11_MultiplicationTable2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        if (multiplier > 10) {
            System.out.printf("%d X %d = %d%n", inputNumber, multiplier, inputNumber * multiplier);
        } else {
            for (int i = multiplier; i <= 10; i++) {
                System.out.printf("%d X %d = %d%n", inputNumber, i, inputNumber * i);
            }
        }
    }
}
