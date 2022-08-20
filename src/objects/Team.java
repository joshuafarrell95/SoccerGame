package objects;

import exceptions.*;

public class Team {
    /* Static Team array */
    private static final int NUMBER_OF_TEAM = 4;
    private static final int NUMBER_OF_ATTRIBUTES = 5;
    private static int[][] teams = new int[NUMBER_OF_TEAM][NUMBER_OF_ATTRIBUTES];
    
    /* Team object behaviours */
    private static int teamCount = 0;
    private String teamName;             /* get only */
    private int teamID;                  /* get only */
    
    /* Custom constructor */
    public Team(String teamName) {
        //if (teamCount > 3) {
        //    throw new TeamLimitReachedException();
        //} else {
            this.teamName = teamName;
            this.teamID = teamCount++;
        //}
    }
    
    /* Setters and getters */
    public String getTeamName() {
        return teamName;
    }
    
    public int getTeamID() {
        return teamID;
    }
    
    public static void setTeamWinTotal(int teamID, int teamWinTotal) {
        teams[teamID][0] = teamWinTotal;
    }
    
    public static int getTeamWinTotal(int teamID) {
        return teams[teamID][0];
    }
    
    public static void setTeamLossTotal(int teamID, int teamLossTotal) {
        teams[teamID][1] = teamLossTotal;
    }
    
    public static int getTeamLossTotal(int teamID) {
        return teams[teamID][1];
    }
    
    public static void setTeamTieTotal(int teamID, int teamTieTotal) {
        teams[teamID][2] = teamTieTotal;
    }
    
    public static int getTeamTieTotal(int teamID) {
        return teams[teamID][2];
    }
    
    public static void setTeamTotalScore(int teamID, int teamTotalScore) {
        teams[teamID][3] = teamTotalScore;
    }
    
    public static int getTeamTotalScore(int teamID) {
        return teams[teamID][3];
    }
    
    public static void setTeamTotalAllow(int teamID, int teamTotalAllow) {
        teams[teamID][4] = teamTotalAllow;
    }
    
    public static int getTeamTotalAllow(int teamID) {
        return teams[teamID][4];
    }
    
    /* Utilities */    
    public void updateArray(int teamID, int teamWinTotal, int teamLossTotal, int teamTieTotal, int teamTotalScore, int teamTotalAllow) {
        teams[teamID][0] = teamWinTotal;
        teams[teamID][1] = teamLossTotal;
        teams[teamID][2] = teamTieTotal;
        teams[teamID][3] = teamTotalScore;
        teams[teamID][4] = teamTotalAllow;
    }
    
    public void printResult() {
        if (this.getTeamID() == 0) {
            System.out.println("*********RESULTS*********");
        }
        System.out.println("Team " + this.getTeamID());
        System.out.println("Wins: " + this.getTeamWinTotal(this.getTeamID())
                + ", Losses: " + this.getTeamLossTotal(this.getTeamID()) 
                + ", Ties: " + this.getTeamTieTotal(this.getTeamID()));
        System.out.println("Points Scored: " + this.getTeamTotalScore(this.getTeamID()) 
                + ", Points Allowed: " + this.getTeamTotalAllow(this.getTeamID()) + "\r\n");
    }
}
