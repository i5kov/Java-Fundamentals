package moreexercise_tasks;

import java.util.Scanner;

public class ME03_LongerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        double lineOneLen = calculateDistance(x1, y1, x2, y2);
        double lineTwoLen = calculateDistance(x3, y3, x4, y4);

        if (lineOneLen >= lineTwoLen) {
            if (calculateDistance(x1, y1) <= calculateDistance(x2, y2)) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)%n", x1, y1, x2, y2);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)%n", x2, y2, x1, y1);
            }
        } else {
            if (calculateDistance(x3, y3) <= calculateDistance(x4, y4)) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)%n", x3, y3, x4, y4);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x4, y4, x3, y3);
            }
        }
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2d) + Math.pow((y2 - y1), 2d));
    }

    private static double calculateDistance(double x1, double y1) {
        return Math.sqrt(Math.pow((0 - x1), 2d) + Math.pow((0 - y1), 2d));
    }
}
