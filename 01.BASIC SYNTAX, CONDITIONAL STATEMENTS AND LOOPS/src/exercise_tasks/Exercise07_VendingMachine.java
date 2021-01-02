package exercise_tasks;

import java.util.Scanner;

public class Exercise07_VendingMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double totalMoney = 0;

        while (!command.equals("Start")) {
            double coins = Double.parseDouble(command);

            if (isValidCoin(coins)) {
                totalMoney += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }
            command = scanner.nextLine();
        }

        String product = scanner.nextLine();
        while (!product.equals("End")) {
            if (isValidProduct(product)) {
                double currentProductPrice = productPrice(product);
                if (totalMoney >= currentProductPrice) {
                    System.out.printf("Purchased %s%n", product);
                    totalMoney -= currentProductPrice;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else {
                System.out.println("Invalid product");
            }
            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f%n", totalMoney);
    }

    private static boolean isValidCoin(double coins) {
        return coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2;
    }

    private static boolean isValidProduct(String product) {
        return product.equals("Nuts") || product.equals("Water") || product.equals("Crisps") || product.equals("Soda") || product.equals("Coke");
    }

    private static double productPrice(String product) {
        double price = 0;
        switch (product) {
            case "Nuts":
                price = 2.0;
                break;
            case "Water":
                price = 0.7;
                break;
            case "Crisps":
                price = 1.5;
                break;
            case "Soda":
                price = 0.8;
                break;
            case "Coke":
                price = 1.0;
                break;
        }
        return price;
    }

}
