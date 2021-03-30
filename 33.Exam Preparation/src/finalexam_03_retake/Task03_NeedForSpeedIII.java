package finalexam_03_retake;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task03_NeedForSpeedIII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        Map<String, int[]> cars = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\|");
            String car = carInfo[0];
            int mileage = Integer.parseInt(carInfo[1]);
            int fuel = Integer.parseInt(carInfo[2]);

            int[] mileageAndFuel = new int[]{mileage, fuel};
            cars.putIfAbsent(car, mileageAndFuel);
        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];
            String car = tokens[1];

            int currentFuel = cars.get(car)[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    if (fuel > currentFuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        cars.get(car)[0] += distance;
                        cars.get(car)[1] -= fuel;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);

                        if (cars.get(car)[0] >= 100000) {
                            cars.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    }
                    break;
                case "Refuel":
                    int tankCapacity = 75;
                    int fuelToRefuel = Integer.parseInt(tokens[2]);

                    int totalFuel = currentFuel + fuelToRefuel;
                    if (totalFuel >= tankCapacity) {
                        totalFuel = tankCapacity;
                    }
                    cars.get(car)[1] = totalFuel;
                    System.out.printf("%s refueled with %d liters%n", car, totalFuel - currentFuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    int currentMileage = cars.get(car)[0];
                    currentMileage -= kilometers;

                    if (currentMileage < 10000) {
                        cars.get(car)[0] = 10000;
                    } else {
                        cars.get(car)[0] = currentMileage;
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        cars.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(s.getValue()[0], f.getValue()[0]);
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getKey(), e.getValue()[0], e.getValue()[1]));
    }
}
