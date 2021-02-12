import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab04_Songs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Song> allSongs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] input = scanner.nextLine().split("_");
            String typeList = input[0];
            String name = input[1];
            String time = input[2];
            allSongs.add(new Song(typeList, name, time));
        }
        String listTypeInput = scanner.nextLine();

        if (listTypeInput.equals("all")) {
            allSongs.forEach(element -> System.out.println(element.getName()));
        } else {
            allSongs.stream()
                    .filter(element -> element.getTypeList().equals(listTypeInput))
                    .forEach(element -> System.out.println(element.getName()));
        }
    }
}

class Song {
    String typeList;
    String name;
    String time;

    public Song(String typeList, String name, String time) {
        this.typeList = typeList;
        this.name = name;
        this.time = time;
    }

    public String getTypeList() {
        return typeList;
    }

    public String getName() {
        return name;
    }
}
