import java.util.Scanner;

public class Lab02_RepeatStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");

        StringBuilder repeatedStrings = new StringBuilder();

        for (String word : words) {
            int wordLength = word.length();
            for (int i = 0; i < wordLength; i++) {
                repeatedStrings.append(word);
            }
        }
        System.out.println(repeatedStrings.toString());
    }
}
