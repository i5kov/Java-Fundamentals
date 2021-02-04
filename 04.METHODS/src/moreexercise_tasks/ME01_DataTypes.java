package moreexercise_tasks;

import java.util.Scanner;

public class ME01_DataTypes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "int":
                int intResult = getResult(Integer.parseInt(scanner.nextLine()));
                System.out.println(intResult);
                break;
            case "real":
                double doubleResult = getResult(Double.parseDouble(scanner.nextLine()));
                System.out.printf("%.2f%n", doubleResult);
                break;
            case "string":
                String stringResult = getResult(scanner.nextLine());
                System.out.println(stringResult);
                break;
        }
    }

    private static int getResult(int number) {
        return number * 2;
    }

    private static double getResult(double number) {
        return number * 1.5;
    }

    private static String getResult(String input) {
        return String.format("$%s$", input);
    }

}
