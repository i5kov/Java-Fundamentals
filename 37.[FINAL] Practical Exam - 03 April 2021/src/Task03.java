import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());

        Map<String, int[]> userMessages = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Statistics")) {
            String[] tokens = input.split("=");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String username = tokens[1];
                    int sent = Integer.parseInt(tokens[2]);
                    int received = Integer.parseInt(tokens[3]);
                    userMessages.putIfAbsent(username, new int[] {sent, received});
                    break;
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];

                    if (userMessages.containsKey(sender) && userMessages.containsKey(receiver)) {
                        userMessages.get(sender)[0] += 1;
                        userMessages.get(receiver)[1] += 1;

                        if (userMessages.get(sender)[0] + userMessages.get(sender)[1] >= capacity) {
                            userMessages.remove(sender);
                            System.out.printf("%s reached the capacity!%n", sender);
                        }
                        if (userMessages.get(receiver)[0] + userMessages.get(receiver)[1] >= capacity) {
                            userMessages.remove(receiver);
                            System.out.printf("%s reached the capacity!%n", receiver);
                        }
                    }
                    break;
                case "Empty":
                    String userForDelete = tokens[1];
                    if (userForDelete.equals("All")) {
                        userMessages.clear();
                    } else {
                        userMessages.remove(userForDelete);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Users count: %d%n", userMessages.size());
        userMessages
                .entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(s.getValue()[1], f.getValue()[1]);
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()[0] + e.getValue()[1]));
    }
}
