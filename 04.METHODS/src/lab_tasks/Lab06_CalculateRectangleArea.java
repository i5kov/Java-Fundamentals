package lab_tasks;

import java.util.Scanner;

public class Lab06_CalculateRectangleArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double rectangleArea = getRectangleArea(width, height);
        System.out.printf("%.0f", rectangleArea);
    }

    private static double getRectangleArea(double width, double height) {
        return width * height;
    }
}
