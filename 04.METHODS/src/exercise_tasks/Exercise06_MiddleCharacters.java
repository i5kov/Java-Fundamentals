package exercise_tasks;

import java.util.Scanner;

public class Exercise06_MiddleCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        printMiddleCharacter(word);
    }

    private static void printMiddleCharacter(String word) {
        int middleIndex = word.length() / 2;
        if (word.length() % 2 == 0) {
            System.out.printf("%c%c", word.charAt(middleIndex - 1), word.charAt(middleIndex));
        } else {
            System.out.println(word.charAt(middleIndex));
        }
    }
}
