package exercise_task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise06_VehicleCatalogue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        while (!input.equals("End")) {
            String[] vehicleInfo = input.split("\\s+");
            String typeOfVehicle = vehicleInfo[0];
            String model = vehicleInfo[1];
            String color = vehicleInfo[2];
            double horsePower = Double.parseDouble(vehicleInfo[3]);

            vehicles.add(new Vehicle(typeOfVehicle, model, color, horsePower));
            input = scanner.nextLine();
        }
        String model = scanner.nextLine();
        while (!model.equals("Close the Catalogue")) {
            String currentModel = model;
            vehicles.stream()
                    .filter(vehicle -> vehicle.getVehicleModel().equals(currentModel))
                    .forEach(vehicle -> System.out.println(vehicle.toString()));

            model = scanner.nextLine();
        }
        double averageHpCars = getAverage(vehicles.stream().filter(vehicle -> vehicle.getType().equals("Car")).collect(Collectors.toList()));
        double averageHpTrucks = getAverage(vehicles.stream().filter(vehicle -> vehicle.getType().equals("Truck")).collect(Collectors.toList()));

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHpCars);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageHpTrucks);
    }

    private static double getAverage(List<Vehicle> vehicles) {
        double sum = 0;
        if (vehicles.size() == 0) {
            return 0;
        }
        for (Vehicle vehicle : vehicles) {
            sum += vehicle.getHorsePower();
        }
        return sum / vehicles.size();
    }
}

class Vehicle {

    String type;
    String vehicleModel;
    String color;
    double horsePower;

    public Vehicle(String type, String model, String color, double horsePower) {
        this.type = type;
        this.vehicleModel = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public String getType() {
        return type.substring(0, 1).toUpperCase() + type.substring(1);
    }

    @Override
    public String toString() {
        return "Type: " + getType() + "\n" +
                "Model: " + vehicleModel + "\n" +
                "Color: " + color + "\n" +
                "Horsepower: " + String.format("%.0f", horsePower);
    }
}