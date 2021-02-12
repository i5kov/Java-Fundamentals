package midexam_03;

import java.util.Arrays;
import java.util.Scanner;

public class Task02_ShootForTheWin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int shotTargets = 0;

        while (!input.equals("End")) {
            int index = Integer.parseInt(input);

            if (index >= 0 && index < arr.length) {
                int currentTarget = arr[index];
                if (arr[index] != -1) {
                    arr[index] = -1;
                    shotTargets++;

                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] != -1) {
                            if (arr[i] > currentTarget) {
                                arr[i] -= currentTarget;
                            } else if (arr[i] <= currentTarget) {
                                arr[i] += currentTarget;
                            }
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", shotTargets);
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
