package lab_tasks;

import java.util.Scanner;

public class Lab05_MonthPrinter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int monthNumber = Integer.parseInt(scanner.nextLine());

        String[] months = {
                "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"
        };

        if (monthNumber > 0 && monthNumber <= 12) {
            System.out.println(months[monthNumber - 1]);
        } else {
            System.out.println("Error!");
        }
    }
}
