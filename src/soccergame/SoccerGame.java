package soccergame;

import objects.*;           /* Imports custom object package */

/**
 * AT1 Activity 2 OOP 2 - Soccer Game
 * 
 * @version             1.00 30 Aug 2022
 * @author              Joshua Farrell
 */
public class SoccerGame {

    /* NOTE: Temperature is 32*F = 0*C */
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        scheduler.acceptUserInput();
        scheduler.seasonOver();
    }
}
