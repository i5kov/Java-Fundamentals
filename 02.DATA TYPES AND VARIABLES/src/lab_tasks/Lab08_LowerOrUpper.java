package lab_tasks;

import java.util.Scanner;

public class Lab08_LowerOrUpper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char inputChar = scanner.nextLine().charAt(0);
        String upperOrLowerCase = Character.isUpperCase(inputChar) ? "upper-case" : "lower-case";
        System.out.println(upperOrLowerCase);
    }
}
