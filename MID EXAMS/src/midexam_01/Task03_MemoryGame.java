package midexam_01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task03_MemoryGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();
        int moves = 1;

        while (!input.equals("end")) {
            String[] indexes = input.split("\\s+");
            int firstIndex = Integer.parseInt(indexes[0]);
            int secondIndex = Integer.parseInt(indexes[1]);
            boolean indexesAreEqual = areIndexedEquals(firstIndex, secondIndex);
            boolean indexesAreValid = areIndexesValidInList(elements, firstIndex, secondIndex);

            if (!(indexesAreEqual || indexesAreValid)) {
                addTwoElementsInMiddle(elements, "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                if (elements.get(firstIndex).equals(elements.get(secondIndex))) {
                    String elementForRemove = elements.get(firstIndex);
                    deleteAllElementsInListBasedOnIndex(elements, firstIndex);
                    System.out.printf("Congrats! You have found matching elements - %s!%n", elementForRemove);
                } else {
                    System.out.println("Try again!");
                }
            }
            if (elements.size() <= 0) {
                System.out.printf("You have won in %d turns!", moves);
                break;
            }
            input = scanner.nextLine();
            moves++;
        }

        if (elements.size() > 0) {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", elements));
        }
    }

    public static boolean areIndexesValidInList(List<String> list, int indexA, int indexB) {
        return (indexA >= 0 && indexA < list.size()) && (indexB >= 0 && indexB < list.size());
    }

    public static void addTwoElementsInMiddle(List<String> list, String elementForAdd) {
        int middle = list.size() / 2;
        list.add(middle, elementForAdd);
        list.add(middle, elementForAdd);
    }

    private static void deleteAllElementsInListBasedOnIndex(List<String> list, int index) {
        list.removeIf(x -> x.equals(list.get(index)));
    }

    private static boolean areIndexedEquals(int indexA, int indexB) {
        return indexA == indexB;
    }
}
