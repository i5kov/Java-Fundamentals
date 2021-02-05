package exercise_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise10_SoftUniCoursePlanning {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            String[] command = input.split(":");
            String operation = command[0];
            String lessonTitle = command[1];

            switch (operation) {
                case "Add":
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    if (!schedule.contains(lessonTitle)) {
                        int index = Integer.parseInt(command[2]);
                        if (index >= 0 && index < schedule.size()) {
                            schedule.add(index, lessonTitle);
                        }
                    }
                    break;
                case "Remove":
                    schedule.remove(lessonTitle);
                    schedule.remove(lessonTitle + "-Exercise");
                    break;
                case "Swap":
                    String secondLessonTitle = command[2];
                    String exerciseOne = lessonTitle + "-Exercise";
                    String exerciseTwo = secondLessonTitle + "-Exercise";

                    if (schedule.contains(lessonTitle) && schedule.contains(secondLessonTitle)) {
                        int firstIndex = schedule.indexOf(lessonTitle);
                        int secondIndex = schedule.indexOf(secondLessonTitle);
                        schedule.set(firstIndex, secondLessonTitle);
                        schedule.set(secondIndex, lessonTitle);
                        if (schedule.contains(exerciseOne)) {
                            schedule.remove(exerciseOne);
                            schedule.add(schedule.indexOf(lessonTitle) + 1, exerciseOne);
                        }
                        if (schedule.contains(exerciseTwo)) {
                            schedule.remove(exerciseTwo);
                            schedule.add(schedule.indexOf(secondLessonTitle) + 1, exerciseTwo);
                        }
                    }
                    break;
                case "Exercise":
                    String exercise = lessonTitle + "-Exercise";
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                        schedule.add(exercise);

                    } else if (schedule.contains(lessonTitle) && !schedule.contains(exercise)) {
                        int index = schedule.indexOf(lessonTitle);
                        schedule.add(index + 1, exercise);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < schedule.size(); i++) {
            System.out.printf("%d.%s%n", (i + 1), schedule.get(i));
        }
    }
}
