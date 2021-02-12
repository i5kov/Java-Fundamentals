import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab11_MathOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double secondNumber = Double.parseDouble(scanner.nextLine());
        double result = calculate(firstNumber, operator, secondNumber);
        System.out.println(new DecimalFormat("0.###").format(result));
    }

    private static double calculate(double firstNumber, String operator, double secondNumber) {
        switch (operator) {
            case "/":
                return firstNumber / secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            default:
                return 0.0;
        }
    }
}
