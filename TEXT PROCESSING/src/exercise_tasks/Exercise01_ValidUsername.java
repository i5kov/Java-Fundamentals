package exercise_tasks;

import java.util.Scanner;

public class Exercise01_ValidUsername {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValidUsername(String username) {
        return isCorrectLength(username) && isContainsCorrectCharacters(username);
    }

    private static boolean isCorrectLength(String username) {
        return username.length() > 3 && username.length() < 16;
    }

    private static boolean isContainsCorrectCharacters(String username) {
        for (int i = 0; i < username.length(); i++) {
            char symbol = username.charAt(i);
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }
        }
        return true;
    }
}
