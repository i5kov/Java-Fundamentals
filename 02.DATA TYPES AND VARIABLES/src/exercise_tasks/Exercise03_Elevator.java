package exercise_tasks;

import java.util.Scanner;

public class Exercise03_Elevator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int courses = (int)Math.ceil((double)numberPeople / capacity);
        System.out.println(courses);
    }
}
