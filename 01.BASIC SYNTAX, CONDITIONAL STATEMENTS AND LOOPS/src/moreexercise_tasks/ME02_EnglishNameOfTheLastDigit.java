package moreexercise_tasks;

import java.util.Scanner;

public class ME02_EnglishNameOfTheLastDigit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        String englishNameOfLastDigit = getEnglishNameOfLastDigit(inputNumber);
        System.out.println(englishNameOfLastDigit);
    }

    private static String getEnglishNameOfLastDigit(int number) {
        int digit = getLastDigitOfNumber(number);
        String[] digitsAsText = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        return digitsAsText[digit];
    }

    private static int getLastDigitOfNumber(int number) {
        return number % 10;
    }
}
