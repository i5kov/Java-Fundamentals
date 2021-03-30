package finalexam_03_retake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02_MirrorWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String regex = "([@#])(?<word>[A-Za-z]{3,})\\1\\1(?<mirror>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);


        List<String> mirrorWords = new ArrayList<>();
        int pairCount = 0;

        while (matcher.find()) {
            pairCount++;
            String word = matcher.group("word");
            String mirrorWord = new StringBuilder(matcher.group("mirror")).reverse().toString();

            if (word.equals(mirrorWord)) {
                mirrorWords.add(word + " <=> " + matcher.group("mirror"));
            }
        }

        if (pairCount == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(pairCount + " word pairs found!");
        }
        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.print(String.join(", ", mirrorWords));
        }
    }
}
