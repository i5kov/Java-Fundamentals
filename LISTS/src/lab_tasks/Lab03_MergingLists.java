package lab_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab03_MergingLists {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();
        int longestList = Math.max(firstList.size(), secondList.size());

        for (int i = 0; i < longestList; i++) {
            if (i < firstList.size()) {
                resultList.add(firstList.get(i));
            }
            if (i < secondList.size()) {
                resultList.add(secondList.get(i));
            }
        }
        resultList.forEach(element -> System.out.print(element + " "));
    }
}
