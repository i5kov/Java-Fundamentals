package exercise_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise02_ChangeList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split("\\s+");
            int element = Integer.parseInt(command[1]);

            switch (command[0]) {
                case "Delete":
                    inputList.removeIf(currentElement -> currentElement == element);
                    break;
                case "Insert":
                    int position = Integer.parseInt(command[2]);
                    if (position < inputList.size()) {
                        inputList.add(position, element);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        inputList.forEach(element -> System.out.print(element + " "));
    }
}
