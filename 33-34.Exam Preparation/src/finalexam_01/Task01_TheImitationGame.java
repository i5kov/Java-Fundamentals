package finalexam_01;

import java.util.Scanner;

public class Task01_TheImitationGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder encryptedMessage = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    String firstNLetters = encryptedMessage.substring(0, numberOfLetters);
                    encryptedMessage.delete(0, numberOfLetters);
                    encryptedMessage.append(firstNLetters);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    encryptedMessage.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    String text = encryptedMessage.toString();
                    text = text.replace(substring, replacement);
                    encryptedMessage = new StringBuilder(text);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n", encryptedMessage.toString());
    }
}
