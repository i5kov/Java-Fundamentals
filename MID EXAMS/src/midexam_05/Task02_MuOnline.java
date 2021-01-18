package midexam_05;

import java.util.Scanner;

public class Task02_MuOnline {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialHealth = 100;
        int initialBitcoins = 0;
        String[] rooms = scanner.nextLine().split("\\|");

        for (int i = 0; i < rooms.length; i++) {
            String[] tokens = rooms[i].split("\\s+");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            switch (command) {
                case "potion":
                    if (initialHealth < 100) {
                        if (number + initialHealth > 100) {
                            int healthForAdd = 100 - initialHealth;
                            initialHealth += healthForAdd;
                            number = healthForAdd;
                        } else {
                            initialHealth += number;
                        }
                        System.out.printf("You healed for %d hp.%n", number);
                        System.out.printf("Current health: %d hp.%n", initialHealth);
                    }
                    break;
                case "chest":
                    initialBitcoins += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    break;
                default:
                    if (initialHealth >= 0) {
                        initialHealth -= number;
                        if (initialHealth <= 0) {
                            System.out.printf("You died! Killed by %s.%n", command);
                            System.out.printf("Best room: %d", i + 1);
                            return;
                        }
                        else {
                            System.out.printf("You slayed %s.%n", command);
                        }
                    }
                    break;
            }
        }
        if (initialHealth > 0) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", initialBitcoins);
            System.out.printf("Health: %d", initialHealth);
        }
    }
}
