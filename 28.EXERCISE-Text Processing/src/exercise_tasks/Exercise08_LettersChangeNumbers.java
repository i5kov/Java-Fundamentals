package exercise_tasks;

import java.util.Scanner;

public class Exercise08_LettersChangeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        double result = 0;

        for (String currentValue : input) {
            char letterBeforeNumber = getLetterBeforeNumber(currentValue);
            int number = getNumberFromText(currentValue);
            char letterAfterNumber = getLetterAfterNumber(currentValue);

            if (Character.isUpperCase(letterBeforeNumber)) {
                result += number * 1.0 / getPositionOfLetterInAlphabet(Character.toLowerCase(letterBeforeNumber));
            } else {
                result += number * getPositionOfLetterInAlphabet(Character.toLowerCase(letterBeforeNumber));
            }

            if (Character.isUpperCase(letterAfterNumber)) {
                result -= getPositionOfLetterInAlphabet(Character.toLowerCase(letterAfterNumber));
            } else {
                result += getPositionOfLetterInAlphabet(Character.toLowerCase(letterAfterNumber));
            }
        }
        System.out.printf("%.2f", result);
    }


    private static int getPositionOfLetterInAlphabet(char letter) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        return letters.indexOf(letter) + 1;
    }

    private static int getNumberFromText(String text) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                number.append(text.charAt(i));
            }
        }
        return Integer.parseInt(number.toString());
    }

    private static char getLetterBeforeNumber(String text) {
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                break;
            } else {
                index = i;
            }
        }
        return text.substring(0, index + 1).charAt(0);
    }

    private static char getLetterAfterNumber(String text) {
        int numberFromText = getNumberFromText(text);
        int lastDigit = numberFromText % 10;
        int index = text.lastIndexOf(String.valueOf(lastDigit));
        return text.substring(index + 1).charAt(0);
    }
}
