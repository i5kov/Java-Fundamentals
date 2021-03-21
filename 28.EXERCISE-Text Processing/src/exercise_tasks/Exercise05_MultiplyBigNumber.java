package exercise_tasks;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise05_MultiplyBigNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger firstNumber = new BigInteger(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        BigInteger result = firstNumber.multiply(BigInteger.valueOf(secondNumber));
        System.out.println(result);
    }
}