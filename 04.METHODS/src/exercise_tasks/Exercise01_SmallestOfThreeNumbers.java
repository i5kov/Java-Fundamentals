package exercise_tasks;

import java.util.Scanner;

public class Exercise01_SmallestOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        printSmallestNumber(firstNum, secondNum, thirdNum);
    }

    private static void printSmallestNumber(int firstNum, int secondNum, int thirdNum) {
        System.out.println(Math.min(Math.min(firstNum, secondNum), thirdNum));
    }
}
