package lab_tasks;

import java.math.BigInteger;
import java.util.Scanner;

public class Lab03_BigFactorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= inputNumber; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
    }
}
