package finalexam_05;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02_EmojiDetector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String digitRegex = "\\d";
        Pattern pattern = Pattern.compile(digitRegex);
        Matcher matcher = pattern.matcher(input);
        BigInteger coolThreshold = BigInteger.valueOf(1);

        while (matcher.find()) {
            long currentDigit = Long.parseLong(matcher.group());
            coolThreshold = coolThreshold.multiply(BigInteger.valueOf(currentDigit));
        }

        System.out.println("Cool threshold: " + coolThreshold);

        String emojisRegex = "([::\\*\\*])\\1(?<word>[A-Z][a-z]{2,})\\1\\1";
        Pattern p = Pattern.compile(emojisRegex);
        Matcher m = p.matcher(input);

        List<String> coolEmojis = new ArrayList<>();
        int validEmojis = 0;

        while (m.find()) {
            validEmojis++;
            String word = m.group("word");

            int sum = 0;

            for (int i = 0; i < word.length(); i++) {
                sum += word.charAt(i);
            }
            if (coolThreshold.compareTo(BigInteger.valueOf(sum)) < 0) {
                coolEmojis.add(m.group());
            }
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", validEmojis);
        coolEmojis.forEach(System.out::println);
    }
}
