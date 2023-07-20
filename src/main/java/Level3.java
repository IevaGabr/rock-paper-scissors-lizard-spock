import java.util.*;
import java.util.stream.Collectors;

public class Level3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter computer player number (from 1 to 9)");
        int pcPlayerCount = input.nextInt();
        while (pcPlayerCount < 1 || pcPlayerCount >9){
            System.out.println("Invalid data.\nPlease, enter computer player number (from 1 to 9)");
            pcPlayerCount = input.nextInt();
        }
        System.out.println("Please, enter number of rounds with each player (from 1 to 5)");
        int numberOfRounds = input.nextInt();
        while (numberOfRounds < 1 || numberOfRounds > 5) {
            System.out.println("Invalid data.\nPlease, enter number of rounds with each player (from 1 to 5)");
            numberOfRounds = input.nextInt();
        }
        String[] pcPlayers = Game.getPcPlayers(pcPlayerCount);
        Map<String,Integer> countVictories = new HashMap<>();
        countVictories.put("User",0);
        for (String player : pcPlayers){
            countVictories.put(player,0);
            Game game = new Game("User", player);
            System.out.println("Let's play with " + player + "!");
            int countRounds = 1;
            while (countRounds <= numberOfRounds){
                System.out.println("Round nr." + countRounds);
                System.out.println(game.playRound());
                countRounds++;
            }
            if (game.getPlayer1Victories() > game.getPlayer2Victories()){
                System.out.println("You won!");
                countVictories.computeIfPresent("User", (k,v) -> v+ 1);
            } else if (game.getPlayer1Victories() < game.getPlayer2Victories()) {
                System.out.println(player + " won!");
                countVictories.computeIfPresent(player, (k,v) -> v+1);
            } else {
                System.out.println("Tie!");
            }
        }
        if (pcPlayerCount >1) {
            for (int i = 0; i < pcPlayerCount; i++) {
                for (int j = i+1; j < pcPlayerCount; j++) {
                    Game game = new Game(pcPlayers[i], pcPlayers[j]);
                    int countRounds = 1;
                    while (countRounds <= numberOfRounds) {
                        game.playRound();
                        countRounds++;
                    }
                    if (game.getPlayer1Victories() > game.getPlayer2Victories()) {
                        countVictories.computeIfPresent(pcPlayers[i], (k, v) -> v + 1);
                    } else if (game.getPlayer1Victories() < game.getPlayer2Victories()) {
                        countVictories.computeIfPresent(pcPlayers[j], (k, v) -> v + 1);
                    }
                }
            }
        }
        printGameResults(countVictories);

    }

    public static void printGameResults (Map<String, Integer> results){
        Map<String, Integer> sortedResults = results.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b)->b, LinkedHashMap::new));
        String winner = sortedResults.entrySet().stream().findFirst().get().getKey();
        System.out.println("Winner is " + winner);
        System.out.println("Game statistics: ");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()){
            System.out.println(entry.getKey() +" : " + entry.getValue());
        }
    }

}
