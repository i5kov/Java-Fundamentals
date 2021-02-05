package moreexercise_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME03_TakeSkipRope {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hiddenMessage = scanner.nextLine();
        List<Integer> numbersList = new ArrayList<>();
        List<Character> nonNumbersList = new ArrayList<>();

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < hiddenMessage.length(); i++) {
            char currentSymbol = hiddenMessage.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                numbersList.add(Character.getNumericValue(currentSymbol));
            } else {
                nonNumbersList.add(currentSymbol);
            }
        }
        hiddenMessage = removeAllDigits(hiddenMessage);

        takeList = getElementsAtIndex(numbersList, "even");
        skipList = getElementsAtIndex(numbersList, "odd");

        String result = null;
        var total = 0;
        for (int index = 0; index < skipList.size(); index++)
        {
            int skipCount = skipList.get(index);
            long takeCount = takeList.get(index);
            result += new String(String.valueOf(nonNumbersList.stream().skip(total).limit(takeCount).toArray()));
            Object[] collect = nonNumbersList.stream().skip(total).limit(takeCount).toArray();
            total += takeCount + takeCount;
            System.out.println(collect);
        }

        System.out.println('x');
    }


    private static String removeAllDigits(String text) {
        return text.replaceAll("[0-9]", "");
    }

    private static List<Integer> getElementsAtIndex(List<Integer> list, String oddOrEvenIndex) {
        List<Integer> result = new ArrayList<>();
        switch (oddOrEvenIndex) {
            case "even":
                for (int i = 0; i < list.size(); i++) {
                    if (i % 2 == 0) {
                        result.add(list.get(i));
                    }
                }
                break;
            case "odd":
                for (int i = 0; i < list.size(); i++) {
                    if (i % 2 != 0) {
                        result.add(list.get(i));
                    }
                }
                break;
        }
        return result;
    }
}
