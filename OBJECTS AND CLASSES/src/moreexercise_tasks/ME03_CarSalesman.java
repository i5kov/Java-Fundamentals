package moreexercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME03_CarSalesman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        List<EngineTest> allEngines = new ArrayList<>();
        List<CarTest> allCars = new ArrayList<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] engineInfo = scanner.nextLine().split("\\s+");
            String model = engineInfo[0];
            int power = Integer.parseInt(engineInfo[1]);

            EngineTest engine = new EngineTest(model, power);

            switch (engineInfo.length) {
                case 3:
                    if (Character.isLetter(engineInfo[2].charAt(0))) {
                        engine.setEfficiency(engineInfo[2]);
                    } else {
                        engine.setDisplacement(Integer.parseInt(engineInfo[2]));
                    }
                    break;
                case 4:
                    engine.setDisplacement(Integer.parseInt(engineInfo[2]));
                    engine.setEfficiency(engineInfo[3]);
                    break;
            }
            allEngines.add(engine);
        }
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            String engineModel = carInfo[1];
            EngineTest existingEngine = allEngines.stream()
                    .filter(engine -> engine.getModel().equals(engineModel))
                    .collect(Collectors.toList()).get(0);
            CarTest car = new CarTest(model, existingEngine);

            switch (carInfo.length) {
                case 3:
                    if (Character.isDigit(carInfo[2].charAt(0))) {
                        car.setWeight(Integer.parseInt(carInfo[2]));
                    } else {
                        car.setColor(carInfo[2]);
                    }
                    break;
                case 4:
                    car.setWeight(Integer.parseInt(carInfo[2]));
                    car.setColor(carInfo[3]);
            }
            allCars.add(car);
        }

        for (CarTest car : allCars) {
            System.out.println(car.toString());
        }
    }
}

class CarTest {

    private String model;
    private EngineTest engine;
    private int weight;
    private String color;

    public CarTest(String model, EngineTest engine) {
        setModel(model);
        setEngine(engine);
        setWeight(-1);
        setColor("n/a");
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(EngineTest engine) {
        this.engine = engine;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {

        String displacement = engine.getDisplacement() < 0 ? "n/a" : "" + engine.getDisplacement();
        String weight =  getWeight() < 0 ? "n/a" : "" + getWeight();

        return model + ":" + "\n" +
                engine.getModel() + ":" + "\n" +
                "Power: " + engine.getPower() + "\n" +
                "Displacement: " + displacement + "\n" +
                "Efficiency: " + engine.getEfficiency() + "\n" +
                "Weight: " + weight  + "\n" +
                "Color: " + getColor();
    }
}

class EngineTest {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public EngineTest(String model, int power) {
        setModel(model);
        setPower(power);
        setDisplacement(-1);
        setEfficiency("n/a");
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
