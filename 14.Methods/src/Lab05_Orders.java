import java.util.Scanner;

public class Lab05_Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        printTotalPrice(product, quantity);
    }

    private static void printTotalPrice(String product, int quantity) {
        double productPrice = getProductPrice(product);
        System.out.printf("%.2f", productPrice * quantity);
    }

    private static double getProductPrice(String product) {
        switch (product) {
            case "coffee":
                return 1.50;
            case "water":
                return 1.00;
            case "coke":
                return 1.40;
            case "snacks":
                return 2.00;
            default:
                return 0.0;
        }
    }
}
