package lab_tasks;

import java.util.Scanner;

public class Lab12_RefactorSpecialNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int num;
        String result;
        boolean isSpecialNum;

        for (int i = 1; i <= n; i++) {
            num = i;

            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            isSpecialNum = (sum == 5) || (sum == 7) || (sum == 11);
            result = isSpecialNum ? "True" : "False";
            System.out.printf("%d -> %s%n", num, result);
            sum = 0;
            i = num;
        }
    }
}
