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

package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Player;
import com.alienation.coregamefiles.enums.*;
import com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap;
import com.alienation.coregamefiles.parseinput.*;

import static com.alienation.coregamefiles.charactersetc.Oxygen.getOxygen;
import static com.alienation.coregamefiles.charactersetc.Player.*;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.AttackAlien.attack;
import static com.alienation.coregamefiles.gamefunctionclasses.CheckInventory.checkInventory;
import static com.alienation.coregamefiles.gamefunctionclasses.EatItems.eat;
import static com.alienation.coregamefiles.gamefunctionclasses.GrabItems.grab;
import static com.alienation.coregamefiles.gamefunctionclasses.ImageViewer.viewer;
import static com.alienation.coregamefiles.gamefunctionclasses.InvestigateRoom.investigate;
import static com.alienation.coregamefiles.gamefunctionclasses.MoveRoom.moveRoom;
import static com.alienation.coregamefiles.gamefunctionclasses.OpenItems.open;
import static com.alienation.coregamefiles.gamefunctionclasses.RunAway.run;
import static com.alienation.coregamefiles.gamefunctionclasses.SaveGame.saveGameDataToFile;
import static com.alienation.coregamefiles.gamefunctionclasses.SwapWeapons.swap;
import static com.alienation.coregamefiles.parseinput.Input.*;

/**
 * Menu For Console
 * This class used to display Menu items to User and call related methods for actions on selected verbs.
 */
public class Menu {

    /*************** PRIVATE VARIABLE DECLARATIONS  ******************/
    private static final String actionQuestion = "What will you do? (o for options)";
    private static final String actions = "Try : look, open item , eat item, grab item, attack, read, swap, run, Map\n \n" +
            "CapsuleRoom started with: \"Pods\", \"Oxygen Tank\", \"Racks\", \"Lockers\"\n" +
            "AlienRoom started with: \"Humanoid\", \"Bed\", \"Mirror\", \"Old Box\"\n" +
            "Kitchen started with: \"Refrigerator\", \"Microwave\", \"Cabinets\", \"Dustbin\", \"Snickers\", \"Laser\"\n" +
            "SupplyRoom started with: \"Computer\", \"Desk\", \"Sofa\", \"Racks\", \"Supplies\", \"Cage\"\n" +
            "ControlRoom started with: \"Monitor\", \"Control Panel\", \"Pilot Seats\", \"Laser\", \"Chips\"";

    private static final String directions = "Try : N, north, S, South, e, W, west to move around\n";
    private static final String inv = "Check Inventory < i >";
    public static Actions action;
    private static final String saveGame = "Save the Game < save >";
    private static String answer;
    private static String item1;
//    private static String item2;  // removed item 2 from logic
    private static final String oxygen = "O\u2082"; // O₂

    /*************** PUBLIC METHODS  ******************/
    // This method used to display Menu to user
    public static void displayMenu() throws Exception {
        final String green = getAnsiGreen();
        final String end = getAnsiReset();
        final String lines = "---------------------------------------------------------------------------------------------------------------------------------";
        final String space = "         ";

        System.out.println("\n" + getActionQuestion() + "   " + space + "[HP " + green + getHealth() + end +
                "   " + getOxygenString() + " " + green  + getOxygen() + end + "   Wpn: " + getAnsiBlue() +
                getCurrentWeapon() + end  + "[Time passed: "+ Player.getTime().minutesElapsed() + "]");

        System.out.println(lines);

        boolean repeat = true;

        while (repeat) {
            try {
                Input.getInput();
                action = getParsedAction();
                repeat = false;
            } catch (IllegalArgumentException e) {
                System.out.println(getAnsiRed() + "Enter something." + getAnsiReset());
                repeat = true;
            }
        }
        Rooms currentRoom = getCurrentRoom();

        // Action verbs... things the character can do
        switch (action) {
            case LOOK:
                investigate(currentRoom);
                break;
            case OPEN:
                try {
                    assert item1 != null;
                    open(currentRoom);
                    break;
                } catch (Exception e) {
                    System.out.println("What do you want to open?");
                    displayMenu();
                }
            case EAT:
                try {
                    assert item1 != null;
                    eat(currentRoom);
                    break;
                } catch (Exception e) {
                    System.out.println("What do you want to eat?");
                    displayMenu();
                }
            case GRAB:
                try {
                    assert item1 != null;
                    grab(currentRoom);
                    break;
                } catch (Exception e) {
                    System.out.println("What do you want to grab?");
                    displayMenu();
                }
            case ATTACK:
                try {
                    assert item1 != null;
                    attack(currentRoom);
                    break;
                } catch (Exception e) {
                    System.out.println("What do you want to attack?");
                    displayMenu();
                }
            case SWAP:
                try {
                    assert item1 != null;
                    swap();
                    break;
                } catch (Exception e) {
                    System.out.println("What do you want to swap with?");
                    displayMenu();
                }
            case NORTH:
                moveRoom("N", currentRoom);
                break;
            case EAST:
                moveRoom("E", currentRoom);
                break;
            case SOUTH:
                moveRoom("S", currentRoom);
                break;
            case WEST:
                moveRoom("W", currentRoom);
                break;
            case OPTIONS:
                System.out.println("\n" + getAnsiBlue() + getActions() + "\n\n" + "Now you have: \n" + AvailableItemsHashMap.getAvailableItemsMap() + "\n\n" + getDirections() + "\n" + getInv() +
                        "\n" + getSaveGame() + getAnsiReset());
                displayMenu();
                break;
            case INVENTORY:
                checkInventory();
                break;
            case RUN:
                run(currentRoom);
                break;
            case SAVE:
                saveGameDataToFile();
                break;
            case MAP:
                viewer(currentRoom);
                break;
        }
    }

    /*************** GETTER - SETTER METHODS  ******************/
    private static String getActionQuestion() {
        return actionQuestion;
    }

    private static String getActions() {
        return actions;
    }

    private static String getDirections() {
        return directions;
    }

    private static String getInv(){
        return inv;
    }

    private static String getSaveGame(){
        return saveGame;
    }

    public static String getItem1() {
        return Input.getItem1();
    }

    public static void setItem1(String item1) {
        Menu.item1 = item1;
    }

    public static String getAnswer() {
        return answer;
    }

    public static void setVerb(String answer) {
        Menu.answer = answer;
    }

    public static Actions getAction() {
        return action;
    }

    public static void setAction(Actions action) {
        Menu.action = action;
    }

    public static String getOxygenString() {
        return oxygen;
    }

//    public static Weapons getWeaponInput(){
//        return Weapons.valueOf(Input.getItem1().toUpperCase());
//    }
}
