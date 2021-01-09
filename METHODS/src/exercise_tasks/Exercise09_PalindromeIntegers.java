package exercise_tasks;

import java.util.Scanner;

public class Exercise09_PalindromeIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!command.equals("END")) {
            int number = Integer.parseInt(command);
            boolean isPalindrome = isPalindrome(number);
            System.out.println(isPalindrome);
            command = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(int number) {
        int temp = number;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum = (sum * 10) + digit;
            number /= 10;
        }
        return sum == temp;
    }
}
