package objects;

import exceptions.TeamLimitReachedException;
import exceptions.TemperatureTooLowException;
import java.util.HashSet;
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
    
    public String acceptUserInput() throws TemperatureTooLowException {
        try {
            int userInput = scan.nextInt();
            
            if (userInput > 32) {
                scheduleGame(2, userInput);
            } else {
                throw new TemperatureTooLowException();
            }
            
            
        }
        catch (TemperatureTooLowException ex) {
            
        }
        catch (InputMismatchException ex) {
            
        }
        return "Test";
    }
    
    public String scheduleGame(int gameAmount, int temperature) {
        int[] schedulerArray = new int[2];
        int firstValue;
        int secondValue;
        boolean isScheduled = false;
        
        outer: while (!isScheduled) {
            for (int i = 0; i < gameAmount; i++) {
                schedulerArray[i] = random.nextInt(4);
                System.out.println(schedulerArray[i]);
            }
            System.out.println("=-=-=-=");
            if (schedulerArray[1] != schedulerArray[0]) {
                    
                Team.setTeamWinTotal(schedulerArray[0], Team.getTeamWinTotal(1) + 2);
                isScheduled = true;
                break outer;
            }
        }       
        return gameAmount + "Games scheduled. (" + (gameAmount / 2) + " game for " + gameAmount + " teams.)";
    }
    
    public void seasonOver() {
        team1.printResult();
        team2.printResult();
        team3.printResult();
        team4.printResult();
    }
}
