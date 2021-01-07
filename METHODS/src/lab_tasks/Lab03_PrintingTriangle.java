package lab_tasks;

import java.util.Scanner;

public class Lab03_PrintingTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printTriangle(scanner.nextInt());
    }

    private static void printTriangle(int n)
    {
        for (int line = 1; line <= n; line++)
        {
            printLine(line);
        }

        for (int line = n - 1; line >= 1; line--)
        {
            printLine(line);
        }
    }

    private static void printLine(int end)
    {
        for (int i = 1; i <= end; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
