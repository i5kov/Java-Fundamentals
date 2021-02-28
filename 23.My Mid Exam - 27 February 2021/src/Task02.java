import java.util.*;
import java.util.stream.Collectors;

public class Task02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbersAsString = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "reverse":
                    int reverseStart = Integer.parseInt(tokens[2]);
                    int reverseCount = Integer.parseInt(tokens[4]);
                    List<String> elementsForReverse = getElementsFromSpecificPosition(reverseStart, reverseCount, numbersAsString);
                    Collections.reverse(elementsForReverse);
                    setSpecificElementFromListInAnotherList(reverseStart, reverseCount, numbersAsString, elementsForReverse);

                    break;
                case "sort":
                    int sortStart = Integer.parseInt(tokens[2]);
                    int sortCount = Integer.parseInt(tokens[4]);
                    List<String> elementsForSort = getElementsFromSpecificPosition(sortStart, sortCount, numbersAsString);
                    Collections.sort(elementsForSort);
                    setSpecificElementFromListInAnotherList(sortStart, sortCount, numbersAsString, elementsForSort);
                    break;
                case "remove":
                    int countForRemove = Integer.parseInt(tokens[1]);
                    removeFirstCountElements(numbersAsString, countForRemove);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", numbersAsString));
    }

    private static void setSpecificElementFromListInAnotherList(int startFrom, int countOfElements, List<String> numbers, List<String> specificElements) {
        int count = 0;
        for (int i = startFrom; i <= startFrom + countOfElements - 1; i++) {
            numbers.set(i, specificElements.get(count));
            count++;
        }
    }

    private static List<String> getElementsFromSpecificPosition(int startFrom, int countOfElements, List<String> list) {
        List<String> elements = new ArrayList<>();
        for (int i = startFrom; i <= startFrom + countOfElements - 1; i++) {
            elements.add(list.get(i));
        }
        return elements;
    }

    private static void removeFirstCountElements(List<String> list, int firstCountElements) {
        if (firstCountElements > 0) {
            list.subList(0, firstCountElements).clear();
        }
    }
}
