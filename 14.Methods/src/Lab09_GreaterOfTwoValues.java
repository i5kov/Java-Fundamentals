import java.util.Scanner;

public class Lab09_GreaterOfTwoValues {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String valueType = scanner.nextLine();

        switch (valueType.toLowerCase()) {
            case "int":
                int greaterIntValue = getGreaterValue(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
                System.out.println(greaterIntValue);
                break;
            case "char":
                char greaterCharValue = getGreaterValue(scanner.nextLine().charAt(0), scanner.nextLine().charAt(0));
                System.out.println(greaterCharValue);
                break;
            case "string":
                String greaterStringValue = getGreaterValue(scanner.nextLine(), scanner.nextLine());
                System.out.println(greaterStringValue);
                break;
        }
    }

    private static int getGreaterValue(int firstNumber, int secondNumber) {
        return Math.max(firstNumber, secondNumber);
    }

    private static char getGreaterValue(char firstChar, char secondChar) {
        return firstChar > secondChar ? firstChar : secondChar;
    }

    private static String getGreaterValue(String firstString, String secondString) {
        return firstString.compareTo(secondString) >= 0 ? firstString : secondString;
    }
}
