package midexam_06;

import java.util.Arrays;
import java.util.Scanner;

public class Task03_ManOWar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] piratesShip = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int[] warsShip = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Retire")) {
            String[] tokens = command.split("\\s+");
            int index;
            int damage;

            switch (tokens[0]) {
                case "Fire":
                    index = Integer.parseInt(tokens[1]);
                    damage = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < warsShip.length) {
                        warsShip[index] -= damage;
                        if (warsShip[index] <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    damage = Integer.parseInt(tokens[3]);
                    if (startIndex >= 0 && startIndex < piratesShip.length && endIndex >= 0 && endIndex < piratesShip.length) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            piratesShip[i] -= damage;
                            if (piratesShip[i] <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    index = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < piratesShip.length) {
                        if (health + piratesShip[index] < maxHealthCapacity) {
                            piratesShip[index] += health;
                        } else {
                            piratesShip[index] = maxHealthCapacity;
                        }
                    }
                    break;
                case "Status":
                    int shipCount = 0;
                    for (int pirateShip : piratesShip) {
                        if (pirateShip < maxHealthCapacity * 0.2) {
                            shipCount++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", shipCount);
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.printf("Pirate ship status: %d%n", Arrays.stream(piratesShip).sum());
        System.out.printf("Warship status: %d%n", Arrays.stream(warsShip).sum());
    }
}
