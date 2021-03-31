package finalexam_05;

import java.util.Scanner;

public class Task01_ActivationKeys {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String activationKey = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    String substring = tokens[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = tokens[1];
                    int indexStart = Integer.parseInt(tokens[2]);
                    int indexEnd = Integer.parseInt(tokens[3]);

                    String textForChange = activationKey.substring(indexStart, indexEnd);

                    if (upperOrLower.equals("Upper")) {
                        activationKey = activationKey.replace(textForChange, textForChange.toUpperCase());
                    } else {
                        activationKey = activationKey.replace(textForChange, textForChange.toLowerCase());
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    activationKey = new StringBuilder(activationKey).delete(startIndex, endIndex).toString();
                    System.out.println(activationKey);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}
