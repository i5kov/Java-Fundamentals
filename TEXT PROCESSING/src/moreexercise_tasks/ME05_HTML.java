package moreexercise_tasks;

import java.util.Scanner;

public class ME05_HTML {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String titleOfArticle = scanner.nextLine();
        String contentOfArticle = scanner.nextLine();
        String input = scanner.nextLine();

        printTextWithSpecificTag(titleOfArticle, "h1");
        printTextWithSpecificTag(contentOfArticle, "article");
        while (!input.equals("end of comments")) {
            String commentsAboutArticle = input;
            printTextWithSpecificTag(commentsAboutArticle, "div");
            input = scanner.nextLine();
        }
    }

    private static void printTextWithSpecificTag(String commentText, String tag) {
        System.out.printf("<%s>%n\t%s%n</%s>%n", tag, commentText, tag);
    }
}
