package midexam_04;

import java.util.Arrays;
import java.util.Scanner;

public class Task03_HeartDelivery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] neighborhood = Arrays.stream(scanner.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int start = 0;
        int currentPosition = 0;

        while (!input.equals("Love!")) {
            int jumpLength = Integer.parseInt(input.split("\\s+")[1]);

            if (jumpLength + currentPosition < neighborhood.length) {
                neighborhood[jumpLength + currentPosition] -= 2;
                currentPosition += jumpLength;
            } else {
                neighborhood[start] -= 2;
                currentPosition = 0;
            }

            if (neighborhood[currentPosition] == 0) {
                System.out.printf("Place %d has Valentine's day.%n", currentPosition);
            } else if (neighborhood[currentPosition] < 0) {
                System.out.printf("Place %d already had Valentine's day.%n", currentPosition);
            }
            input = scanner.nextLine();
        }
        int failedPlaces = 0;
        for (int item : neighborhood) {
            if (item > 0) {
                failedPlaces++;
            }
        }
        System.out.printf("Cupid's last position was %d.%n", currentPosition);
        if (failedPlaces > 0) {
            System.out.printf("Cupid has failed %d places.", failedPlaces);
        } else {
            System.out.println("Mission was successful.");
        }
    }
}
