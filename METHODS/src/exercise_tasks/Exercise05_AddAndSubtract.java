package exercise_tasks;

import java.util.Scanner;

public class Exercise05_AddAndSubtract {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
//        int result = subtract(firstNum, secondNum, thirdNum);
        System.out.println(result);
    }

    private static int getSum(int number, int anotherNumber) {
        return number + anotherNumber;
    }


}
