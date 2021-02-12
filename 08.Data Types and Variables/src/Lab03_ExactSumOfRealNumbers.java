import java.math.BigDecimal;
import java.util.Scanner;

public class Lab03_ExactSumOfRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = BigDecimal.ZERO;

        for (int i = 0; i < inputNumber; i++) {
            BigDecimal currentNumber = new BigDecimal(scanner.nextLine());
            sum = sum.add(currentNumber);
        }
        System.out.println(sum);
    }
}
