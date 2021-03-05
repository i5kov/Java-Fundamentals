package moreexercise_tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ME02_Judge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> allContests = new LinkedHashMap<>();

        while (!input.equals("no more time")) {
            String[] tokens = input.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            Integer points = Integer.parseInt(tokens[2]);

            if (!allContests.containsKey(contest)) {
                allContests.put(contest, new TreeMap<>());
            }
            allContests.get(contest).put(username, points);
            if (allContests.get(contest).get(username) < points) {
                allContests.get(contest).put(username, points);
            }
            input = scanner.nextLine();
        }

        AtomicInteger atomicInteger = new AtomicInteger(1);
        allContests.forEach((key, value) -> {
            atomicInteger.set(1);
            System.out.printf("%s: %d participants%n", key, value.size());
            value.entrySet()
                    .stream()
                    .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                    .forEach(e -> {
                        System.out.printf("%d. %s <::> %d%n", atomicInteger.getAndIncrement(), e.getKey(), e.getValue());
                    });
        });
    }
}
