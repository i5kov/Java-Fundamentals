import java.util.Scanner;

public class Lab07_RepeatString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int repeatCount = Integer.parseInt(scanner.nextLine());
        String repeatedString = getRepeatedString(input, repeatCount);
        System.out.println(repeatedString);
    }

    private static String getRepeatedString(String text, int repeatCount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            result.append(text);
        }
        return result.toString();
    }
}
