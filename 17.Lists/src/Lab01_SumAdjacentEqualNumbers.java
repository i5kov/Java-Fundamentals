import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab01_SumAdjacentEqualNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, (numbers.get(i) + numbers.get(i + 1)));
                numbers.remove(i + 1);
                i = -1;
            }
        }
        String result = joinElementsBySpaces(numbers);
        System.out.println(result);
    }

    private static String joinElementsBySpaces(List<Double> list) {
        StringBuilder output = new StringBuilder();
        for (Double item : list) {
            output.append(new DecimalFormat("0.# ").format(item));
        }
        return output.toString();
    }
}
