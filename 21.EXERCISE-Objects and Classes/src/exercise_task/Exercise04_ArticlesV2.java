package exercise_task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exercise04_ArticlesV2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<ArticleV2> articlesV2 = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] articleInfo = scanner.nextLine().split(", ");
            String title = articleInfo[0];
            String content = articleInfo[1];
            String author = articleInfo[2];

            articlesV2.add(new ArticleV2(title, content, author));
        }
        String criteriaForSorting = scanner.nextLine();

        switch (criteriaForSorting) {
            case "title":
                articlesV2.sort(Comparator.comparing(ArticleV2::getTitle));
                break;
            case "content":
                articlesV2.sort(Comparator.comparing(ArticleV2::getContent));
                break;
            case "author":
                articlesV2.sort(Comparator.comparing(ArticleV2::getAuthor));
                break;
        }
        articlesV2.forEach(articleV2 -> System.out.printf("%s - %s: %s%n", articleV2.getTitle(), articleV2.getContent(), articleV2.getAuthor()));
    }
}

class ArticleV2 {

    String title;
    String content;
    String author;

    public ArticleV2(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s%n", title, content, author);
    }
}