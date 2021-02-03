package moreexercise_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME06_WinningTicket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tickets = Arrays.stream(scanner.nextLine().split("[\\s,]+")).collect(Collectors.toList());


        for (String ticket : tickets) {
            boolean isValidLengthOfTicket = isTicketExactlyTwentyCharacters(ticket);

            if (isValidLengthOfTicket) {
                String leftSideOfTicket = ticket.substring(0, ticket.length() / 2);
                String rightSideOfTicket = ticket.substring(ticket.length() / 2);

                if (isWinningSymbolRepeated(leftSideOfTicket) && isWinningSymbolRepeated(rightSideOfTicket)) {
                    int countOfRepeatedWinningSymbol = getCountOfRepeatedWinningSymbol(leftSideOfTicket);
                    char winningSymbol = getWinningSymbol(leftSideOfTicket);
                    if (countOfRepeatedWinningSymbol >= 6 && countOfRepeatedWinningSymbol <= 9) {
                        System.out.printf("ticket \"%s\" - %d%c%n", ticket, countOfRepeatedWinningSymbol, winningSymbol);
                    } else if (countOfRepeatedWinningSymbol == 10) {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", ticket, countOfRepeatedWinningSymbol, winningSymbol);
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }

    private static boolean isTicketExactlyTwentyCharacters(String ticket) {
        return ticket.length() == 20;
    }

    private static boolean isWinningSymbolRepeated(String ticket) {
        boolean isWinningSymbolRepeated = false;
        int count = 0;
        for (int i = 0; i < ticket.length(); i++) {
            switch (ticket.charAt(i)) {
                case '@':
                case '#':
                case '$':
                case '^':
                    count++;
                    if (count >= 6) {
                        isWinningSymbolRepeated = true;
                        break;
                    }
                    break;
                default:
                    count = 0;
                    break;
            }
        }
        return isWinningSymbolRepeated;
    }

    private static int getCountOfRepeatedWinningSymbol(String text) {
        int longestSequence = 1;
        int sequence = 1;

        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    sequence++;
                } else {
                    break;
                }
            }
            if (sequence > longestSequence) {
                longestSequence = sequence;
            }
            sequence = 1;
        }
        return longestSequence;
    }

    private static char getWinningSymbol(String text) {
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '@':
                case '#':
                case '$':
                case '^':
                    return text.charAt(i);
            }
        }
        return '0';
    }
}
