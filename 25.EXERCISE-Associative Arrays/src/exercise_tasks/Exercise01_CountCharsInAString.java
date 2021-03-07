package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise01_CountCharsInAString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll("\\s+", "");
        Map<Character, Integer> characterOccurrences = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            characterOccurrences.putIfAbsent(currentChar, 0);
            Integer countOfChar = characterOccurrences.get(currentChar) + 1;
            characterOccurrences.put(currentChar, countOfChar);
        }
        characterOccurrences.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
