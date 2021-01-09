package exercise_tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise11_ArrayManipulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        String evenOrOdd = "";

        while (!command.equals("end")) {
            String[] token = command.split("\\s+");

            if (token[0].equals("max") || token[0].equals("min")) {
                evenOrOdd = token[1].equals("even") ? "even" : "odd";
            }

            switch (token[0]) {
                case "exchange":
                    int index = Integer.parseInt(token[1]);
                    if (index < 0 || index >= numbers.length) {
                        System.out.println("Invalid index");
                    } else {
                        int[] exchange = exchange(numbers, index);
                        System.out.println(Arrays.toString(exchange));
                    }
                    break;
                case "max":
                    int maxIndex = getMaxIndex(numbers, evenOrOdd);
                    if (maxIndex >= 0) {
                        System.out.println(maxIndex);
                    } else {
                        System.out.println("No matches");
                    }
                    break;
                case "min":
                    int minIndex = getMinIndex(numbers, evenOrOdd);
                    System.out.println(minIndex);
                    if (minIndex >= 0) {
                        System.out.println(minIndex);
                    } else {
                        System.out.println("No matches");
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(token[1]);
                    if (count > numbers.length) {
                        System.out.println("Invalid count");
                    } else {
                        getFirstCountOfElements(numbers, count);
                    }
                    break;
            }



            command = scanner.nextLine();
        }
    }

    private static int[] exchange(int[] array, int index) {
        int[] newArray = new int[array.length];
        int position = 0;
        for (int i = index + 1; i < array.length; i++) {
            newArray[position] = array[i];
            position++;
        }
        for (int i = 0; i <= index; i++) {
            newArray[position] = array[i];
            position++;
        }
        return newArray;
    }

    private static int getMaxIndex(int[] array, String oddOrEven) {
        int maxElement = Integer.MIN_VALUE;
        int indexOfMaxElement = -1;

        switch (oddOrEven) {
            case "even":
                for (int i = 0; i < array.length; i++) {
                    if (array[i] % 2 == 0) {
                        if (array[i] > maxElement) {
                            maxElement = array[i];
                            indexOfMaxElement = i;
                        }
                    }
                }
                break;
            case "odd":
                for (int i = 0; i < array.length; i++) {
                    if (array[i] % 2 == 1) {
                        if (array[i] >= maxElement) {
                            maxElement = array[i];
                            indexOfMaxElement = i;
                        }
                    }
                }
                break;
        }
        return indexOfMaxElement;
    }

    private static int getMinIndex(int[] array, String oddOrEven) {
        int minElement = Integer.MAX_VALUE;
        int indexOfMinElement = -1;

        switch (oddOrEven) {
            case "even":
                for (int i = 0; i < array.length; i++) {
                    if (array[i] % 2 == 0) {
                        if (array[i] <= minElement) {
                            minElement = array[i];
                            indexOfMinElement = i;
                        }
                    }
                }
                break;
            case "odd":
                for (int i = 0; i < array.length; i++) {
                    if (array[i] % 2 == 1) {
                        if (array[i] <= minElement) {
                            minElement = array[i];
                            indexOfMinElement = i;
                        }
                    }
                }
                break;
        }
        return indexOfMinElement;
    }

    private static void getFirstCountOfElements(int[] numbers, int count) {
        int[] firstCountElements = new int[count];
        int position = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                firstCountElements[position] = number;
                position++;
            }
        }
        System.out.println(Arrays.toString(firstCountElements));
    }


}
