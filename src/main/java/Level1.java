public class Level1 {

    public static void main(String[] args) {
        int countRounds = 1;
        System.out.println("Let us begin...");
        System.out.println("Rock, Paper, Scissors, Lizard, Spock");
        Game game = new Game("User", "Computer");
        while (countRounds <=3){
            System.out.println("Round nr." + countRounds);
            System.out.println(game.playRound());
            countRounds++;
        }
        if (game.getPlayer1Victories() > game.getPlayer2Victories()){
            System.out.println("You won!");
        } else if (game.getPlayer1Victories() < game.getPlayer2Victories()) {
            System.out.println("Computer won!");
        } else {
            System.out.println("Tie!");
        }
        System.out.println("Score: User=" + game.getPlayer1Victories() + " : Computer=" + game.getPlayer2Victories());
    }
}
