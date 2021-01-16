package moreexercise_tasks;

import java.util.Scanner;

public class ME05_MultiplicationSign {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int[] array = {num1, num2, num3};
        printSignAsText(array);
    }

    static void printSignAsText(int[] array) {
        boolean isPositive = false;

        for (int element : array) {
            if (element < 0) {
                System.out.println("negative");
                isPositive = false;
                break;
            } else if (element == 0) {
                System.out.println("zero");
                isPositive = false;
                break;
            } else {
                isPositive = true;
            }
        }
        if (isPositive) {
            System.out.println("positive");
        }
    }
}
