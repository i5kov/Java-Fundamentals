package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise01_Furniture {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String regex = ">>(?<furniture>[A-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        double totalMoney = 0;
        List<String> furnitures = new ArrayList<>();

        while (!command.equals("Purchase")) {
            String inputLine = command;

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputLine);

            if (matcher.find()) {
                String furniture = matcher.group(1);
                double price = Double.parseDouble(matcher.group(2));
                int quantity = Integer.parseInt(matcher.group(3));

                furnitures.add(furniture);
                totalMoney += price * quantity;
            }

            command = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furnitures.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalMoney);
    }
}
