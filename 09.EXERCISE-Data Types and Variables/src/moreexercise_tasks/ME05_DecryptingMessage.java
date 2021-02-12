package moreexercise_tasks;

import java.util.Scanner;

public class ME05_DecryptingMessage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int numberOfCharacters = Integer.parseInt(scanner.nextLine());

        StringBuilder message = new StringBuilder();

        for (int i = 0; i < numberOfCharacters; i++) {
            char currentCharacter = scanner.nextLine().charAt(0);
            int charCode = currentCharacter + key;
            message.append((char)charCode);
        }
        System.out.println(message.toString());
    }
}
