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

import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.enums.Weapons;
import com.alienation.tools.Time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.alienation.coregamefiles.gameart.TextColors.*;

/**
 * Player Class
 * This class used for maintaining characteristics for character like health points, current weapon.
 */
public class Player {

    /*************** PRIVATE VARIABLE DECLARATIONS  ******************/
    public static final int MAX_HEALTH = 100;
    public static final int MIN_HEALTH = 0;
    private static int health = 5;
    private static Weapons currentWeapon = Weapons.FLAMETHROWER;
    private static Rooms currentRoom = Rooms.CapsuleRoom; // as initial default
    private static Rooms previousRoom;
    private static Rooms tempRoom;
    private static List<String> inventory = new ArrayList<>();
    private static List<Weapons> weaponsInventory = new ArrayList<>();
    private static Time time = new Time();


    /*************** GETTER - SETTER METHODS  ******************/
    public static void setTime(Time time) {
        Player.time = time;
    }

    public static Time getTime() {
        return time;
    }

    public static int getHealth() {
        return health;

    }

    public static void setHealth(int newHealth) {
        if ((health + newHealth) > MAX_HEALTH) {
            health = MAX_HEALTH;
        } else if((Player.health + newHealth) < MIN_HEALTH) {
            health = MIN_HEALTH;
        } else {
            health += newHealth;
        }
    }

    public static void checkHealth(){
        if(health <= 20){
            System.out.println(getAnsiRed() + "\nHealth is LOW!" + getAnsiReset());
        }
    }

    public static Weapons getCurrentWeapon() {
        return currentWeapon;
    }

    public static void setCurrentWeapon(String newCurrentWeapon) {
        currentWeapon = Weapons.valueOf(newCurrentWeapon);
    }

    public static Rooms getCurrentRoom() {
        return currentRoom;
    }

    public static void setCurrentRoom(Rooms newCurrentRoom) {
        currentRoom = newCurrentRoom;
    }

    // Get available items in inventory
    public static List<String> getInventory(){
        return inventory;
    }

    public static List<Weapons> getWeaponsInventory(){
        return weaponsInventory;
    }

    // set available items updated items if item moved to Inventory or Eat an item
    public static void setInventory(List<String> newInventoryList) {
        inventory = newInventoryList;
    }
    public static void addToInventory(String newInventory) {
        getInventory().add(newInventory);
    }

    public static void addToWeaponsInventory(Weapons weaponsInventory) {
        getWeaponsInventory().add(weaponsInventory);
    }

    public static void removeFromWeaponsInventory(Weapons newInventory) {
        getWeaponsInventory().remove(newInventory);
    }

    public static void removeFromInventory(String newInventory) {
        getInventory().remove(newInventory);
    }
    public static void removeFromInventory(Object newInventory) {
        getInventory().remove(newInventory);
    }

    public static Rooms getPreviousRoom() {
        return previousRoom;
    }

    public static void setPreviousRoom(Rooms tempRoom) {
        previousRoom = tempRoom;
    }

    public static Rooms getTempRoom() {
        return tempRoom;
    }

    public static void setTempRoom(Rooms currentRoom) {
        tempRoom = currentRoom;
    }



}
