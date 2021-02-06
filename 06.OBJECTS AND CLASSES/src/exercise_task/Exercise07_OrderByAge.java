package exercise_task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exercise07_OrderByAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Human> humans = new ArrayList<>();

        while (!input.equals("End")) {
            String[] humanInfo = input.split("\\s+");
            String name = humanInfo[0];
            String id = humanInfo[1];
            int age = Integer.parseInt(humanInfo[2]);

            humans.add(new Human(name, id, age));

            input = scanner.nextLine();
        }

        humans.stream()
                .sorted(Comparator.comparing(Human::getAge))
                .forEach(human -> System.out.println(human.toString()));
    }
}

class Human {

    String name;
    String id;
    int age;

    public Human(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", name, id, age);
    }
}
