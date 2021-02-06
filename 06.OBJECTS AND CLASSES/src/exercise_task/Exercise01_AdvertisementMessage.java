package exercise_task;

import java.util.Random;
import java.util.Scanner;

public class Exercise01_AdvertisementMessage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfRandomMessages = Integer.parseInt(scanner.nextLine());
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        for (int i = 0; i < countOfRandomMessages; i++) {
            Random random = new Random();
            String randomPhrase = phrases[random.nextInt(phrases.length)];
            String randomEvent = events[random.nextInt(events.length)];
            String randomAuthor = authors[random.nextInt(authors.length)];
            String randomCity = cities[random.nextInt(cities.length)];

            System.out.printf("%s %s %s - %s%n", randomPhrase, randomEvent, randomAuthor, randomCity);
        }
    }
}
