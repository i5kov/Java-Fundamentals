package lab_tasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab07_RemoveNegativesAndReverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listWithPositiveNumbers = numbers.stream().filter(element -> element >= 0).collect(Collectors.toList());

        if (listWithPositiveNumbers.isEmpty()) {
            System.out.println("empty");
        } else {
            Collections.reverse(listWithPositiveNumbers);
            listWithPositiveNumbers.forEach(element -> System.out.print(element + " "));
        }
    }
}
