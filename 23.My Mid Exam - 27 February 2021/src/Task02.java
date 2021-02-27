import java.util.*;
import java.util.stream.Collectors;

public class Task02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "reverse":
                    int reverseStart = Integer.parseInt(tokens[2]);
                    int reverseCount = Integer.parseInt(tokens[4]);
                    List<String> reverse = new ArrayList<>();
                    for (int i = reverseStart; i <= reverseStart + reverseCount - 1; i++) {
                        reverse.add(numbers.get(i));
                    }
                    Collections.reverse(reverse);

                    int count = 0;
                    for (int i = reverseStart; i <= reverseStart + reverseCount - 1; i++) {
                        numbers.set(i, reverse.get(count));
                        count++;
                    }
                    break;
                case "sort":
                    int sortStart = Integer.parseInt(tokens[2]);
                    int sortCount = Integer.parseInt(tokens[4]);
                    List<String> sort = new ArrayList<>();
                    for (int i = sortStart; i <= sortStart + sortCount - 1; i++) {
                        sort.add(numbers.get(i));
                    }
                    Collections.sort(sort);
                    int cnt = 0;
                    for (int i = sortStart; i <= sortStart + sortCount - 1; i++) {
                        numbers.set(i, sort.get(cnt));
                        cnt++;
                    }
                    break;
                case "remove":
                    int countForRemove = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < countForRemove; i++) {
                        numbers.remove(0);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", numbers));
    }
}
