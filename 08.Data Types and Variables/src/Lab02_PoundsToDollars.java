import java.math.BigDecimal;
import java.util.Scanner;

public class Lab02_PoundsToDollars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal britishPounds = new BigDecimal(scanner.nextLine());
        double dollar = 1.31;
        BigDecimal toDollars = britishPounds.multiply(BigDecimal.valueOf(dollar));
        System.out.printf("%.3f", toDollars);
    }
}
