package moreexercise_tasks;

import java.util.Scanner;

public class ME05_Messages {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersCount = Integer.parseInt(scanner.nextLine());
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < numbersCount; i++) {
            String digit = scanner.nextLine();
            int digitLength = digit.length();
            int mainDigit = Character.getNumericValue(digit.charAt(0));
            int offset = (mainDigit - 2) * 3;

            if (mainDigit == 8 || mainDigit == 9) {
                offset++;
            }
            int letterIndex = offset + digitLength - 1;
            int letterCode = letterIndex + 97;
            char letter = (char)letterCode;
            if (mainDigit == 0) {
                letter = (char) (mainDigit + 32);
            }
            message.append(letter);
        }
        System.out.println(message.toString());
    }
}
