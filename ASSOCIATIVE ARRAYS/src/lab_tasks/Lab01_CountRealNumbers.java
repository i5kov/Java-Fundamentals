package lab_tasks;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Lab01_CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
        Map<Double, Integer> numberOccurrences = new TreeMap<>();

        for (Double number : numbers) {
            Integer numberOccurrence = numberOccurrences.get(number);
            if (numberOccurrence == null) {
                numberOccurrence = 0;
            }
            numberOccurrences.put(number, numberOccurrence + 1);
        }
        for (Map.Entry<Double, Integer> entry : numberOccurrences.entrySet()) {
            DecimalFormat decimalFormat = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", decimalFormat.format(entry.getKey()), entry.getValue());
        }

    }
}
