package midexam_05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task03_Inventory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String item = tokens[1];

            switch (command) {
                case "Collect":
                    collectItem(items, item);
                    break;
                case "Drop":
                    dropItem(items, item);
                    break;
                case "Combine Items":
                    String oldItem = item.split(":")[0];
                    String newItem = item.split(":")[1];
                    combineItems(items, oldItem, newItem);
                    break;
                case "Renew":
                    renewItem(items, item);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", items));
    }

    private static void renewItem(List<String> list, String item) {
        if (isItemExist(list, item)) {
            list.remove(item);
            list.add(item);
        }
    }

    private static void combineItems(List<String> list, String oldItem, String newItem) {
        if (isItemExist(list, oldItem)) {
            int itemIndex = list.indexOf(oldItem);
            list.add(itemIndex + 1, newItem);
        }
    }

    private static void dropItem(List<String> list, String item) {
        list.remove(item);
    }

    private static void collectItem(List<String> list, String item) {
        if (!isItemExist(list, item)) {
            list.add(item);
        }
    }

    private static boolean isItemExist(List<String> list, String item) {
        return list.contains(item);
    }


}
