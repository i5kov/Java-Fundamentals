package moreexercise_tasks;

import java.util.Scanner;

public class ME04_RefactoringPrimeChecker {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int inputNumber = Integer.parseInt(sca.nextLine());

        for (int i = 2; i <= inputNumber; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, isPrime);
        }
    }
}
