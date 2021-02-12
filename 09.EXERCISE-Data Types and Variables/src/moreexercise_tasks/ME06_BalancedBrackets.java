package moreexercise_tasks;

import java.util.Scanner;

public class ME06_BalancedBrackets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int openingBracket = 0;
        int closingBracket = 0;
        boolean isBalanced = false;

        for (int i = 1; i <= lines; i++) {
            String input = scanner.nextLine();

            if (input.equals("(")) {
                openingBracket++;
            } else if (input.equals(")")) {
                closingBracket++;
                isBalanced = openingBracket == closingBracket;
                openingBracket = 0;
                closingBracket = 0;
            }
        }

        if (openingBracket != closingBracket) {
            isBalanced = false;
        }

        if (isBalanced) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
