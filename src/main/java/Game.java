import java.util.Scanner;
import java.util.stream.Stream;

public class Game {
    private final String player1;
    private final String player2;

    private int player1Victories;

    private int player2Victories;
    private static final String[] pcNames = {"Boreaboo", "Sniffster", "NoMercy", "Carbon Monoxide", "Tiger", "Wizard", "Teaspoon", "Troublemaker", "BabyShark"};
    private final Shape[] pcChoices = {Shape.ROCK, Shape.SCISSORS, Shape.PAPER, Shape.LIZARD, Shape.SPOCK};

    private final Scanner input = new Scanner(System.in);

    public Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Victories = 0;
        this.player2Victories = 0;
    }

    public String playRound() {
        Shape player1Choice;
        String text="";
        if (this.player1.equals("User")) {
            System.out.println("Your turn (Enter r for rock, sc for scissor, p for paper, l for lizard or sp for spock):");
            String userChoice = input.nextLine();
            player1Choice = Shape.getUserChoice(userChoice);
        } else {
            player1Choice = pcChoices[(int) (Math.random() * 5)];
        }
        if (player1Choice != null) {
            Shape player2Choice = pcChoices[(int) (Math.random() * 5)];
            if (this.player1.equals("User")) {
                System.out.println(this.player2 + " turn: " + player2Choice);
            }
            if (player1Choice.checkGreater(player2Choice)) {
                this.player1Victories++;
                text = player1Choice.getName() + " " + player1Choice.getStrongerOperation() + " " + player2Choice.getName();
            } else if (player1Choice.checkWeaker(player2Choice)) {
                this.player1Victories++;
                text = player1Choice.getName() + " " + player2Choice.getWeakerOperation() + " " + player2Choice.getName();
            } else if (player2Choice.checkGreater(player1Choice)) {
                this.player2Victories++;
                text=  player2Choice.getName() + " " + player2Choice.getStrongerOperation() + " " + player1Choice.getName();
            } else if (player2Choice.checkWeaker(player1Choice)) {
                this.player2Victories++;
                text= player2Choice.getName() + " " + player1Choice.getWeakerOperation() + " " + player1Choice.getName();
            } else {
                text = "Tie!";
            }
        } else {
            System.out.println("Invalid input, try again...");
            playRound();
        }
        return text;
    }


    public int getPlayer1Victories() {
        return player1Victories;
    }

    public int getPlayer2Victories() {
        return player2Victories;
    }

    public static String[] getPcPlayers(int playerNumber) {
        return Stream.of(pcNames).limit(playerNumber).toList().toArray(String[]::new);
    }
}
