package moreexercise_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ME03_GamingStore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentBalance = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        double totalSpent = 0;

        while (!command.equals("Game Time")) {
            String gameForBuying = command;

            if (!isValidGame(gameForBuying)) {
                System.out.println("Not Found");
            } else {
                double priceOfGame = getPriceOfGame(gameForBuying);
                if (priceOfGame > currentBalance) {
                    System.out.println("Too Expensive");
                } else {
                    System.out.printf("Bought %s%n", gameForBuying);
                    totalSpent += priceOfGame;
                    currentBalance -= priceOfGame;
                    if (currentBalance <= 0) {
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }

        if (currentBalance <= 0) {
            System.out.println("Out of money!");
        } else {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f%n", totalSpent, currentBalance);
        }
    }

    private static boolean isValidGame(String game) {
        String[] games  = {"OutFall 4", "CS: OG", "Zplinter Zell", "Honored 2", "RoverWatch", "RoverWatch Origins Edition"};
        for (String currentGame : games) {
            if (currentGame.equals(game)) {
                return true;
            }
        }
        return false;
    }

    private static double getPriceOfGame(String game) {
        Map<String, Double> gameAndPrice = new HashMap<>();
        gameAndPrice.put("OutFall 4", 39.99);
        gameAndPrice.put("CS: OG", 15.99);
        gameAndPrice.put("Zplinter Zell", 19.99);
        gameAndPrice.put("Honored 2", 59.99);
        gameAndPrice.put("RoverWatch", 29.99);
        gameAndPrice.put("RoverWatch Origins Edition", 39.99);
        return gameAndPrice.get(game);
    }
}
