package moreexercise_tasks;

import java.util.Scanner;

public class ME02_AsciiSumator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstCharacter = scanner.nextLine().charAt(0);
        char secondCharacter = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();
        int sumOfCharacters = 0;


        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.charAt(i);

            if (currentCharacter > firstCharacter && currentCharacter < secondCharacter) {
                sumOfCharacters += currentCharacter;
            }
        }
        System.out.println(sumOfCharacters);
    }
}
