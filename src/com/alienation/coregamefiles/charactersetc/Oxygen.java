/*
 *      Alienation
 *      TLG Learning: Capstone Project
 *      Originally Created by Team Alienation &&
 *      Edited by Team Capstone Mafia
 *      https://github.com/Capstone-Mafia
 *
 *      Team Alienation Members:
 *      Brad Smialek (https://github.com/bradsmialek)
 *      Dhruti Kosta (https://github.com/dhruti-kosta)
 *      Terrell Douglas (https://github.com/Dougie105)
 *      Original project repo:
 *      https://github.com/bradsmialek/Alienation
 *
 *      Capstone Mafia Members:
 *      Bruce West (https://github.com/BruceBAWest)
 *      Gurinder Batth (https://github.com/GurinderB)
 *      Daeun Lok (https://github.com/koreareefclub)
 *      Capstone Mafia fork:
 *      https://github.com/Capstone-Mafia/Alienation
 */

package com.alienation.coregamefiles.charactersetc;

import com.alienation.coregamefiles.gameart.Death;
import com.alienation.enginefiles.Game;

import static com.alienation.coregamefiles.gameart.TextColors.*;
/**
 * Oxygen Class
 */
public class Oxygen {
    public static int oxygen = 300;
    public static int maxOxygen = 300;
    private static final String oTwo = "O\u2082"; // O₂

    //TODO: MAKE MAX OXYGEN
    public static int getOxygen() {
        return oxygen;
    }

    public static void setOxygen(int newOxygen) {
        Oxygen.oxygen = newOxygen;
    }

    //Decreases oxygen levels
    public static void minOxygen(int minusOxy) {
        if(Oxygen.oxygen - minusOxy < 0){
            Oxygen.oxygen = 0;
        } else {
            Oxygen.oxygen = Oxygen.oxygen - minusOxy;
        }
        System.out.println(getAnsiRed() + "-10 " + oTwo + getAnsiReset());
        Game.secondTextArea.setText("-10 ");
    }

    //Increases oxygen levels SETTERS
    public static void incOxygen(int incOxy) {
        if (oxygen+incOxy <= maxOxygen){
            Oxygen.oxygen = Oxygen.oxygen + incOxy;}
        else {
            oxygen = maxOxygen;
        }
    }

    // checks oxygen levels
    public static void checkOxy(){
        if(Oxygen.getOxygen() == 0){
            System.out.println(getAnsiRed() + "\n\nOxygen depleted..." + getAnsiReset()); // Better Death
            Death.death();
        }
    }
}