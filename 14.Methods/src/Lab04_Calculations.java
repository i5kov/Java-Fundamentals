import java.util.Scanner;

public class Lab04_Calculations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        printResultFromOperation(operation, firstNumber, secondNumber);
    }

    private static void printResultFromOperation(String operation, int firstNum, int secondNum) {
        switch (operation) {
            case "add":
                add(firstNum, secondNum);
                break;
            case "multiply":
                multiply(firstNum, secondNum);
                break;
            case "subtract":
                subtract(firstNum, secondNum);
                break;
            case "divide":
                divide(firstNum, secondNum);
                break;
        }
    }

    private static void divide(int firstNum, int secondNum) {
        System.out.println(firstNum / secondNum);
    }

    private static void subtract(int firstNum, int secondNum) {
        System.out.println(firstNum - secondNum);
    }

    private static void multiply(int firstNum, int secondNum) {
        System.out.println(firstNum * secondNum);
    }

    private static void add(int firstNum, int secondNum) {
        System.out.println(firstNum + secondNum);
    }
}
