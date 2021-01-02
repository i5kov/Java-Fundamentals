package exercise_tasks;

import java.util.Scanner;

public class Exercise09_PadawanEquipment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightsabersPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        double lightSwords = Math.ceil(studentsCount * 1.1) * lightsabersPrice;
        double robes = robesPrice * studentsCount;
        int freeBelts = studentsCount / 6;
        double belts = (studentsCount - freeBelts) * beltsPrice;
        double totalPrice = lightSwords + robes + belts;

        if (totalPrice <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", totalPrice - money);
        }
    }
}
