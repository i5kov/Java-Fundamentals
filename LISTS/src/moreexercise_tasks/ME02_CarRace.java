package moreexercise_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME02_CarRace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        double leftCarTotalTime = 0;
        double rightCarTotalTime = 0;

        for (int i = 0; i < (numbers.size() / 2); i++) {
            int leftCarTime = numbers.get(i);
            leftCarTotalTime += leftCarTime;
            if (leftCarTime == 0) {
                leftCarTotalTime *= 0.8;
            }
        }
        for (int i = numbers.size() - 1; i > numbers.size() / 2; i--) {
            int rightCarTime = numbers.get(i);
            rightCarTotalTime += rightCarTime;
            if (rightCarTime == 0) {
                rightCarTotalTime *= 0.8;
            }
        }
        printWinner(leftCarTotalTime, rightCarTotalTime);
    }

    private static void printWinner(double firstRacerTime, double secondRacerTime) {
        double winnerTime = Math.min(firstRacerTime, secondRacerTime);
        String winnerRacer = firstRacerTime < secondRacerTime ? "left" : "right";
        System.out.printf("The winner is %s with total time: %.1f%n", winnerRacer, winnerTime);
    }
}
