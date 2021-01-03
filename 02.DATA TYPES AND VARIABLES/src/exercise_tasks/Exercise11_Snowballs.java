package exercise_tasks;

import java.util.Scanner;

public class Exercise11_Snowballs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSnowballs= Integer.parseInt(scanner.nextLine());
        double highestSnowballValue = 0;
        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;

        for (int i = 0; i < numberOfSnowballs; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double currentSnowballValue = Math.pow(((double)snowballSnow / snowballTime), snowballQuality);

            if (currentSnowballValue > highestSnowballValue) {
                highestSnowballValue = currentSnowballValue;
                bestSnowballSnow = snowballSnow;
                bestSnowballTime = snowballTime;
                bestSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", bestSnowballSnow, bestSnowballTime, highestSnowballValue, bestSnowballQuality);
    }
}
