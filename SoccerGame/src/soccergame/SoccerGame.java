package soccergame;

import objects.*;
import exceptions.*;

/**
 * AT1 Activity 2 OOP 2 - Soccer Game
 * 
 * @version             1.00 DD MMM YYYY
 * @author              Joshua Farrell
 */
public class SoccerGame {

    public static void main(String[] args) {
        try {
            Team t1 = new Team("Perth");
            Team t2 = new Team("Thornlie");
            Team t3 = new Team("Murdoch");
            Team t4 = new Team("Rockingham");
            
            Game g1 = new Game();

            System.out.println(t1.teamName);
            System.out.println(t2.teamName);
            System.out.println(t3.teamName);
            System.out.println(t4.teamName);
            
            System.out.println(t1.teamID);
            System.out.println(t2.teamID);
            System.out.println(t3.teamID);
            System.out.println(t4.teamID);
            
            t1.printResult();
            t2.printResult();
            t3.printResult();
            t4.printResult();
            
            System.out.println(Team.teamCount);
            
                
        } catch (TeamLimitReachedException ex) {
            System.out.println(ex.toString());
        }
    }
}
