import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double experience = Double.parseDouble(scanner.nextLine());
        int countOfBattles = Integer.parseInt(scanner.nextLine());

        double total = 0;
        int battleCount = 0;

        for (int i = 1; i <= countOfBattles; i++) {
            double earnedExperience = Double.parseDouble(scanner.nextLine());
            total += earnedExperience;

            if (i % 3 == 0) {
                double moreExperience = earnedExperience * 0.15;
                total += moreExperience;
            }
            if (i % 5 == 0) {
                double lessExperience = earnedExperience * 0.1;
                total -= lessExperience;
            }
            if (total >= experience) {
                battleCount = i;
                break;
            }
        }

        if (total >= experience) {
            System.out.printf("Player successfully collected his needed experience for %d battles.%n", battleCount);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", experience - total);
        }
    }
}
