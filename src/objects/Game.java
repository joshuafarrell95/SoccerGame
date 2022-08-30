package objects;

import java.util.ArrayList;         /* module java.base */
import java.util.Random;

public class Game {
    Random random = new Random();
    
    private static int gameCount = 1;
    private int gameID;                 /* get only */
    private static ArrayList<String> gamesArray = new ArrayList<>();
    
    //private static ArrayList<ArrayList<String>> gamesArray = new ArrayList<>();
    private int gameTeamScore;
    
    public Game(Team team) {
        printGameStats(team);
    }
    
    public Game(Team team1, Team team2, int temperature) {
        this.gameID = gameCount;
        String teamName1 = team1.getTeamName();
        
        
        gamesArray.add(team1 + "," + team2 + "," + temperature);
        gameCount++;
    }
    
    /* Setters and getters */
    public int getGameCount() {
        return gameCount;
    }
    
    public int getGameID() {
        return gameID;
    }
    
    public void setGameTeamScore(int gameTeamScore) {
        this.gameTeamScore = gameTeamScore;
    }
    
    /* Utilities */
    public void determineScore(int team1, int team2, int temperature) {
        int maxScore = temperature / 5;       /* Scale maximum score with the temperature */
        int[] scoreArray = new int[2];
        
        scoreArray[0] = random.nextInt(0, maxScore);    /* randomise team1 score */
        scoreArray[1] = random.nextInt(0, maxScore);    /* randomise team1 score */
        
        if (scoreArray[0] > scoreArray[1]) {            /* team1 wins */
            Team.setTeamWinTotal(team1, Team.getTeamWinTotal(team1) + 1);
            Team.setTeamTotalScore(team1, Team.getTeamTotalScore(team1) + scoreArray[0]);
            Team.setTeamTotalAllow(team1, Team.getTeamTotalAllow(team1) + scoreArray[1]);
            
            Team.setTeamLossTotal(team2, Team.getTeamLossTotal(team2) + 1);
            Team.setTeamTotalScore(team2, Team.getTeamTotalScore(team2) + scoreArray[1]);
            Team.setTeamTotalAllow(team2, Team.getTeamTotalAllow(team2) + scoreArray[0]);
        } else if (scoreArray[0] < scoreArray[1]) {     /* team2 wins */
            Team.setTeamWinTotal(team2, Team.getTeamWinTotal(team2) + 1);
            Team.setTeamTotalScore(team2, Team.getTeamTotalScore(team2) + scoreArray[1]);
            Team.setTeamTotalAllow(team2, Team.getTeamTotalAllow(team2) + scoreArray[0]);
            
            Team.setTeamLossTotal(team1, Team.getTeamLossTotal(team1) + 1);
            Team.setTeamTotalScore(team1, Team.getTeamTotalScore(team1) + scoreArray[0]);
            Team.setTeamTotalAllow(team1, Team.getTeamTotalAllow(team1) + scoreArray[1]);
        } else {                                        /* both teams tie */
            Team.setTeamTieTotal(team1, Team.getTeamTieTotal(team1) + 1);
            Team.setTeamTotalScore(team1, Team.getTeamTotalScore(team1) + scoreArray[0]);
            Team.setTeamTotalAllow(team1, Team.getTeamTotalAllow(team1) + scoreArray[1]);
            
            Team.setTeamTieTotal(team2, Team.getTeamTieTotal(team2) + 1);
            Team.setTeamTotalScore(team2, Team.getTeamTotalScore(team2) + scoreArray[1]);
            Team.setTeamTotalAllow(team2, Team.getTeamTotalAllow(team2) + scoreArray[0]);
        }
    }
    
    public void recordGame(Team team) {
        gamesArray.add(team.getTeamName());
    }
    
    public void printGameStats(Team team) {        
//        for (int x = 0; x < gameCount; x++) {
//            
//        }
        System.out.println(gamesArray.toString());
    }
}
