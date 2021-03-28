package finalexam_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02_AdAstra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String regex = "([\\|#])(?<food>[A-z\\s]+)\\1[0-9]{2}\\/[0-9]{2}\\/[0-9]{2}\\1(?<calories>\\d{1,5})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int totalCalories = 0;
        List<String> foods = new ArrayList<>();

        while (matcher.find()) {
            String group = matcher.group();
            int calories = Integer.parseInt(matcher.group("calories"));
            totalCalories += calories;

            foods.add(group);
        }

        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        for (String food: foods) {
            String[] splitFood = food.substring(1).split("[#\\|]");
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", splitFood[0], splitFood[1], splitFood[2]);
        }
    }
}
