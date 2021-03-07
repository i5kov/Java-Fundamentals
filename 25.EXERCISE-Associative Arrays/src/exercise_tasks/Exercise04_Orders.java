package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise04_Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> productsQuantities = new LinkedHashMap<>();
        Map<String, Double> productsPrices = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] tokens = input.split("\\s+");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            productsQuantities.putIfAbsent(product, 0);
            productsQuantities.put(product, productsQuantities.get(product) + quantity);

            productsPrices.putIfAbsent(product, productsQuantities.get(product) * price);
            productsPrices.put(product, price * productsQuantities.get(product));

            input = scanner.nextLine();
        }

        productsPrices.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v));
    }
}
