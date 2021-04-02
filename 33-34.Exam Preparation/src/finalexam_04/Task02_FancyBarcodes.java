package finalexam_04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02_FancyBarcodes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfBarcodes = Integer.parseInt(scanner.nextLine());

        String regex = "@#+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@[#]+";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < countOfBarcodes; i++) {
            String barcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                String product = matcher.group("product");
                StringBuilder productGroup = new StringBuilder();

                for (int j = 0; j < product.length(); j++) {
                    char currentSymbol = product.charAt(j);
                    if (Character.isDigit(currentSymbol)) {
                        productGroup.append(currentSymbol);
                    }
                }

                if (productGroup.toString().isEmpty()) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + productGroup);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
