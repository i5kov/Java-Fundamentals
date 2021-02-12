import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab05_ListManipulationAdvanced {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "Contains":
                    int numberForCheck = Integer.parseInt(command[1]);
                    printWhetherListContainNumber(inputList, numberForCheck);
                    break;
                case "Print":
                    String oddOrEvenNumbers = command[1];
                    printAllNumbers(inputList, oddOrEvenNumbers);
                    break;
                case "Get":
                    int sumOfAllElements = getSumOfAllElements(inputList);
                    System.out.println(sumOfAllElements);
                    break;
                case "Filter":
                    String condition = command[1];
                    int number = Integer.parseInt(command[2]);
                    printAllNumbersBasedOnCondition(inputList, condition, number);
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static void printWhetherListContainNumber(List<Integer> list, int numberForCheck) {
        if (list.contains(numberForCheck)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }

    private static void printAllNumbers(List<Integer> list, String evenOrOddNumbers) {
        switch (evenOrOddNumbers) {
            case "even":
                list.stream().filter(element -> element % 2 == 0).forEach(element -> System.out.print(element + " "));
                System.out.println();
                break;
            case "odd":
                list.stream().filter(element -> element % 2 != 0).forEach(element -> System.out.print(element + " "));
                System.out.println();
                break;
        }
    }

    private static int getSumOfAllElements(List<Integer> list) {
        int sum = 0;
        for (Integer item : list) {
            sum += item;
        }
        return sum;
    }

    private static void printAllNumbersBasedOnCondition(List<Integer> list, String condition, int number) {
        switch (condition) {
            case "<":
                list.stream().filter(element -> element < number).forEach(element -> System.out.print(element + " "));
                System.out.println();
                break;
            case ">":
                list.stream().filter(element -> element > number).forEach(element -> System.out.print(element + " "));
                System.out.println();
                break;
            case ">=":
                list.stream().filter(element -> element >= number).forEach(element -> System.out.print(element + " "));
                System.out.println();
                break;
            case "<=":
                list.stream().filter(element -> element <= number).forEach(element -> System.out.print(element + " "));
                System.out.println();
                break;
        }
    }
}
