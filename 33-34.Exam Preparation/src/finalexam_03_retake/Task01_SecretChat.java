package finalexam_03_retake;

import java.util.Scanner;

public class Task01_SecretChat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    message.insert(index, " ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substringForReverse = tokens[1];
                    if (message.toString().contains(substringForReverse)) {
                        int i = message.indexOf(substringForReverse);
                        String substring = message.substring(i, i + substringForReverse.length());
                        StringBuilder reversed = new StringBuilder(substring).reverse();
                        message.delete(i, i + substringForReverse.length());
                        message.append(reversed);
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    message = new StringBuilder(message.toString().replace(substring, replacement));
                    System.out.println(message);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s%n", message);
    }

}
