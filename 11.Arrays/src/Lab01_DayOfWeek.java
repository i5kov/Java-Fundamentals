import java.util.Scanner;

public class Lab01_DayOfWeek {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayAsNumber = Integer.parseInt(scanner.nextLine());

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (dayAsNumber <= 0 || dayAsNumber > 7) {
            System.out.println("Invalid day!");
        } else {
            System.out.println(daysOfWeek[dayAsNumber - 1]);
        }
    }
}
