package finalexam_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task03_HeroesOfCodeAndLogicVII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfHeroes = Integer.parseInt(scanner.nextLine());

        Map<String, int[]> heroes = new HashMap<>();

        for (int i = 0; i < numberOfHeroes; i++) {
            String[] heroInfo = scanner.nextLine().split("\\s+");
            String heroName = heroInfo[0];
            int hitPoints = Integer.parseInt(heroInfo[1]);
            int manaPoints = Integer.parseInt(heroInfo[2]);

            if (heroes.containsKey(heroName)) {
                int updatedHitPoints = heroes.get(heroName)[0] + hitPoints;
                int updatedManaPoints = heroes.get(heroName)[1] + manaPoints;
                heroes.put(heroName, new int[] {updatedHitPoints, updatedManaPoints});
            } else {
                heroes.put(heroName, new int[] {hitPoints, manaPoints});
            }
        }
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "CastSpell":
                    int manaPointsNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];

                    if (heroes.get(heroName)[1] < manaPointsNeeded) {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    } else {
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                heroName, spellName, heroes.get(heroName)[1]-= manaPointsNeeded);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    int currentHP = heroes.get(heroName)[0] -= damage;
                    if (heroes.get(heroName)[0] > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, damage, attacker, currentHP);
                    } else {
                        heroes.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int manaAmount = Integer.parseInt(tokens[2]);
                    int currentMana = heroes.get(heroName)[1];
                    int increaseMana = currentMana + manaAmount;

                    if (increaseMana > 200) {
                        increaseMana = 200;
                    }
                    heroes.get(heroName)[1] = increaseMana;
                    System.out.printf("%s recharged for %d MP!%n", heroName, 200 - currentMana);
                    break;
                case "Heal":
                    int hpAmount = Integer.parseInt(tokens[2]);
                    int currentHp = heroes.get(heroName)[0];
                    int increaseHp = currentHp + hpAmount;

                    if (increaseHp > 100) {
                        increaseHp = 100;
                    }
                    heroes.get(heroName)[0] = increaseHp;

                    System.out.printf("%s healed for %d HP!%n", heroName, 100 - currentHp);
                    break;
            }
            input = scanner.nextLine();
        }
        heroes.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(s.getValue()[0], f.getValue()[0]);
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.printf("  HP: %d%n", e.getValue()[0]);
                    System.out.printf("  MP: %d%n", e.getValue()[1]);
                });
    }
}
