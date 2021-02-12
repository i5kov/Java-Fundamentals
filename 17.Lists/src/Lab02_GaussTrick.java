import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab02_GaussTrick {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        int middleElement = numbers.get(numbers.size() / 2);

        for (int i = 0; i < numbers.size() / 2; i++) {
            int firstElement = numbers.get(i);
            int lastElement = numbers.get(numbers.size() - 1 - i);
            result.add(firstElement + lastElement);
        }
        if (numbers.size() % 2 == 1) {
            result.add(middleElement);
        }
        result.forEach(element -> System.out.print(element + " "));
    }
}
