package lab_tasks;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab08_MathPower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputNumber = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        System.out.println(new DecimalFormat("0.####").format(mathPower(inputNumber, power)));
    }

    private static double mathPower(double number, int power) {
        double result = 1;

        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }
}
