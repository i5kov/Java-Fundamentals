import java.util.Scanner;

public class Lab01_ConvertMetersToKilometers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int distanceInMeters = Integer.parseInt(scanner.nextLine());
        double distanceInKilometers = (distanceInMeters * 1.0) / 1000;
        System.out.printf("%.2f", distanceInKilometers);
    }
}
