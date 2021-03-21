package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise06_ReplaceRepeatingChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] characters = scanner.nextLine().toCharArray();
        List<Character> chars = new ArrayList<>();

        for (char c : characters) {
            chars.add(c);
        }

        for (int i = 1; i < chars.size(); i++) {
            Character current = chars.get(i);
            Character previous = chars.get(i - 1);

            if (current == previous) {
                chars.remove(i);
                i--;
            }
        }
        chars.forEach(System.out::print);
    }
}