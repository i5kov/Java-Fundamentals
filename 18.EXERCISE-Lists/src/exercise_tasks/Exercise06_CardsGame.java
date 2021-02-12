package exercise_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise06_CardsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            int currentRound = 0;
            Integer player1CurrentCard = firstPlayerDeck.get(currentRound);
            Integer player2CurrentCard = secondPlayerDeck.get(currentRound);

            if (player1CurrentCard.equals(player2CurrentCard)) {
                firstPlayerDeck.remove(player1CurrentCard);
                secondPlayerDeck.remove(player2CurrentCard);
            } else if (player1CurrentCard > player2CurrentCard) {
                firstPlayerDeck.add(player1CurrentCard);
                firstPlayerDeck.remove(player1CurrentCard);
                firstPlayerDeck.add(player2CurrentCard);
                secondPlayerDeck.remove(player2CurrentCard);
            } else {
                secondPlayerDeck.add(player2CurrentCard);
                secondPlayerDeck.remove(player2CurrentCard);
                secondPlayerDeck.add(player1CurrentCard);
                firstPlayerDeck.remove(player1CurrentCard);
            }

            if (firstPlayerDeck.size() < 1) {
                int player2DeckSum = getSumOfCards(secondPlayerDeck);
                System.out.printf("Second player wins! Sum: %d", player2DeckSum);
                break;
            } else if (secondPlayerDeck.size() < 1) {
                int player1DeckSum = getSumOfCards(firstPlayerDeck);
                System.out.printf("First player wins! Sum: %d", player1DeckSum);
                break;
            }
        }

    }

    private static int getSumOfCards(List<Integer> cards) {
        int sum = 0;
        for (Integer card :cards) {
            sum += card;
        }
        return sum;
    }
}
