import java.util.*;
import java.util.stream.Collectors;

public class Level3 {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pcPlayerCount = askUserPcPlayerOrRoundNumber("Please, enter computer player number (from 1 to 9)", 1, 9);
        int numberOfRounds = askUserPcPlayerOrRoundNumber("Please, enter number of rounds with each player (from 1 to 5)", 1, 5);
        String[] allPlayers = getTournamentPlayers(pcPlayerCount);
        Map<String, Integer> countPlayersVictories = new HashMap<>();
        for (int i = 0; i < allPlayers.length; i++) {
            for (int j = i + 1; j < allPlayers.length; j++) {
                Game game = new Game(allPlayers[i], allPlayers[j]);
                if (allPlayers[i].equals("User")) {
                    System.out.println("Let's play with " + allPlayers[j] + "!");
                } else if (allPlayers[j].equals("User")) {
                    System.out.println("Let's play with " + allPlayers[i] + "!");
                }
                int countRounds = 1;
                while (countRounds <= numberOfRounds) {
                    String playedRound = game.playRound();
                    if (allPlayers[i].equals("User") || allPlayers[j].equals("User")) {
                        System.out.println(playedRound);
                    }
                    countRounds++;
                }
                recordGameResult(countPlayersVictories,game);
            }
        }
        printTournamentResults(countPlayersVictories);
    }

    public static void recordGameResult (Map<String, Integer> playerVictories, Game gameResult){
        playerVictories.putIfAbsent(gameResult.getPlayer1(),0);
        playerVictories.putIfAbsent(gameResult.getPlayer2(),0);
        if (gameResult.getPlayer1Victories() > gameResult.getPlayer2Victories()) {
            playerVictories.compute(gameResult.getPlayer1(), (k, v) -> v + 1);
        } else if (gameResult.getPlayer1Victories() < gameResult.getPlayer2Victories()) {
            playerVictories.compute(gameResult.getPlayer2(), (k, v) -> v + 1);
        }
    }

    public static void printTournamentResults(Map<String, Integer> results) {
        Map<String, Integer> sortedResults = results.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
        String winner = sortedResults.entrySet().stream().findFirst().get().getKey();
        System.out.println("\nTournament winner is " + winner);
        System.out.println("\nTournament statistics: ");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static String[] getTournamentPlayers(int pcPlayerCount) {
        List<String> players = new ArrayList<>();
        players.add("User");
        players.addAll(1, Game.getPcPlayers(pcPlayerCount));
        return players.toArray(new String[0]);
    }

    public static int askUserPcPlayerOrRoundNumber(String text, int min, int max) {
        System.out.println(text);
        int number = input.nextInt();
        while (number < min || number > max) {
            System.out.println("Invalid data.\n" + text);
            number = input.nextInt();
        }
        return number;
    }

}
