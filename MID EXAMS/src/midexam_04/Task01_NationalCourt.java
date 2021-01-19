package midexam_04;

import java.util.Scanner;

public class Task01_NationalCourt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int peopleCount = Integer.parseInt(scanner.nextLine());
        int peopleLeft = peopleCount;

        int peoplePerHours = firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency;
        int hours = 0;

        for (int i = 1; i < peopleCount; i++) {
            if (peopleLeft <= 0) {
                break;
            }
            if (i % 4 != 0) {
                peopleLeft -= peoplePerHours;
            }
            hours++;
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
