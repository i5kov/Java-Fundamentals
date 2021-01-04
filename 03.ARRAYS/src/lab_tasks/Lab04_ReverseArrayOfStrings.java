package lab_tasks;

import java.util.Scanner;

public class Lab04_ReverseArrayOfStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length / 2; i++) {
            String firstElement = input[i];
            String lastElement = input[input.length - 1 - i];

            input[i] = lastElement;
            input[input.length - 1 - i] = firstElement;
        }
        System.out.println(String.join(" ", input));
    }
}
