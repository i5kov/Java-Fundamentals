package exercise_tasks;

import java.util.Scanner;

public class Exercise02_CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        char[] arrOne = input[0].toCharArray();
        char[] arrTwo = input[1].toCharArray();

        int shorterArr = Math.min(arrOne.length, arrTwo.length);
        int sum = 0;

        for (int i = 0; i < shorterArr; i++) {
            sum += arrOne[i] * arrTwo[i];
        }
        int longerArr = Math.max(arrOne.length, arrTwo.length);
        char[] finalElements = longerArr == arrOne.length ? arrOne : arrTwo;
        for (int i = longerArr - 1; i >= shorterArr; i--) {
            sum += finalElements[i];
        }
        System.out.println(sum);
    }


}
