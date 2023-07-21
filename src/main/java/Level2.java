import java.util.List;

public class Level2 {
    public static void main(String[] args) {
        List<String> pcNames = Game.getPcPlayers(3);
        int userWonPC = 0;
        System.out.println("Let us begin...");
        System.out.println("Rock, Paper, Scissors, Lizard, Spock");
        for (String name: pcNames) {
            Game game = new Game("User", name);
            System.out.println("Let's play with " + name + "!");
            int countRounds = 1;
            while (countRounds <= 3) {
                System.out.println("Round nr." + countRounds);
                System.out.println(game.playRound());
                countRounds++;
            }
            if(game.getPlayer1Victories()>game.getPlayer2Victories()){
                userWonPC++;
            }
            System.out.println("Score: User=" + game.getPlayer1Victories() + " : " + name + "=" + game.getPlayer2Victories());
        }
        if (userWonPC == 3){
            System.out.println("You won all computers!");
        } else {
            System.out.println("You didn't won all computers!");
        }
    }
}
