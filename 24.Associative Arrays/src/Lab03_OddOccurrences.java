import java.util.*;
import java.util.stream.Collectors;

public class Lab03_OddOccurrences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).map(String::toLowerCase).collect(Collectors.toList());
        Map<String, Integer> wordsCount = new LinkedHashMap<>();

        for (String word : words) {
            Integer occurrence = wordsCount.get(word);
            if (occurrence == null) {
                occurrence = 0;
            }
            wordsCount.put(word, occurrence + 1);
        }

        List<String> odds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odds.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", odds));
    }
}
