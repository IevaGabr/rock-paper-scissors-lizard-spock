import java.util.Scanner;

public class Game {
    private final Player player1;
    private final Player player2;
    private int player1Victories;
    private int player2Victories;
    private final Shape[] pcChoices = {Shape.ROCK, Shape.SCISSORS, Shape.PAPER, Shape.LIZARD, Shape.SPOCK};
    private final Scanner input = new Scanner(System.in);

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Victories = 0;
        this.player2Victories = 0;
    }

    public String playRound() {
        Shape player1Choice;
        Shape player2Choice;
        String roundResult = "";
        if (this.player1.isUser()) {
            player1Choice = askUserChoice();
        } else {
            player1Choice = getPcChoice();
        }
        if (this.player2.isUser()) {
            player2Choice = askUserChoice();
        } else {
            player2Choice = getPcChoice();
        }
        if (player1Choice != null && player2Choice != null) {
            if (this.player1.isUser()) {
                System.out.println(this.player2 + " turn: " + player2Choice);
            } else if (this.player2.isUser()) {
                System.out.println(this.player1 + " turn: " + player1Choice);
            }
            if (player1Choice.checkStronger(player2Choice)) {
                this.player1Victories++;
                roundResult = player1Choice.getName() + " " + player1Choice.getStrongerThan().get(player2Choice.getName()) + " " + player2Choice.getName();
            } else if (player2Choice.checkStronger(player1Choice)) {
                this.player2Victories++;
                roundResult = player2Choice.getName() + " " + player2Choice.getStrongerThan().get(player1Choice.getName()) + " " + player1Choice.getName();
            } else {
                roundResult = "Tie!";
            }
        } else {
            System.out.println("Invalid input, try again...");
            playRound();
        }
        return roundResult;
    }

    public Shape askUserChoice() {
        System.out.println("Your turn (Enter r for rock, sc for scissor, p for paper, l for lizard or sp for spock):");
        String userChoice = input.nextLine();
        return Shape.getUserChoice(userChoice);
    }

    public Shape getPcChoice() {
        return pcChoices[(int) (Math.random() * 5)];
    }

    public int getPlayer1Victories() {
        return player1Victories;
    }

    public int getPlayer2Victories() {
        return player2Victories;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

}
