package objects;

import java.util.ArrayList;         /* module java.base */

public class Game {
    private static int gameCount = 1;
    public int gameID;                 /* get only */
    ArrayList<Team> gamesArray = new ArrayList<>();
    
    public int gameTeamScore;
    
    public Game(Team team1, Team team2) {
        this.gameID = gameCount;
        
    }
    
    public void printGameStats(Team team) {
        gamesArray.add(team);
    }
}
