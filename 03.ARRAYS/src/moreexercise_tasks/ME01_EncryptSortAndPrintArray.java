package moreexercise_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class ME01_EncryptSortAndPrintArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int encryptCode = 0;
        int[] encryptedCodes = new int[lines];

        for (int i = 0; i < lines; i++) {
            String input = scanner.nextLine();

            for (int j = 0; j < input.length(); j++) {
                char letter = input.charAt(j);

                if (isVowel(letter)) {
                    encryptCode = encryptCode + ((int)letter * input.length());
                } else {
                    encryptCode = encryptCode + ((int)letter / input.length());
                }
            }
            encryptedCodes[i] = encryptCode;
            encryptCode = 0;
        }
        Arrays.sort(encryptedCodes);
        for (int code : encryptedCodes) {
            System.out.println(code);
        }
    }

    private static boolean isVowel(char letter) {
        char[] vowels = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        
        for (char vowel : vowels) {
            if (vowel == letter) {
                return true;
            }
        }
        return false;
    }
}
