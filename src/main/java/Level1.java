public class Level1 {

    public static void main(String[] args) {
        System.out.println("Let us begin...");
        System.out.println("Rock, Paper, Scissors, Lizard, Spock");
        Game game = new Game(new Player("User"), new Player("Computer"));
        for (int i = 1; i <= 3; i++) {
            System.out.println("Round nr." + i);
            System.out.println(game.playRound());
        }
        if (game.getPlayer1Victories() > game.getPlayer2Victories()) {
            System.out.println("You won!");
        } else if (game.getPlayer1Victories() < game.getPlayer2Victories()) {
            System.out.println("Computer won!");
        } else {
            System.out.println("Tie!");
        }
        System.out.println("Score: User=" + game.getPlayer1Victories() + " : Computer=" + game.getPlayer2Victories());
    }
}
