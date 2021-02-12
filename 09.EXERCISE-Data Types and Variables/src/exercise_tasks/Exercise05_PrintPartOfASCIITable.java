package exercise_tasks;

import java.util.Scanner;

public class Exercise05_PrintPartOfASCIITable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());

        for (int i = startNumber; i <= endNumber; i++) {
            System.out.printf("%c ", (char)i);
        }
    }
}
