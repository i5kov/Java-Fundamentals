import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab05_Largest3Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(3)
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
