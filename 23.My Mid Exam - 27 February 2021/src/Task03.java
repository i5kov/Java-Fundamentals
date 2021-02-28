import java.util.*;
import java.util.stream.Collectors;

public class Task03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> cards = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
        List<String> myDeck = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Ready")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String cardName = "";
            if (!command.equals("Shuffle")) {
                cardName = tokens[1];
            }
            switch (command) {
                case "Add":
                    if (!cards.contains(cardName)) {
                        System.out.println("Card not found.");
                    } else {
                        addCardInDeck(cardName, myDeck);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if ((index < 0 || index >= myDeck.size()) || !cards.contains(cardName)) {
                        System.out.println("Error!");
                    } else {
                        addCardInDeckAtSpecificPosition(cardName, index, myDeck);
                    }
                    break;
                case "Remove":
                    if (!myDeck.contains(cardName)) {
                        System.out.println("Card not found.");
                    } else {
                        removeCardFromDeck(cardName, myDeck);
                    }
                    break;
                case "Swap":
                    String card2Name = tokens[2];
                    swapTwoCardsInDeck(cardName, card2Name, myDeck);
                    break;
                case "Shuffle":
                    shuffleCardsInDeck(myDeck);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", myDeck));
    }

    private static void addCardInDeck(String cardName, List<String> deck) {
        deck.add(cardName);
    }

    private static void addCardInDeckAtSpecificPosition(String cardName, int positionOfCard, List<String> deck) {
        deck.add(positionOfCard, cardName);
    }

    private static void removeCardFromDeck(String cardName, List<String> deck) {
        deck.remove(cardName);
    }

    private static void swapTwoCardsInDeck(String firstCardName, String secondCardName, List<String> deck) {
        int card1Position = deck.indexOf(firstCardName);
        int card2Position = deck.indexOf(secondCardName);
        deck.set(card1Position, secondCardName);
        deck.set(card2Position, firstCardName);
    }

    private static void shuffleCardsInDeck(List<String> deck) {
        Collections.reverse(deck);
    }
}
