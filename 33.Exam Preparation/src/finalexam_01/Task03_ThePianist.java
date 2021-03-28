package finalexam_01;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task03_ThePianist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPieces = Integer.parseInt(scanner.nextLine());

        Map<String, String> pieceAndComposer = new TreeMap<>();
        Map<String, String> pieceAndKey = new TreeMap<>();

        Map<String, String[]> pieces = new TreeMap<>();


        for (int i = 0; i < numberOfPieces; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

//            pieceAndComposer.putIfAbsent(piece, composer);
//            pieceAndKey.putIfAbsent(piece, key);

            String[] values = {composer, key};
            pieces.put(piece, values);
        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            String piece = tokens[1];

            switch (command) {
                case "Add":
                    String composer = tokens[2];
                    String key = tokens[3];
                    if (pieces.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        pieces.put(piece, new String[]{composer, key});
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = tokens[2];
                    if (pieces.containsKey(piece)) {
                        pieces.get(piece)[1] = newKey;
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        pieces.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = f.getKey().compareTo(s.getKey());
                    if (result == 0) {
                        result = f.getValue()[0].compareTo(s.getValue()[0]);
                    }
                    return result;
                })
                .forEach(e -> {
                    System.out.printf("%s -> Composer: %s, Key: %s%n", e.getKey(), e.getValue()[0], e.getValue()[1]);
                });
    }
}
