import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab02_MatchPhoneNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String regex = "\\+359([-\\s])[2]\\1\\d{3}\\1\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> validPhoneNumbers = new ArrayList<>();

        while (matcher.find()) {
            validPhoneNumbers.add(matcher.group());
        }
        System.out.println(String.join(", ", validPhoneNumbers));
    }
}
