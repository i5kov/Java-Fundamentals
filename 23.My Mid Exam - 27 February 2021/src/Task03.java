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
                        myDeck.add(cardName);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if ((index < 0 || index >= myDeck.size()) || !cards.contains(cardName)) {
                        System.out.println("Error!");
                    } else {
                        myDeck.add(index, cardName);
                    }
                    break;
                case "Remove":
                    if (!myDeck.contains(cardName)) {
                        System.out.println("Card not found.");
                    } else {
                        myDeck.remove(cardName);
                    }
                    break;
                case "Swap":
                    String card2Name = tokens[2];
                    int card1Position = myDeck.indexOf(cardName);
                    int card2Position = myDeck.indexOf(card2Name);
                    myDeck.set(card1Position, card2Name);
                    myDeck.set(card2Position, cardName);
                    break;
                case "Shuffle":
                    Collections.reverse(myDeck);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", myDeck));
    }
}
