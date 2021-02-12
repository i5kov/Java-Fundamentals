package midexam_02;

import java.util.Scanner;

public class Task01_SoftUniReception {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int studentsLeft = studentsCount;
        int total = firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency;
        int hours = 0;

        for (int i = 1; i < studentsCount; i++) {
            if (studentsLeft <= 0) {
                break;
            }
            if (i % 4 != 0) {
                studentsLeft -= total;
            }
            hours++;
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
