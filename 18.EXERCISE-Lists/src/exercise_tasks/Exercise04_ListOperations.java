package exercise_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise04_ListOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    if (isValidIndexInList(numbers, index)) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.add(index, Integer.parseInt(command[1]));
                    }
                    break;
                case "Remove":
                    int i = Integer.parseInt(command[1]);
                    if (isValidIndexInList(numbers, i)) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(i);
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(command[2]);
                    if (command[1].equals("left")) {
                        for (int j = 0; j < count; j++) {
                            int firstNumber = numbers.get(0);
                            numbers.add(firstNumber);
                            numbers.remove(0);
                        }
                    } else if (command[1].equals("right")) {
                        for (int j = 0; j < count; j++) {
                            int lastNumber = numbers.get(numbers.size() - 1);
                            numbers.add(0, lastNumber);
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        numbers.forEach(element -> System.out.print(element + " "));
    }

    private static boolean isValidIndexInList(List<Integer> list, int index) {
        return index < 0 || index >= list.size();
    }
}
