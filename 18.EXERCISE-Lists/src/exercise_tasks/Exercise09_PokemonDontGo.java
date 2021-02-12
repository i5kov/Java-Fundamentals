package exercise_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise09_PokemonDontGo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> distances = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sumOfRemovedElements = 0;

        while (distances.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            int removedElement;

            if (index < 0) {
                removedElement = distances.get(0);
                distances.remove(0);
                distances.add(0, distances.get(distances.size() - 1));
            } else if (index > distances.size() - 1) {
                removedElement = distances.get(distances.size() - 1);
                distances.remove(distances.size() - 1);
                distances.add(distances.get(0));
            } else {
                removedElement = distances.get(index);
                distances.remove(index);
            }
            sumOfRemovedElements += removedElement;

            for (int i = 0; i < distances.size(); i++) {
                int currentElement = distances.get(i);
                if (currentElement <= removedElement) {
                    distances.set(i, currentElement + removedElement);
                } else {
                    distances.set(i, currentElement - removedElement);
                }
            }
        }
        System.out.println(sumOfRemovedElements);
    }
}
