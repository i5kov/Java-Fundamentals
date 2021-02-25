package midexam_06;

import java.util.Scanner;

public class Task01_BlackFlag {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double gatheredPlunder = 0;

        for (int i = 1; i <= days; i++) {
            gatheredPlunder += dailyPlunder;
            if (i % 3 == 0) {
                double additionalPlunder = dailyPlunder * 0.5;
                gatheredPlunder += additionalPlunder;
            }
            if (i % 5 == 0) {
                gatheredPlunder -= gatheredPlunder * 0.3;
            }
        }

        if (gatheredPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", gatheredPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", (gatheredPlunder / expectedPlunder) * 100);
        }
    }
}
