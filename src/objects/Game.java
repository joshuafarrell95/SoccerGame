package objects;

import java.util.ArrayList;         /* module java.base */

public class Game {
    private static int gameCount = 1;
    private int gameID;                 /* get only */
    private static ArrayList<String> gamesArray = new ArrayList<>();
    private int gameTeamScore;
    
    public Game(Team team1, Team team2) {
        this.gameID = gameCount;
        
    }
    
    /* Setters and getters */
    public int getGameID() {
        return gameID;
    }
    
    public void setGameTeamScore(int gameTeamScore) {
        this.gameTeamScore = gameTeamScore;
    }
    
    /* Utilities */
    public void recordGame(Team team) {
        gamesArray.add(team.getTeamName());
    }
    
    public void printGameStats(Team team) {        
        for (int x = 0; x < gameCount; x++) {
            gamesArray.toString();
        }
        
        gamesArray.toString();
    }
}
