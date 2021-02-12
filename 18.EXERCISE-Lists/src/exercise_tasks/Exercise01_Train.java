package exercise_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise01_Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int capacityOfWagons = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split("\\s+");

            if (command[0].equals("Add")) {
                wagons.add(Integer.parseInt(command[1]));
            } else {
                int morePassengers = Integer.parseInt(command[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int currentWagon = wagons.get(i);
                    if (currentWagon + morePassengers <= capacityOfWagons) {
                        wagons.set(i, currentWagon + morePassengers);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        wagons.forEach(element -> System.out.print(element + " "));
    }
}
