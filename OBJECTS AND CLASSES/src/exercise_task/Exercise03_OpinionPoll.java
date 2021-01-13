package exercise_task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exercise03_OpinionPoll {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        int ageCheck = 30;

        for (int i = 0; i < lines; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);

            people.add(new Person(name, age));
        }
        people.stream()
                .filter(person -> person.getAge() > ageCheck)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(person -> System.out.printf("%s - %s%n", person.getName(), person.getAge()));
    }
}

class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
