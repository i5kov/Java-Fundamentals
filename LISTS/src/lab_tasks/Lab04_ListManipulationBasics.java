package lab_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab04_ListManipulationBasics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "Add":
                    int numberForAdd = Integer.parseInt(command[1]);
                    numbers.add(numberForAdd);
                    break;
                case "Remove":
                    int numberForRemove = Integer.parseInt(command[1]);
                    numbers.remove((Integer)numberForRemove);
                    break;
                case "RemoveAt":
                    int index = Integer.parseInt(command[1]);
                    numbers.remove(index);
                    break;
                case "Insert":
                    int number = Integer.parseInt(command[1]);
                    int i = Integer.parseInt(command[2]);
                    numbers.add(i, number);
                    break;
            }
            input = scanner.nextLine();
        }
        numbers.forEach(element -> System.out.print(element + " "));
    }
}
