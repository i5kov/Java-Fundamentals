package exercise_tasks;

import java.util.Scanner;

public class Exercise02_SumDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (inputNumber > 0) {
            int lastDigit = inputNumber % 10;
            sum += lastDigit;
            inputNumber /= 10;
        }
        System.out.println(sum);
    }
}
