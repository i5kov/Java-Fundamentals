package finalexam_04;

import java.util.Scanner;

public class Task01_PasswordReset {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder newRawPassword = new StringBuilder();

        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "TakeOdd":
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            newRawPassword.append(password.charAt(i));
                        }
                    }
                    password = newRawPassword.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);

                    String substringForRemove = password.substring(index, index + length);
                    password = password.replace(substringForRemove, "");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];

                    if (password.contains(substring)) {
                        password = password.replace(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}
