import java.util.Scanner;

public class Exercise06_StrongNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        int numberForCheck = inputNumber;
        int sumFactorial = 0;

        while (numberForCheck > 0) {
            int factorial = 1;
            int lastDigit = numberForCheck % 10;

            for (int i = 1; i <= lastDigit; i++) {
                factorial *= i;
            }
            sumFactorial += factorial;
            numberForCheck /= 10;
        }
        String result = sumFactorial == inputNumber ? "yes" : "no";
        System.out.println(result);
    }
}
