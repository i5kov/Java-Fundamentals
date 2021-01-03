package exercise_tasks;

import java.util.Scanner;

public class Exercise10_PokeMon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int pokedTarget = 0;
        double half = pokePower / 2.0;

        while (pokePower >= distance) {
            pokedTarget++;
            pokePower -= distance;

            if (half == pokePower) {
                if (exhaustionFactor > 0) {
                    pokePower /= exhaustionFactor;
                }
            }
        }
        System.out.println(pokePower);
        System.out.println(pokedTarget);
    }
}
