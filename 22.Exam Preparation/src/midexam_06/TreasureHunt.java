package midexam_06;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> treasureChest = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] tokens = input.split("\\s+");


            switch (tokens[0]) {
                case "Loot":
                    for (int i = 1; i <= tokens.length - 1; i++) {
                        if (!treasureChest.contains(tokens[i])) {
                            treasureChest.add(0, tokens[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < treasureChest.size()) {
                        String loot = treasureChest.get(index);
                        treasureChest.remove(index);
                        treasureChest.add(loot);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    int countOfElementsForRemove = treasureChest.size() < count ? 0 : treasureChest.size() - count;
                    List<String> stolenItems = treasureChest.subList(countOfElementsForRemove, treasureChest.size());
                    for (int i = 0; i < stolenItems.size(); i++) {
                        System.out.print(stolenItems.get(i));
                        if (i < stolenItems.size() - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                    treasureChest.subList(countOfElementsForRemove, treasureChest.size()).clear();
                    break;
            }
            input = scanner.nextLine();
        }

        if (treasureChest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double averageGain = 0;
            for (String s : treasureChest) {
                averageGain += s.length();
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.", 1.0 * averageGain / treasureChest.size());
        }
    }
}
