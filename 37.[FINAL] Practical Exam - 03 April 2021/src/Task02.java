import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        String regex = "([\\W\\S_]+)>(?<numbers>[0-9]{3})\\|(?<lower>[a-z]{3})\\|(?<upper>[A-Z]{3})\\|(?<symbols>[^<>]{3})<\\1";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < numberOfInputs; i++) {
            String password = scanner.nextLine();
            Matcher matcher = pattern.matcher(password);

            String encryptedPassword = "";

            if (matcher.find()) {
                String numbers = matcher.group("numbers");
                String lowerLetters = matcher.group("lower");
                String upperLetters = matcher.group("upper");
                String symbols = matcher.group("symbols");

                encryptedPassword = numbers + lowerLetters + upperLetters + symbols;
                System.out.printf("Password: %s%n", encryptedPassword);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
