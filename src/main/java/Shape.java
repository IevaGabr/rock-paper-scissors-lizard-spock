import java.util.Map;

public enum Shape {
    ROCK("Rock", Map.of("Scissors", "crushes", "Lizard", "crushes")),
    SCISSORS("Scissors", Map.of("Lizard", "decapitate", "Paper", "cuts")),
    PAPER("Paper", Map.of("Rock", "covers", "Spock", "disproves")),
    LIZARD("Lizard", Map.of("Spock", "poisons", "Paper", "eats")),
    SPOCK("Spock", Map.of("Scissors", "smashes", "Rock", "vaporizes"));

    private final String name;
    private final Map<String, String> strongerThan;

    Shape(String name, Map<String, String> strongerThan) {
        this.name = name;
        this.strongerThan = strongerThan;
    }

    public static Shape getUserChoice(String userChoice) {
        switch (userChoice.toLowerCase()) {
            case "r" -> {
                return ROCK;
            }
            case "sc" -> {
                return SCISSORS;
            }
            case "p" -> {
                return PAPER;
            }
            case "l" -> {
                return LIZARD;
            }
            case "sp" -> {
                return SPOCK;
            }
        }
        return null;
    }

    public boolean checkStronger(Shape choice) {
        return this.getStrongerThan().containsKey(choice.getName());
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getStrongerThan() {
        return strongerThan;
    }
}


