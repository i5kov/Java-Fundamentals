package midexam_03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task03_MovingTarget {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int index = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Shoot":
                    int power = Integer.parseInt(tokens[2]);
                    if (isValidIndexInList(numbers, index)) {
                        numbers.set(index, numbers.get(index) - power);
                        if (numbers.get(index) <= 0) {
                            numbers.remove(numbers.get(index));
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(tokens[2]);
                    if (isValidIndexInList(numbers, index)) {
                        numbers.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(tokens[2]);
                    int itemBeforeStrikeIndex = index - radius;
                    int itemAfterStrikeIndex = index + radius;

                    if (itemBeforeStrikeIndex >= 0 && itemAfterStrikeIndex < numbers.size()) {
                        numbers.subList(itemBeforeStrikeIndex, itemAfterStrikeIndex + 1).clear();
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        printElementsOfListSeparatedBySlash(numbers);
    }

    private static boolean isValidIndexInList(List<Integer> list, int index) {
        return index < list.size();
    }

    private static void printElementsOfListSeparatedBySlash(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print("|");
            }
        }
    }
}
