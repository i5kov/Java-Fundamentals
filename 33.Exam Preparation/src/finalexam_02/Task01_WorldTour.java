package finalexam_02;

import java.util.Scanner;

public class Task01_WorldTour {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stops = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String text = tokens[2];

                    if (index >= 0 && index < stops.length()) {
                        stops.insert(index, text);
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && startIndex < stops.length() && endIndex >= 0 && endIndex < stops.length()) {
                        stops.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    if (contains(stops, oldString)) {
                        stops = new StringBuilder(stops.toString().replace(oldString, newString));
                    }
                    System.out.println(stops);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", stops);
    }

    private static boolean contains(StringBuilder sb, String textForCheck) {
        String str = sb.toString();
        return str.contains(textForCheck);
    }
}
