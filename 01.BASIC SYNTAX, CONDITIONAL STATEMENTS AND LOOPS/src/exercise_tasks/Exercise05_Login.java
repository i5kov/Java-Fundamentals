package exercise_tasks;

import java.util.Scanner;

public class Exercise05_Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        int count = 0;

        while (true) {
            password = new StringBuilder(password).reverse().toString();

            if (!username.equals(password)) {
                count++;
                if (count > 3) {
                    System.out.printf("User %s blocked!", username);
                    break;
                }
                System.out.println("Incorrect password. Try again.");
            }
            if (username.equals(password)) {
                System.out.printf("User %s logged in.%n", username);
                break;
            }
            password = scanner.nextLine();
        }
    }
}
