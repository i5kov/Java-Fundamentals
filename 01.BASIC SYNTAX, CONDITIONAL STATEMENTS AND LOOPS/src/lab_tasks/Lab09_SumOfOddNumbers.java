package lab_tasks;

import java.util.Scanner;

public class Lab09_SumOfOddNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        int sumOddNumbers = 0;

        for (int i = 1; i < inputNumber * 2; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
                sumOddNumbers += i;
            }
        }
        System.out.println("Sum: " + sumOddNumbers);
    }
}
