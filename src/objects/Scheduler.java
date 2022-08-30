package objects;

import java.util.InputMismatchException;            /* module java.base, imports Scanner, Random and InputMismatchException */
import java.util.Scanner;
import java.util.Random;

public class Scheduler {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    Team team1 = new Team("Perth");
    Team team2 = new Team("Thornlie");
    Team team3 = new Team("Murdoch");
    Team team4 = new Team("Rockingham");
    private int attempt = 0;
    private final int MAX_ATTEMPT = 3;
            
    public Scheduler() {
    }
    
    public void acceptUserInput() {
        while (attempt < MAX_ATTEMPT) {
            int temperature;
            try {
                System.out.print("What is today's Temperature (in Fahrenheit)? ");
                while(!scan.hasNextInt()) {                     /* Catch any InputMismatchException */
                    scan.next();
                    throw new InputMismatchException();
                }
                
                temperature = scan.nextInt();
                if (temperature > 32) {                         /* Temp is at or above freezing point */
                    attempt = 0;
                    scheduleGame(2, temperature);
                } else if (temperature <= 32) {                 /* Temp is below freezing point */
                    System.out.println("Too cold to play");
                    attempt++;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Input mismatch - Please enter an integer");
            }
        }
    }
    
    public boolean scheduleGame(int gameAmount, int temperature) {
        int[] schedulerArray = new int[2];
        int schedulerCounter = 0;
        String[] teamNames = new String[2];
        
        boolean isScheduled = false;

        while (schedulerCounter < gameAmount) {
            for (int i = 0; i < gameAmount; i++) {
                schedulerArray[i] = random.nextInt(4);
            }            

            if (schedulerArray[1] != schedulerArray[0]) {           /* Check if the teams are not the same*/
                Game game = new Game(convertTeamIDToTeamObj(schedulerArray[0]), 
                        convertTeamIDToTeamObj(schedulerArray[1]), temperature);

                game.determineScore(schedulerArray[0], schedulerArray[1], temperature);
                schedulerCounter++;
            }
        }
        
	System.out.println(gameAmount + " Games scheduled. (" + (gameAmount / 2) + " game for " + gameAmount + " teams)");        
        return true;
    }
    
    private Team convertTeamIDToTeamObj(int teamID) {
        switch (teamID) {
            case 0:
                return team1;
            case 1:
                return team2;
            case 2:
                return team3;
            case 3:
                return team4;
            default:
                return null;
        }
    }
    
    public void seasonOver() {
        team1.printResult();
        team2.printResult();
        team3.printResult();
        team4.printResult();
        Game game = new Game(team1);
    }
}
