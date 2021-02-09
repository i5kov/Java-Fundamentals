package moreexercise_tasks;

import java.util.Scanner;

public class ME01_SortNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }
        int[] sortedArray = sortArrayInDescendingOrder(numbers);
        printElementsOfArray(sortedArray);
    }

    private static int[] sortArrayInDescendingOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    private static void printElementsOfArray(int[] array) {
        for (int arrayElement : array) {
            System.out.println(arrayElement);
        }
    }
}
