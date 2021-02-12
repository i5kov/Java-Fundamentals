package moreexercise_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME01_Messaging {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String text = scanner.nextLine();
        StringBuilder message = new StringBuilder();

        for (Integer number : numbers) {
            int sumOfDigits = getSumOfDigits(number);

            if (sumOfDigits > text.length()) {
                int index = sumOfDigits - text.length();
                char letter = text.charAt(index);
                message.append(letter);
                text = text.substring(0, index) + text.substring(index + 1);
            } else {
                char letter = text.charAt(sumOfDigits);
                message.append(letter);
                text = text.substring(0, sumOfDigits) + text.substring(sumOfDigits + 1);
            }
        }
        System.out.println(message.toString());

    }

    private static int getSumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }
}