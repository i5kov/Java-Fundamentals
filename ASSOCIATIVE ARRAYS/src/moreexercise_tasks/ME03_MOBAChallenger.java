package moreexercise_tasks;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ME03_MOBAChallenger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> players = new TreeMap<>();

        while (!input.equals("Season end")) {
            if (input.contains("->")) {
                String[] tokens = input.split(" -> ");
                String player = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                if (!players.containsKey(player)) {
                    players.put(player, new TreeMap<>());
                }
                players.get(player).put(position, skill);

                if (players.get(player).get(position) < skill) {
                    players.get(player).put(position, skill);
                }
            } else if (input.contains(" vs ")) {
                String[] tokens = input.split(" vs ");
                String player1 = tokens[0];
                String player2 = tokens[1];

                if (players.containsKey(player1) && players.containsKey(player2)) {
                    boolean hasCommonPosition = false;

                    for (String player1Position : players.get(player1).keySet()) {
                        for (String player2Position : players.get(player2).keySet()) {
                            if (player1Position.equals(player2Position)) {
                                hasCommonPosition = true;
                                break;
                            }
                        }
                    }
                    if (hasCommonPosition) {
                        int player1totalSkillPoints = players.get(player1).values().stream().mapToInt(i -> i).sum();
                        int player2totalSkillPoints = players.get(player2).values().stream().mapToInt(i -> i).sum();
                        if (player1totalSkillPoints > player2totalSkillPoints) {
                            players.remove(player2);
                        } else if (player2totalSkillPoints > player1totalSkillPoints) {
                            players.remove(player1);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        players.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int p1sum = p1.getValue().values().stream().mapToInt(i -> i).sum();
                    int p2sum = p2.getValue().values().stream().mapToInt(i -> i).sum();
                    int result = Integer.compare(p2sum, p1sum);
                    if (result == 0) {
                        result = p1.getKey().compareTo(p2.getKey());
                    }
                    return result;
                }).forEach(m -> {
            System.out.printf("%s: %d skill%n", m.getKey(), m.getValue().values().stream().mapToInt(i -> i).sum());
            m.getValue()
                    .entrySet()
                    .stream()
                    .sorted((s1, s2) -> {
                        int result = s2.getValue().compareTo(s1.getValue());
                        if (result == 0) {
                            result = s1.getKey().compareTo(s2.getKey());
                        }
                        return result;
                    }).forEach(e -> {
                System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
            });
        });
    }
}
