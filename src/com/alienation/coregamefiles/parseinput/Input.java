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
    private static String item2;

    private static Actions parsedAction;

    public static void getInput(){

        item1 = null;
        item2 = null;

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String delims = "[ ]+";
        String[] tokens = s.split(delims);

        //first word, verb or direction, is 0th place in tokens string array
        actionInput = tokens[0];

        //don't accept empty input
        assert Objects.requireNonNull(tokens)[0] != null;



        if (tokens.length == 1){
            item1 = "empty";
            item2 = "empty";
        }

        if (tokens.length == 2){ // eat snickers
            item1 = tokens[1];
            item2 = "empty";
        }

        if (tokens.length == 3){ // grab oxygen tank
            item1 = tokens[1];
            item2 = item1 + " " + tokens[2];
        }

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
        if (Read.getPerformAction().contains((getActionInput()))) {
            setParsedAction(READ);
        }
        if (Swap.getPerformAction().contains((getActionInput()))) {
            setParsedAction(SWAP);
        }
    }

    public static String getActionInput(){
        return actionInput.toUpperCase();
    }

    public static String getItem1() {
        return item1;
    }

    public static String getItem2() {
        return item2;
    }

    public static void setActionInput(String actionInput) {
        Input.actionInput = actionInput;
    }

    public static Actions getParsedAction() {
        return parsedAction;
    }

    public static void setParsedAction(Actions parsedAction) {
        Input.parsedAction = parsedAction;
    }


    //TODO: try While loop that runs search with the desired word through each of the .txt files, one after the other
    // put them all in a try catch, then nested If statements.
    // set a boolean (condition for while loop), first search first txt, if found, reset bool to true
    // if not the first one, then check if in next one, etc

    //pulled the below out of Menu, because it has no place in menu.
    //need to use some form of the below logic, fixed to repair broken shit, and use it to setVerb
//    if(Look.performAction()) {
//        setVerb(LOOK);
//    }
//    if(Open.performAction()) {
//        setVerb(OPEN);
//    }
//    if(Eat.performAction()) {
//        setVerb(EAT);
//    }
//    if(Grab.performAction()) {
//        setVerb(GRAB);
//    }
//    if(Attack.performAction()) {
//        setVerb(ATTACK);
//    }
//    if(Read.performAction()) {
//        setVerb(READ);
//    }
//    if(Swap.performAction()) {
//        setVerb(SWAP);
//    }

}
