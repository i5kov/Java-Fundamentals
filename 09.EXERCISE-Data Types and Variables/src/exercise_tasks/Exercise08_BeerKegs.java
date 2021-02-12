package exercise_tasks;

import java.util.Scanner;

public class Exercise08_BeerKegs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        String biggestKegModel = "";
        double biggestKegVolume = 0;

        for (int i = 0; i < lines; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double currentKegVolume = Math.PI * Math.pow(radius, 2) * height;

            if (currentKegVolume > biggestKegVolume) {
                biggestKegVolume = currentKegVolume;
                biggestKegModel = model;
            }
        }
        System.out.println(biggestKegModel);
    }
}
