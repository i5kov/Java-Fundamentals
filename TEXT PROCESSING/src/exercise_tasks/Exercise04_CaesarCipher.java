package exercise_tasks;

import java.util.Scanner;

public class Exercise04_CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int code = text.charAt(i) + 3;
            encrypted.append((char)code);
        }
        System.out.println(encrypted.toString());
    }
}
