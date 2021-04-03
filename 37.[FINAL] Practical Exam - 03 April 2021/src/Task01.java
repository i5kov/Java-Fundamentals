import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Change":
                    String c = tokens[1];
                    String replacement = tokens[2];
                    text = text.replace(c, replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    if (text.contains(tokens[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    if (text.endsWith(tokens[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    int firstIndexOf = text.indexOf(tokens[1]);
                    System.out.println(firstIndexOf);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String substring = text.substring(startIndex, startIndex + length);
                    System.out.println(substring);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
