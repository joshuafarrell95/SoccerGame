package soccergame;

import objects.*;

/**
 * AT1 Activity 2 OOP 2 - Soccer Game
 * 
 * @version             1.00 DD MMM YYYY
 * @author              Joshua Farrell
 */
public class SoccerGame {

	/*
     *  NOTE: Temperature is 32*F = 0*C
     */

    public static void main(String[] args) {

        Scheduler scheduler = new Scheduler();

        scheduler.acceptUserInput();
        
        scheduler.seasonOver();
            
//        Team t1 = new Team("Perth");
//        Team t2 = new Team("Thornlie");
//        Team t3 = new Team("Murdoch");
//        Team t4 = new Team("Rockingham");
//
//        Game g1 = new Game(t1, t2);
//        Game g2 = new Game(t3, t4);
//        Game g3 = new Game(t1, t3);
//        Game g4 = new Game(t2, t4);
//        Game g5 = new Game(t1, t4);
//        Game g6 = new Game(t2, t3);
//
//        System.out.println(t1.getTeamName());
//        System.out.println(t2.getTeamName());
//        System.out.println(t3.getTeamName());
//        System.out.println(t4.getTeamName());
//
//        System.out.println(t1.getTeamID());
//        System.out.println(t2.getTeamID());
//        System.out.println(t3.getTeamID());
//        System.out.println(t4.getTeamID());
//
//        t1.printResult();
//        t2.printResult();
//        t3.printResult();
//        t4.printResult();
//
//        g1.recordGame(t1);
//        g1.recordGame(t2);
//        g2.recordGame(t3);
//        g2.recordGame(t4);
//        g3.recordGame(t1);
//        g3.recordGame(t3);
//        g4.recordGame(t2);
//        g4.recordGame(t4);
//        g5.recordGame(t1);
//        g5.recordGame(t4);
//        g6.recordGame(t2);
//        g6.recordGame(t3);
//
//        g1.printGameStats(t1);
//        g1.printGameStats(t2);  
    }
}
