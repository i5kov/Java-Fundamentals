package lab_tasks;

import java.util.Scanner;

public class Lab12_EvenNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Math.abs(Integer.parseInt(scanner.nextLine()));

        while (inputNumber % 2 == 1) {
            System.out.println("Please write an even number.");
            inputNumber = Math.abs(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println("The number is: " + inputNumber);
    }
}
