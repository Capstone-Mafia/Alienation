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

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

import static com.alienation.coregamefiles.charactersetc.Oxygen.getOxygen;
import static com.alienation.coregamefiles.charactersetc.Player.*;
import static com.alienation.coregamefiles.enums.Actions.*;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.AttackAlien.attack;
import static com.alienation.coregamefiles.gamefunctionclasses.CheckInventory.checkInventory;
import static com.alienation.coregamefiles.gamefunctionclasses.EatItems.eat;
import static com.alienation.coregamefiles.gamefunctionclasses.GrabItems.grab;
import static com.alienation.coregamefiles.gamefunctionclasses.ImageViewer.viewer;
import static com.alienation.coregamefiles.gamefunctionclasses.InvestigateRoom.investigate;
import static com.alienation.coregamefiles.gamefunctionclasses.MoveRoom.moveRoom;
import static com.alienation.coregamefiles.gamefunctionclasses.OpenItems.open;
import static com.alienation.coregamefiles.gamefunctionclasses.ReadThings.read;
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
    private static String actionQuestion = "What will you do? (o for options)";
    private static String actions = "Try : look, open item , eat item, grab item, attack, read, swap, run, Map\n \n";
//            "CapsuleRoom started with: \"Pods\", \"Oxygen Tank\", \"Racks\", \"Lockers\"\n" +
//            "AlienRoom started with: \"Humanoid\", \"Bed\", \"Mirror\", \"Old Box\"\n" +
//            "Kitchen started with: \"Refrigerator\", \"Microwave\", \"Cabinets\", \"Dustbin\", \"Snickers\", \"Laser\"\n" +
//            "SupplyRoom started with: \"Computer\", \"Desk\", \"Sofa\", \"Racks\", \"Supplies\", \"Cage\"\n" +
//            "ControlRoom started with: \"Monitor\", \"Control Panel\", \"Pilot Seats\", \"Laser\", \"Chips\"";

    private static String directions = "Try : North, South, East, West to move around\n";
    private static String inv = "Check Inventory < i >";
    public static Actions action;
    private static String saveGame = "Save the Game < save >";
    private static String answer;
    private static String item1;
    private static String item2;
    private static final String oxygen = "O\u2082"; // O₂

    /*************** PUBLIC METHODS  ******************/
    // This method used to display Menu to user
    public static void displayMenu() throws Exception {
        final String green = getAnsiGreen();
        final String end = getAnsiReset();
        final String lines = "---------------------------------------------------------------------------------------------------------------------------------";
        final String space = "                                      ";

        System.out.println("\n" + getActionQuestion() + "   " + space + "[HP " + green + getHealth() + end +
                "   " + getOxygenString() + " " + green  + getOxygen() + end + "   Wpn: " + getAnsiBlue() +
                getCurrentWeapon() + end  + "]");
        System.out.println(lines);

        boolean repeat = true;

        while (repeat) {
            try {
                Input.getInput();
                action = Actions.valueOf(Input.getActionInput());
                repeat = false;
            } catch (IllegalArgumentException e) {
                System.out.println(getAnsiRed() + "Enter something." + getAnsiReset());
                repeat = true;
            }
        }
        Rooms currentRoom = getCurrentRoom();
        Rooms nextRoom = null;

        /********* lots of unimplemented actions, could be simplified" *******/
        // Action verbs... things the character can do
        switch (action) {
//            case INVESTIGATE:
//            case SEE:
            case LOOK:
                investigate(currentRoom);
                break;
            case OPEN:
                open(currentRoom);
                break;
            case EAT:
//            case DRINK:
                eat(currentRoom);
                break;
            case GRAB:
//            case GET:
//            case TAKE:
                grab(currentRoom);
                break;
            case FIGHT:
            case ATTACK:
                attack(currentRoom);
                break;
            case READ:
                read();
                break;
            case EQUIP:
//            case HOLD:
            case SWAP:
                swap(currentRoom);
                break;
            case NORTH:
            case N:
                moveRoom("N", currentRoom);
                break;
            case EAST:
            case E:
                moveRoom("E", currentRoom);
                break;
            case SOUTH:
            case S:
                moveRoom("S", currentRoom);
                break;
            case WEST:
            case W:
                moveRoom("W", currentRoom);
                break;
            case OPTIONS:
            case O:
                System.out.println("\n" + getAnsiBlue() + getActions() + "\n" + getDirections() + "\n" + getInv() +
                        "\n" + getSaveGame() + getAnsiReset());
                displayMenu();
                break;
            case INVENTORY:
            case I:
                checkInventory();
                break;
            case RUN:
            case FLEE:
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

//    // utility function to capitalize first letter of each word
//    public static String capitalizeAll(String str) {
//        if (str == null || str.isEmpty()) {
//            return str;
//        }
//
//        return Pattern.compile("\\b(.)(.*?)\\b")
//                .matcher(str)
//                .replaceAll(match -> match.group(1).toUpperCase() + match.group(2));
//    }

    /*************** GETTER - SETTER METHODS  ******************/
    public static String getActionQuestion() {
        return actionQuestion;
    }

    public static String getActions() {
        return actions;
    }

    private static String getDirections() {
        return directions;
    }

    private static String getInv(){
        return inv;
    }

    public static void clear() {
        for (int i = 0; i < 25; ++i) System.out.println();
    }

    private static String getSaveGame(){
        return saveGame;
    }

    public static String getItem1() {
        return item1;
    }

    public static void setItem1(String item1) {
        Menu.item1 = item1;
    }

    public static String getItem2() {
        return item2;
    }

    public static void setItem2(String item2) {
        Menu.item2 = item2;
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

    public static Weapons getWeaponInput(){
        return Weapons.valueOf(item1.toUpperCase());
    }
}
