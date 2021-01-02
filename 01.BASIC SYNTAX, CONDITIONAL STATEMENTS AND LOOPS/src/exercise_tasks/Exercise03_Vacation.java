package exercise_tasks;

import java.util.Scanner;

public class Exercise03_Vacation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;

        switch (groupType.toLowerCase()) {
            case "students":
                if (day.equalsIgnoreCase("friday")) {
                    price = peopleCount * 8.45;
                } else if (day.equalsIgnoreCase("saturday")) {
                    price = peopleCount * 9.80;
                } else if (day.equalsIgnoreCase("sunday")) {
                    price = peopleCount * 10.46;
                }
                if (peopleCount >= 30) {
                    price -= price * 0.15;
                }
                break;
            case "business":
                if (peopleCount >= 100) {
                    peopleCount -= 10;
                }
                if (day.equalsIgnoreCase("friday")) {
                    price = peopleCount * 10.90;
                } else if (day.equalsIgnoreCase("saturday")) {
                    price = peopleCount * 15.60;
                } else if (day.equalsIgnoreCase("sunday")) {
                    price = peopleCount * 16;
                }
                break;
            case "regular":
                if (day.equalsIgnoreCase("friday")) {
                    price = peopleCount * 15;
                } else if (day.equalsIgnoreCase("saturday")) {
                    price = peopleCount * 20;
                } else if (day.equalsIgnoreCase("sunday")) {
                    price = peopleCount * 22.50;
                }
                if (peopleCount >= 10 && peopleCount <= 20) {
                    price -= price * 0.05;
                }
                break;
        }
        System.out.printf("Total price: %.2f%n", price);
    }
}
