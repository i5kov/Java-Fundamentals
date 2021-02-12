import java.util.Random;
import java.util.Scanner;

public class Lab01_RandomizeWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");
        Random random = new Random();

        for (int i = 0; i < words.length; i++) {
            int randomNumber = random.nextInt(words.length);

            String firstWord = words[randomNumber];
            String secondWord = words[i];
            words[randomNumber] = secondWord;
            words[i] = firstWord;
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
