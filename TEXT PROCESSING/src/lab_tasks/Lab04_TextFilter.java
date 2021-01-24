package lab_tasks;

import java.util.Scanner;

public class Lab04_TextFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] banWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String banWord : banWords) {
            text = text.replaceAll(banWord, new String(new char[banWord.length()]).replace("\0","*"));
        }
        System.out.println(text);
    }
}
