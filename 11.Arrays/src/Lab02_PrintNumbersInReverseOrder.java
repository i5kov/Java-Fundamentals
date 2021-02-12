import java.util.Scanner;

public class Lab02_PrintNumbersInReverseOrder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[lines];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }
        printNumbersInReverseOrder(numbers);
    }

    private static void printNumbersInReverseOrder(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);
            if (i > 0) {
                System.out.print(" ");
            }
        }
    }
}
