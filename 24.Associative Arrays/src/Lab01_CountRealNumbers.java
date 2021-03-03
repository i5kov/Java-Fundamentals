import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab01_CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numsAsString = scanner.nextLine().split("\\s+");

        Map<Double, Integer> occurrences = new TreeMap<>();
        for (String numAsString : numsAsString) {
            double number = Double.parseDouble(numAsString);

            if (occurrences.containsKey(number)) {
                Integer foundInt = occurrences.get(number);
                occurrences.put(number, foundInt + 1);
            } else {
                occurrences.put(number, 1);
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%s -> %d%n", decimalFormat.format(entry.getKey()), entry.getValue());
        }
    }
}
