package midexam_01;

import java.util.Arrays;
import java.util.Scanner;

public class Task02_TheLift {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleWaitingForLift = Integer.parseInt(scanner.nextLine());
        int[] stateOfLift = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int maxPeopleInWagon = 4;

        for (int i = 0; i < stateOfLift.length; i++) {
            int currentWagon = stateOfLift[i];

            for (int j = currentWagon; j <= maxPeopleInWagon; j++) {
                if (stateOfLift[i] != maxPeopleInWagon) {
                    if (peopleWaitingForLift <= 0) {
                        break;
                    }
                    stateOfLift[i]++;
                    peopleWaitingForLift--;
                }
            }
        }
        if (peopleWaitingForLift > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaitingForLift);
        } else {
            boolean hasEmptySpots = Arrays.stream(stateOfLift).anyMatch(e -> e < 4);
            if (hasEmptySpots) {
                System.out.println("The lift has empty spots!");
            }
        }
        Arrays.stream(stateOfLift).forEach(e -> System.out.print(e + " "));
    }
}
