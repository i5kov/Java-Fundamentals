package midexam_02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task02_ArrayModifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (!command.equals("decrease")) {
                int index1 = Integer.parseInt(tokens[1]);
                int index2 = Integer.parseInt(tokens[2]);

                if (command.equals("swap")) {
                    swap(numbers, index1, index2);
                } else if (command.equals("multiply")) {
                    numbers[index1] = numbers[index1] * numbers[index2];
                }
            } else {
                decreaseAllElementsBy1InArray(numbers);
            }
            input = scanner.nextLine();
        }
        printElementsOfArraySeparatedByComma(numbers);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printElementsOfArraySeparatedByComma(int[] array) {
        String output = Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(output);
    }

    private static void decreaseAllElementsBy1InArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]--;
        }
    }
}
