package exercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise03_HouseParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandCount = Integer.parseInt(scanner.nextLine());
        List<String> guestList = new ArrayList<>();

        for (int i = 0; i < commandCount; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String guestName = command[0];

            if (command[2].equals("going!")) {
                if (!guestList.contains(guestName)) {
                    guestList.add(guestName);
                } else {
                    System.out.printf("%s is already in the list!%n", guestName);
                }
            } else if (command[2].equals("not")) {
                if (!guestList.contains(guestName)) {
                    System.out.printf("%s is not in the list!%n", guestName);
                } else {
                    guestList.remove(guestName);
                }
            }
        }
        guestList.forEach(System.out::println);
    }
}
