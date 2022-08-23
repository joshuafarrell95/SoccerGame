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
            
    public Scheduler() {
    }
    
    public boolean acceptUserInput() {
        try {
            System.out.print("What is today's Temperature (in Fahrenheit)? ");
            
            int userInput = scan.nextInt();
            
            if (userInput > 32) {
                scheduleGame(2, userInput);
            } else {
                return false;
            }
        } catch (InputMismatchException ex) {
            return false;
        }
        return true;
    }
    
    public boolean scheduleGame(int gameAmount, int temperature) {
        int[] schedulerArray = new int[2];
        int schedulerCounter = 0;
        boolean isScheduled = false;
        
        inner: while (schedulerCounter < gameAmount) {
            for (int i = 0; i < gameAmount; i++) {
                schedulerArray[i] = random.nextInt(4);
            }
            if (schedulerArray[1] != schedulerArray[0]) {           /* Check if the teams are not the same*/
                Game game = new Game(schedulerArray[0], schedulerArray[1], temperature);
                System.out.println(game.getGameID());
                game.determineScore(schedulerArray[0], schedulerArray[1], temperature);
                schedulerCounter++;
            }
        }
        
        System.out.println(gameAmount + " Games scheduled. (" + (gameAmount / 2) + " game for " + gameAmount + " teams)");
        return true;
    }
    
    public void seasonOver() {
        team1.printResult();
        team2.printResult();
        team3.printResult();
        team4.printResult();
    }
}
