package moreexercise_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class ME03_TreasureFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] keys = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("find")) {
            String currentText = input;

            int maxLength = Math.max(keys.length, currentText.length());
            StringBuilder stringBuilder = new StringBuilder(maxLength);
            for (int i = 0; i < maxLength; i++) {
                stringBuilder.append((char) (currentText.charAt(i) - keys[i % keys.length]));
            }
            String foundedResource = getDataFromTextBetweenTwoSpecificSymbols(stringBuilder.toString(), "&", "&");
            String coordinates = getDataFromTextBetweenTwoSpecificSymbols(stringBuilder.toString(), "<", ">");
            System.out.printf("Found %s at %s%n", foundedResource, coordinates);
            input = scanner.nextLine();
        }
    }

    private static String getDataFromTextBetweenTwoSpecificSymbols(String text, String firstSymbol, String secondSymbol) {
        int firstIndex = text.indexOf(firstSymbol) + 1;
        int lastIndex = text.lastIndexOf(secondSymbol);
        return text.substring(firstIndex, lastIndex);
    }
}
