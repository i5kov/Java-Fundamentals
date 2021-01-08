package exercise_tasks;

import java.util.Scanner;

public class Exercise04_PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        printPasswordValidOrNot(password);
    }

    private static void printPasswordValidOrNot(String password) {
        int wrongPasswordCount = 0;
        if (!isValidLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
            wrongPasswordCount++;
        }
        if (!isConsistOnlyLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
            wrongPasswordCount++;
        }
        if (!isHasAtLeastTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
            wrongPasswordCount++;
        }
        if (wrongPasswordCount < 1) {
            System.out.println("Password is valid");
        }
    }

    private static boolean isValidLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    private static boolean isConsistOnlyLettersAndDigits(String password) {
        boolean isLetterOrDigit = true;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (!(Character.isDigit(currentChar) || Character.isLetter(currentChar))) {
                isLetterOrDigit = false;
                break;
            }
        }
        return isLetterOrDigit;
    }

    private static boolean isHasAtLeastTwoDigits(String password) {
        int digitsCount = 0;
        boolean isHasTwoDigits = false;

        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (Character.isDigit(currentChar)) {
                digitsCount++;
                if (digitsCount >= 2) {
                    isHasTwoDigits = true;
                    break;
                }
            }
        }
        return isHasTwoDigits;
    }
}
