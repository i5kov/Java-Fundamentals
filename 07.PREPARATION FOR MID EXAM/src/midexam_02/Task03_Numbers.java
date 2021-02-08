package midexam_02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task03_Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        double average = numbers.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .getAsDouble();

        numbers = numbers.stream()
                .filter(e -> e > average)
                .sorted((f, s) -> Integer.compare(s, f))
                .limit(5)
                .collect(Collectors.toList());

        if (numbers.size() < 1) {
            System.out.println("No");
        } else {
            numbers.forEach(e -> System.out.print(e + " "));
        }
    }
}
