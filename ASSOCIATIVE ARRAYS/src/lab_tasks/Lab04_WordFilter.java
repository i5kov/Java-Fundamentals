package lab_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Lab04_WordFilter {

    public static void main(String[] args) {
        Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .filter(w -> w.length() % 2 == 0)
                .forEach(System.out::println);
    }
}
