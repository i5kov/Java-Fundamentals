package exercise_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise05_BombNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int[] specialNumberWithPower = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int specialBombNumber = specialNumberWithPower[0];
        int power = specialNumberWithPower[1];

        while (numbers.contains(specialBombNumber)) {
            int specialNumberIndex = numbers.indexOf(specialBombNumber);
            int left = Math.max(0, specialNumberIndex - power);
            int right = Math.min(numbers.size() - 1, specialNumberIndex + power);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }
        int sumOfElements = getSumOfElementsInList(numbers);
        System.out.println(sumOfElements);

    }

    private static int getSumOfElementsInList(List<Integer> list) {
        int sum = 0;
        for (Integer item : list) {
            sum += item;
        }
        return sum;
    }
}
