package exercise_tasks;

import java.util.Scanner;

public class Exercise02_VowelsCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        printVowelsCount(text);
    }

    private static void printVowelsCount(String text) {
        System.out.println(getVowelsCount(text));
    }

    private static int getVowelsCount(String text) {
        int vowelsCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (isVowel(currentChar)) {
                vowelsCount++;
            }
        }
        return vowelsCount;
    }

    private static boolean isVowel(char letter) {
        char[] vowels = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        boolean isVowel = false;

        for (char vowel : vowels) {
            if (letter == vowel) {
                isVowel = true;
                break;
            }
        }
        return isVowel;
    }
}
