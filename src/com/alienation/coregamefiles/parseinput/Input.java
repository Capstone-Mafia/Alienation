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

package com.alienation.coregamefiles.parseinput;
import com.alienation.coregamefiles.enums.Actions;

import java.util.Objects;
import java.util.Scanner;

import static com.alienation.coregamefiles.enums.Actions.*;

/**
 * Receives all user Input
 */
public class Input {

    private static String actionInput;
    private static String item1;
    //private static String item2;

    private static Actions parsedAction;

    public static void getInput(){

        //item2 = null;

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String delims = "[ ]+";
        String[] tokens = s.split(delims);

        //don't accept empty input
        assert Objects.requireNonNull(tokens)[0] != null;

        //first word, verb or direction, is 0th place in tokens string array
        actionInput = tokens[0];
        item1 = tokens.length > 1 ? tokens[1] : " ";;

//        // item 1 and two are obs empty if there is only one item in the tokens array
//        if (tokens.length == 1){
//            item1 = "empty";
//            //item2 = "empty";
//        }

//        // if tokens array is two items, position 0 & 1
//        if (tokens.length == 2){ // eat snickers
//            item1 = tokens[1];
//            //item2 = "empty";
//        }
//
//        //if tokens array has three items, three words, positions 0,1, & 2
////        if (tokens.length == 3){ // grab oxygen tank
////            item1 = tokens[1];
////            item2 = item1 + " " + tokens[2];
////        }

        //TODO: fix this broken stuff
        //below if statements parse actionInput verbs for synonyms (once it's working)
        if (Look.getPerformAction().contains((getActionInput()))) {
            setParsedAction(LOOK);  //getParsedAction is called in Menu scanner
        }
        if (Open.getPerformAction().contains((getActionInput()))) {
            setParsedAction(OPEN);
        }
        if (Eat.getPerformAction().contains((getActionInput()))) {
            setParsedAction(EAT);
        }
        if (Grab.getPerformAction().contains((getActionInput()))) {
            setParsedAction(GRAB);
        }
        if (Attack.getPerformAction().contains((getActionInput()))) {
            setParsedAction(ATTACK);
        }
//        if (Read.getPerformAction().contains((getActionInput()))) {     //currently no logic for reading
//            setParsedAction(READ);
//        }
        if (Swap.getPerformAction().contains((getActionInput()))) {
            setParsedAction(SWAP);
        }
        if (North.getPerformAction().contains((getActionInput()))) {
            setParsedAction(NORTH);
        }
        if (South.getPerformAction().contains((getActionInput()))) {
            setParsedAction(SOUTH);
        }
        if (East.getPerformAction().contains((getActionInput()))) {
            setParsedAction(EAST);
        }
        if (West.getPerformAction().contains((getActionInput()))) {
            setParsedAction(WEST);
        }
        if (Options.getPerformAction().contains((getActionInput()))) {
            setParsedAction(OPTIONS);
        }
        if (Inventory.getPerformAction().contains((getActionInput()))) {
            setParsedAction(INVENTORY);
        }
        if (Run.getPerformAction().contains((getActionInput()))) {
            setParsedAction(RUN);
        }
        if (Save.getPerformAction().contains((getActionInput()))) {
            setParsedAction(SAVE);
        }
        if (Map.getPerformAction().contains((getActionInput()))) {
            setParsedAction(MAP);
        }
    }

    public static String getActionInput(){
        return actionInput.toUpperCase();
    }

    public static String getItem1() {
        return item1.toLowerCase();
    }

//    public static String getItem2() {
//        return item2;
//    }

    public static void setActionInput(String actionInput) {
        Input.actionInput = actionInput;
    }

    public static Actions getParsedAction() {
        return parsedAction;
    }

    public static void setParsedAction(Actions parsedAction) {
        Input.parsedAction = parsedAction;
    }

}
