package exercise_tasks;

import java.util.Scanner;

public class Exercise09_SpiceMustFlow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int crewConsumation = 26;
        int days = 0;
        int totalSpices = 0;

        if (startingYield >= 100) {
            while (startingYield >= 100) {
                totalSpices += startingYield - crewConsumation;
                startingYield -= 10;
                days++;
            }
            totalSpices -= 26;
        }
        System.out.println(days);
        System.out.println(totalSpices);
    }
}
