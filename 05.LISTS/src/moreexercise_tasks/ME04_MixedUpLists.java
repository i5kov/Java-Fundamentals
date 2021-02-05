package moreexercise_tasks;

import java.util.*;
import java.util.stream.Collectors;

public class ME04_MixedUpLists {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList =Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList =Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int end = Math.min(firstList.size(), secondList.size());
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < end; i++) {
            Integer firstListElement = firstList.get(0);
            Integer secondListElement = secondList.get(secondList.size() - 1);

            resultList.add(firstListElement);
            resultList.add(secondListElement);

            firstList.remove(firstListElement);
            secondList.remove(secondListElement);
        }
        List<Integer> listWithRemainingElements = firstList.size() > 0 ? firstList : secondList;
        listWithRemainingElements.sort(Comparator.naturalOrder());

        resultList.stream()
                .filter(element -> element > listWithRemainingElements.get(0) && element < listWithRemainingElements.get(1))
                .sorted(Comparator.naturalOrder())
                .forEach(element -> System.out.printf("%d ", element));
    }
}
