package moreexercise_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ME04_MorseCodeTranslator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] morseCode = scanner.nextLine().split("\\|");
        StringBuilder stringBuilder = new StringBuilder();


        for (String code : morseCode) {
            char space = code.charAt(code.length() - 1);
            String[] split = code.split("\\s+");

            for (String s : split) {
                if (!s.equals("")) {
                    String letter = getLetterEqualsToMorseCodeSymbol(s);
                    stringBuilder.append(letter);
                }
            }
            stringBuilder.append(space);
        }
        System.out.println(stringBuilder.toString().replace(".", ""));
    }

    private static String getLetterEqualsToMorseCodeSymbol(String morseCodeSymbol) {
        Map<String, String> lettersMorseCode = new HashMap<>();
        lettersMorseCode.put(".-", "A");
        lettersMorseCode.put("-...", "B");
        lettersMorseCode.put("-.-.", "C");
        lettersMorseCode.put("-..", "D");
        lettersMorseCode.put(".", "E");
        lettersMorseCode.put("..-.", "F");
        lettersMorseCode.put("--.", "G");
        lettersMorseCode.put("....", "H");
        lettersMorseCode.put("..", "I");
        lettersMorseCode.put(".---", "J");
        lettersMorseCode.put("-.-", "K");
        lettersMorseCode.put(".-..", "L");
        lettersMorseCode.put("--", "M");
        lettersMorseCode.put("-.", "N");
        lettersMorseCode.put("---", "O");
        lettersMorseCode.put(".--.", "P");
        lettersMorseCode.put("--.-", "Q");
        lettersMorseCode.put(".-.", "R");
        lettersMorseCode.put("...", "S");
        lettersMorseCode.put("-", "T");
        lettersMorseCode.put("..-", "U");
        lettersMorseCode.put("...-", "V");
        lettersMorseCode.put(".--", "W");
        lettersMorseCode.put("-..-", "X");
        lettersMorseCode.put("-.--", "Y");
        lettersMorseCode.put("--..", "Z");
        return lettersMorseCode.get(morseCodeSymbol);
    }
}
