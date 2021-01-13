package exercise_task;

import java.util.Scanner;

public class Exercise02_Articles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int lines = Integer.parseInt(scanner.nextLine());

        String title = input[0];
        String content = input[1];
        String author = input[2];
        Article article = new Article(title, content, author);

        for (int i = 0; i < lines; i++) {
            String[] token = scanner.nextLine().split(": ");
            String command = token[0];
            String newData = token[1];

            switch (command) {
                case "Edit":
                    article.edit(newData);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(newData);
                    break;
                case "Rename":
                    article.rename(newData);
                    break;
            }
        }
        System.out.println(article.toString());
    }
}

class Article {

    String title;
    String content;
    String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String newContent) {
        content = newContent;
    }

    public void changeAuthor(String newAuthor) {
        author = newAuthor;
    }

    public void rename(String newTitle) {
        title = newTitle;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s%n", title, content, author);
    }
}