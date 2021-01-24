package exercise_tasks;

import java.util.Scanner;

public class Exercise03_ExtractFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        System.out.printf("File name: %s%n", path.substring(path.lastIndexOf('\\') + 1, path.lastIndexOf('.')));
        System.out.printf("File extension: %s%n", path.substring(path.lastIndexOf('.') + 1));
    }
}
