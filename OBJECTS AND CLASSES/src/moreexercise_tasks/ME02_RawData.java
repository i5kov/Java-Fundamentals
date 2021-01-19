package moreexercise_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ME02_RawData {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> allCars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] infoCar = scanner.nextLine().split("\\s+");
            String model = infoCar[0];
            int engineSpeed = Integer.parseInt(infoCar[1]);
            int enginePower = Integer.parseInt(infoCar[2]);
            int cargoWeight = Integer.parseInt(infoCar[3]);
            String cargoType = infoCar[4];
            double tire1Pressure = Double.parseDouble(infoCar[5]);
            int tire1Age = Integer.parseInt(infoCar[6]);
            double tire2Pressure = Double.parseDouble(infoCar[7]);
            int tire2Age = Integer.parseInt(infoCar[8]);
            double tire3Pressure = Double.parseDouble(infoCar[9]);
            int tire3Age = Integer.parseInt(infoCar[10]);
            double tire4Pressure = Double.parseDouble(infoCar[11]);
            int tire4Age = Integer.parseInt(infoCar[12]);

            List<Double> tirePressures = Arrays.asList(tire1Pressure, tire2Pressure, tire3Pressure, tire4Pressure);
            List<Integer> tireAges = Arrays.asList(tire1Age, tire2Age, tire3Age, tire4Age);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire = new Tire(tirePressures, tireAges);

            allCars.add(new Car(model, engine, cargo, tire));
        }
        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                allCars.stream()
                        .filter(car -> car.getCargo().getType().equals(command))
                        .filter(car -> car.getTire().getTyrePressure() < 1)
                        .forEach(car -> System.out.println(car.getModel()));
                break;
            case "flamable":
                allCars.stream()
                        .filter(car -> car.getCargo().getType().equals(command))
                        .filter(car -> car.getEngine().getPower() > 250)
                        .forEach(car -> System.out.println(car.getModel()));
                break;
        }
    }
}

class Car {

    String model;
    Engine engine;
    Cargo cargo;
    Tire tire;

    public Car(String model, Engine engine, Cargo cargo, Tire tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public String getModel() {
        return model;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire getTire() {
        return tire;
    }

    public Engine getEngine() {
        return engine;
    }
}

class Engine {

    int speed;
    int power;

    public Engine(int engineSpeed, int enginePower) {
        this.speed = engineSpeed;
        this.power = enginePower;
    }

    public int getPower() {
        return power;
    }
}

class Cargo {

    int weight;
    String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Tire {

    List<Double> tirePressures;
    List<Integer> tireAges;

    public Tire(List<Double> tirePressures, List<Integer> tireAges) {
        this.tirePressures = tirePressures;
        this.tireAges = tireAges;
    }

    public int getTyrePressure() {
        int averagePressure = 0;
        for (Double tirePressure : tirePressures) {
            averagePressure += tirePressure;
        }
        return averagePressure / tirePressures.size();
    }
}