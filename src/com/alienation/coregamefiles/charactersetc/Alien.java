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


import com.alienation.coregamefiles.enums.Weapons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Alien Class
 */
public abstract class Alien {
    //private static Map<String,Map<String,Integer>> alienTypes = new HashMap<String,Map<String,Integer>>();
    int alienHP;

    public Alien() {

    }


    /**
     private static List<Alien> allAlienObjects;
     static {
     allAlienObjects.add(new AlienSuperhumanoid(50));
     allAlienObjects.add(new AlienHumanoid(10));
     allAlienObjects.add(new AlienCanine(6));
     allAlienObjects.add(new AlienVermin(4));

     }
     private static List<Alien> getAlienObjectList() {
     return allAlienObjects;
     }*/

    public Alien(int alienHP) {
        this.alienHP = alienHP;
    }

    public abstract String getAlienName();

    public abstract int getAlienDP();

    public abstract int getNewWeaponDamagePoints(Weapons weapons);

    public static List<String> alienNameList = new ArrayList<>();

    public static List<String> getAlienNameList() {
        return Arrays.asList("Vermin", "Canine", "Humanoid", "Superhumanoid");
    }

    public static Optional<Alien> getAlien(String alienName){
        return AlienObjects.getAlien(alienName);
    }

    /**
     public static Map<String> getAliens(){

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

     }
     */


    public void setHealthPoints(int alienNewHealthPoints){
        this.alienHP = alienNewHealthPoints;
    }

    public int getHealthPoints(){
        return alienHP;
    }


}
