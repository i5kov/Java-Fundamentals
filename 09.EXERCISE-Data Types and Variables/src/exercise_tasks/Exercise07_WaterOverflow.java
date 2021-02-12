package exercise_tasks;

import java.util.Scanner;

public class Exercise07_WaterOverflow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines= Integer.parseInt(scanner.nextLine());
        int waterTank = 255;
        int pouredWater = 0;

        for (int i = 0; i < numberOfLines; i++) {
            int litersOfWater = Integer.parseInt(scanner.nextLine());
            if (litersOfWater > waterTank) {
                System.out.println("Insufficient capacity!");
            } else {
                pouredWater += litersOfWater;
                waterTank -= litersOfWater;
            }
        }
        System.out.println(pouredWater);
    }
}
