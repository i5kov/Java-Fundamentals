package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise01_CountCharsInAString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll("\\s+", "");
        Map<Character, Integer> charOccurrences = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            Integer occurrence = charOccurrences.get(input.charAt(i));
            if (occurrence == null) {
                occurrence = 0;
            }
            charOccurrences.put(input.charAt(i), occurrence + 1);
        }

        for (Map.Entry<Character, Integer> entry : charOccurrences.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
