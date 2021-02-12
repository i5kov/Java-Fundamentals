package moreexercise_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME05_DrumSet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> quality = new ArrayList<>(drumSet);
        String command;

        while (!"Hit it again, Gabsy!".equals(command = scanner.nextLine())) {
            int currentPower = Integer.parseInt(command);

            for (int i = 0; i < drumSet.size(); i++) {
                drumSet.set(i, drumSet.get(i) - currentPower);
            }
            for (int i = 0; i < drumSet.size(); i++) {
                if (drumSet.get(i) <= 0) {
                    if (savings - (quality.get(i) * 3) > 0) {
                        drumSet.set(i, quality.get(i));
                        savings -= (quality.get(i) * 3);
                    } else {
                        drumSet.remove(i);
                        quality.remove(i);
                    }
                }
            }
        }

        for (Integer drum : drumSet) {
            System.out.print(drum + " ");
        }
        System.out.println();

        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
