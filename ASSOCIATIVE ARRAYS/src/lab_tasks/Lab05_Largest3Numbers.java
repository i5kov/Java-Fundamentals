package lab_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Lab05_Largest3Numbers {

    public static void main(String[] args) {
        Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(3)
                .forEach(n -> System.out.print(n + " "));
    }
}
