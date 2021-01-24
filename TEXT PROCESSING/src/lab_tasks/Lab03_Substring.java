package lab_tasks;

import java.util.Scanner;

public class Lab03_Substring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String removeWord = scanner.nextLine();
        String sentence = scanner.nextLine();

        while (sentence.contains(removeWord)) {
            sentence = sentence.replace(removeWord, "");
        }
        System.out.println(sentence);
    }
}
