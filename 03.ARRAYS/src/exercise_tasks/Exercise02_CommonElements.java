package exercise_tasks;

import java.util.Scanner;

public class Exercise02_CommonElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArray = scanner.nextLine().split("\\s+");
        String[] secondArray = scanner.nextLine().split("\\s+");

        for (String currentElementInSecondArr : secondArray) {
            for (String currentElementInFirstArr : firstArray) {
                if (currentElementInSecondArr.equals(currentElementInFirstArr)) {
                    System.out.printf("%s ", currentElementInSecondArr);
                }
            }
        }
    }
}
