package midexam_03;

import java.util.Scanner;

public class Task01_CounterStrike {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int wonBattles = 0;
        boolean isGameOver = false;

        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);

            if (initialEnergy >= distance) {
                initialEnergy -= distance;
                wonBattles++;
                if (wonBattles % 3 == 0) {
                    initialEnergy += wonBattles;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", wonBattles, initialEnergy);
                isGameOver = true;
                break;
            }
            input = scanner.nextLine();
        }

        if (!isGameOver) {
            System.out.printf("Won battles: %d. Energy left: %d%n", wonBattles, initialEnergy);
        }
    }
}
