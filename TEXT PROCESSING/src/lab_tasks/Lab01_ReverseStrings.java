package lab_tasks;

import java.util.Scanner;

public class Lab01_ReverseStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String word = input;
            String reversedWord = getReversedString(word);
            System.out.printf("%s = %s%n", word, reversedWord);
            input = scanner.nextLine();
        }
    }

    private static String getReversedString(String word) {
        StringBuilder reversed = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed.append(word.charAt(i));
        }
        return reversed.toString();
    }
}
