package exercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise04_Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> prices = new LinkedHashMap<>();
        Map<String, Integer> quantities = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("buy")) {
            String[] tokens = command.split("\\s+");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            if (!quantities.containsKey(product)) {
                quantities.put(product, quantity);
                prices.put(product, price * quantity);
            } else {
                quantities.put(product, quantities.get(product) + quantity);
                prices.put(product, quantities.get(product) * price);
            }
            command = scanner.nextLine();
        }

        prices.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value));
    }
}
