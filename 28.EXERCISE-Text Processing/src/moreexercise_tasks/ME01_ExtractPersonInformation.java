package moreexercise_tasks;

import java.util.Scanner;

public class ME01_ExtractPersonInformation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String text = scanner.nextLine();
            String name = getDataFromTextBetweenTwoSpecificSymbols(text, "@", "|");
            String age = getDataFromTextBetweenTwoSpecificSymbols(text, "#", "*");
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }

    private static String getDataFromTextBetweenTwoSpecificSymbols(String text, String firstSymbol, String secondSymbol) {
        int firstSymbolIndex = text.indexOf(firstSymbol) + 1;
        int secondSymbolText = text.indexOf(secondSymbol);
        return text.substring(firstSymbolIndex, secondSymbolText);
    }
}
