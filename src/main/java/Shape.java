public enum Shape {
    ROCK ("Rock", "Scissors", "crushes", "Paper", "covers"),
    SCISSORS("Scissors", "Lizard", "decapitate", "Spock", "smashes"),
    PAPER("Paper","Spock", "smashes", "Scissors", "cuts"),
    LIZARD("Lizard", "Paper", "eats", "Rock", "crushes"),
    SPOCK("Spock", "Rock", "vaporizes", "Lizard", "poisons");

    private final String name;
    private final String strongerThan;
    private final String strongerOperation;
    private final String weakerThan;
    private final String weakerOperation;

    Shape(String name, String strongerThan, String strongerOperation, String weakerThan, String weakerOperation) {
        this.name = name;
        this.strongerThan = strongerThan;
        this.strongerOperation = strongerOperation;
        this.weakerThan = weakerThan;
        this.weakerOperation = weakerOperation;
    }

    public static Shape getUserChoice (String userChoice){
        switch (userChoice.toLowerCase()){
            case "r" -> {return ROCK;}
            case "sc" -> {return  SCISSORS;}
            case "p" -> {return PAPER;}
            case "l" -> {return LIZARD;}
            case "sp" -> {return SPOCK;}
        }
        return null;
    }

    public boolean checkGreater (Shape choice){
        return this.getStrongerThan().equals(choice.getName());
    }

    public boolean checkWeaker (Shape choice){
        return choice.getWeakerThan().equals(this.getName());
    }

    public String getName() {
        return name;
    }

    public String getStrongerThan() {
        return strongerThan;
    }

    public String getStrongerOperation() {
        return strongerOperation;
    }

    public String getWeakerThan() {
        return weakerThan;
    }

    public String getWeakerOperation() {
        return weakerOperation;
    }
}
