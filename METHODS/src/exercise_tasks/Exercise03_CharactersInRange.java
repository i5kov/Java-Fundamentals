package exercise_tasks;

import java.util.Scanner;

public class Exercise03_CharactersInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        printCharactersBetweenChars(firstChar, secondChar);
    }

    private static void printCharactersBetweenChars(char firstChar, char secondChar) {
        int start = Math.min(firstChar, secondChar);
        int end = Math.max(firstChar, secondChar);

        for (int i = start + 1; i < end; i++) {
            System.out.printf("%c ", (char)i);
        }
    }
}
