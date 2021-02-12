package midexam_04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task02_ShoppingList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String item = tokens[1];

            switch (command) {
                case "Urgent":
                    addItemAtTheStart(shoppingList, item);
                    break;
                case "Unnecessary":
                    removeItem(shoppingList, item);
                    break;
                case "Correct":
                    String newItem = tokens[2];
                    changeItemName(shoppingList, item, newItem);
                    break;
                case "Rearrange":
                    putItemAtTheEnd(shoppingList, item);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", shoppingList));
    }

    private static void addItemAtTheStart(List<String> list, String item) {
        int firstPosition = 0;
        if (!isItemExist(list, item)) {
            list.add(firstPosition, item);
        }
    }

    private static void removeItem(List<String> list, String item) {
        list.remove(item);
    }

    private static void changeItemName(List<String> list, String oldItem, String newItem) {
        if (isItemExist(list, oldItem)) {
            int positionOfOldItem = list.indexOf(oldItem);
            list.set(positionOfOldItem, newItem);
        }
    }

    private static void putItemAtTheEnd(List<String> list, String item) {
        if (isItemExist(list, item)) {
            list.remove(item);
            list.add(item);
        }
    }

    private static boolean isItemExist(List<String> list, String item) {
        return list.contains(item);
    }
}
