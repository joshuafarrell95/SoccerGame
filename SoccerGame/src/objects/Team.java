package objects;

import exceptions.*;

public class Team {
    /* Static Team array */
    public static final int NUMBER_OF_TEAM = 4;
    public static Team[] teams = new Team[NUMBER_OF_TEAM];
    
    /* Team object behaviours */
    public static int teamCount = 1;
    public String teamName;             /* get only */
    public int teamID;                  /* get only */
    public int teamWinTotal;            /* set and get */
    public int teamLossTotal;           /* set and get */
    public int teamTieTotal;            /* set and get */
    public int teamTotalScore;          /* set and get */
    public int teamTotalAllow;          /* set and get */
    
    public Team(String teamName) throws TeamLimitReachedException {
        if (teamCount > 4) {
            throw new TeamLimitReachedException();
        } else {
            this.teamName = teamName;
            this.teamID = teamCount++;
        }
    }
    
    public void printResult() {
        if (this.teamID == 1) {
            System.out.println("*********RESULTS*********");
        }
        System.out.println("Team " + this.teamID);
        System.out.println("Wins: " + this.teamWinTotal 
                + ", Losses: " + this.teamLossTotal 
                + ", Ties: " + this.teamTieTotal);
        System.out.println("Points Scored: " + this.teamTotalScore 
                + ", Points Allowed: " + this.teamTotalAllow + "\r\n");
    }
}
