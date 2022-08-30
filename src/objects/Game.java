package objects;

import java.util.*;         /* module java.base, imports ArrayList and Random */

public class Game {
    Random random = new Random();
    
    /* Game attributes */
    private Team homeTeam;              /* constructor only */
    private Team awayTeam;              /* constructor only */
    private int homeTeamScore;          /* set only */
    private int awayTeamScore;          /* set only */
    private int temperature;            /* constructor only */
    private static int gameCount = 0;
    private int gameID;                 /* get only */
    
    private static ArrayList<Game> gamesArray = new ArrayList<>();
    
    public Game() {
        System.out.println("You must use the custom constructor.\r\n"
                + "Please pass through two team objects and an integer temperature.");
    }
    
    public Game(Team team1, Team team2, int temperature) {
        this.temperature = temperature;
        this.homeTeam = team1;
        this.awayTeam = team2;
        gameCount++;
        this.gameID = gameCount;
        determineScore(homeTeam, awayTeam, this.temperature);
        gamesArray.add(this);
    }
    
    /* Setters and getters */
    public int getGameCount() {
        return gameCount;
    }
    
    public int getGameID() {
        return gameID;
    }

    public void setHomeTeamScore(int score) {
        this.homeTeamScore += score;
    }
    
    public void setAwayTeamScore(int score) {
        this.awayTeamScore += score;
    }
    
    public String getHomeTeamName() {
        String name = homeTeam.getTeamName();
        return name;
    }
    
    public String getAwayTeamName() {
        String name = awayTeam.getTeamName();
        return name;
    }
    
    /* Utilities */
    public void determineScore(Team team1, Team team2, int temperature) {
        int maxScore = temperature / 5;       /* Scale maximum score with the temperature */
        int[] scoreArray = new int[2];
        
        scoreArray[0] = random.nextInt(0, maxScore);    /* randomise team1 score */
        scoreArray[1] = random.nextInt(0, maxScore);    /* randomise team2 score */
        
        if (scoreArray[0] > scoreArray[1]) {            /* team1 wins */
            Team.setTeamWinTotal(convertTeamToID(team1), 1);
            Team.setTeamLossTotal(convertTeamToID(team2), 1);

        } else if (scoreArray[0] < scoreArray[1]) {     /* team2 wins */
            Team.setTeamWinTotal(convertTeamToID(team2), 1);
            Team.setTeamLossTotal(convertTeamToID(team1), 1);

        } else {                                        /* both teams tie */
            Team.setTeamTieTotal(convertTeamToID(team1), 1);
            Team.setTeamTieTotal(convertTeamToID(team2), 1);
        }
        
        /* Update team1 total score and allowed score */
        Team.setTeamTotalScore(convertTeamToID(team1), scoreArray[0]);
        Team.setTeamTotalAllow(convertTeamToID(team1), scoreArray[1]);
        this.setHomeTeamScore(scoreArray[0]);           /* Update game record */
        
        /* Update team2 total score and allowed score */
        Team.setTeamTotalScore(convertTeamToID(team2), scoreArray[1]);
        Team.setTeamTotalAllow(convertTeamToID(team2), scoreArray[0]);
        this.setAwayTeamScore(scoreArray[1]);           /* Update game record */
    }
    
    public int convertTeamToID(Team team) {
        return team.getTeamID();
    }
    
    public static void printGameStats() {        
        gamesArray.forEach((game) -> System.out.println(game + "\n"));

        int hottestTempr = 0;
        double avgTempr = 0;
        
        for (Game game : gamesArray) { 
            avgTempr += game.temperature;
            if (game.temperature > hottestTempr) {
                hottestTempr = game.temperature;
            }
        }
        
        avgTempr = avgTempr / gameCount;
        System.out.println("Hottest temperature: " + hottestTempr);
        System.out.println("Average temperature: " + avgTempr);
    }
    
    @Override
    public String toString() {
        return "Game #" + gameID + "\r\n"
                + "Temperature: " + temperature + "\r\n"
                + "Home Team: " + homeTeam.getTeamName() + " " + homeTeamScore + "\r\n"
                + "Away Team: " + awayTeam.getTeamName() + " " + awayTeamScore;
    }
}
