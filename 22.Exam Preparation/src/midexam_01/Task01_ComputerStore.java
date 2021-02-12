package midexam_01;

import java.util.Scanner;

public class Task01_ComputerStore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalPriceWithoutTaxes = 0;
        String type;

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("special") || input.equals("regular")) {
                type = input;
                break;
            }
            double inputPrice = Double.parseDouble(input);
            if (inputPrice < 0) {
                System.out.println("Invalid price!");
            } else {
                totalPriceWithoutTaxes += inputPrice;
            }
        }
        double taxes = totalPriceWithoutTaxes * 0.2;
        double totalPrice = totalPriceWithoutTaxes + taxes;

        if (totalPriceWithoutTaxes <= 0) {
            System.out.println("Invalid order!");
        } else {
            if (type.equals("special")) {
                totalPrice -= totalPrice * 0.1;
            }
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalPriceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", totalPrice);
        }
    }
}
