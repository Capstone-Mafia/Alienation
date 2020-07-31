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

import java.util.*;

/**
 * Alien Class
 */
public class Alien {
    private static Map<String,Map<String,Integer>> alienTypes = new HashMap<String,Map<String,Integer>>();

    // Get the alien
    public static Map<String,Map<String,Integer>> getAliens(){
        if(alienTypes.size() == 0) {
            Map<String, Integer> alienPointWorth = new HashMap<>();
            alienPointWorth.put("HP", 4);
            alienPointWorth.put("DP", 1);
            alienTypes.put("Vermin", alienPointWorth);

            alienPointWorth = new HashMap<>();
            alienPointWorth.put("HP", 6);
            alienPointWorth.put("DP", 3);
            alienTypes.put("Canine", alienPointWorth);

            alienPointWorth = new HashMap<>();
            alienPointWorth.put("HP", 10);
            alienPointWorth.put("DP", 5);
            alienTypes.put("Humanoid", alienPointWorth);

            alienPointWorth = new HashMap<>();
            alienPointWorth.put("HP", 50);
            alienPointWorth.put("DP", 10);
            alienTypes.put("Superhumanoid", alienPointWorth);
        }
        return alienTypes;
    }


    /*************** GETTER - SETTER METHODS  ******************/
    //Get HP/DP points
    public static int getPoints(String alienType,String key){
        return alienTypes.get(alienType).get(key);
    }

    //Set HP/DP points
    public static void setPoints(String alienType, String key, int points){
        alienTypes.get(alienType).replace(key, points);
    }
    //TODO: build in weakness and immunity
}

