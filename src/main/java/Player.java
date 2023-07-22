import java.util.List;
import java.util.stream.Stream;

public class Player {
    String name;
    private static final String[] pcNames = {"Boreaboo", "Sniffster", "NoMercy", "Carbon Monoxide", "Tiger", "Wizard", "Teaspoon", "Troublemaker", "BabyShark"};

    public Player(String name) {
        this.name = name;
    }

    public boolean isUser() {
        return this.name.equals("User");
    }

    public String getName() {
        return name;
    }

    public static List<String> getPcPlayerNames(int playerNumber) {
        return Stream.of(pcNames).limit(playerNumber).toList();
    }

    @Override
    public String toString() {
        return name;
    }
}
