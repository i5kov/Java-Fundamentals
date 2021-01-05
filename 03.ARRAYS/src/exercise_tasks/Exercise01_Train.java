package exercise_tasks;

import java.util.Scanner;

public class Exercise01_Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagons = Integer.parseInt(scanner.nextLine());
        int[] train = new int[wagons];
        int peopleInTrain = 0;

        for (int wagon = 0; wagon < wagons; wagon++) {
            int peopleInWagon = Integer.parseInt(scanner.nextLine());
            train[wagon] = peopleInWagon;
            peopleInTrain += peopleInWagon;
        }
        for (int peopleInWagon : train) {
            System.out.printf("%d ", peopleInWagon);
        }
        System.out.printf("%n%d", peopleInTrain);
    }
}
