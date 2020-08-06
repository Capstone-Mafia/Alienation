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

import java.security.SecureRandom;
import java.util.Scanner;

import static com.alienation.coregamefiles.enums.Actions.*;

/**
 * Receives all user Input
 */
public class Input {

    //create field for confirming verb synonym input with listed syns
    private static String checkVerb;



    private static String verb;
    private static String item1;
    private static String item2;

    public static Object getInput(){

        item1 = null;
        item2 = null;

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String delims = "[ ]+";
        String[] tokens = s.split(delims);

        verb = tokens[0];

        if (tokens.length == 1){
            item1 = "empty";
            item2 = "empty";
        }

        /**
         * Setting two variables of different lengths unnecessarily, make only one item1
         */
        if (tokens.length == 2){ // eat snickers
            item1 = tokens[1];
            item2 = "empty";

        }if (tokens.length == 3){ // grab oxygen tank
            item1 = tokens[1];
            item2 = item1 + " " + tokens[2];
        }

        return null;
    }

    /**capitalized before usage in case someone forgets to
     * and getUserResponse doesn't have to be capitalized, general input
     */
    public static String getActionInput() {
        return getVerb().toUpperCase();
    }

    public static String getVerb(){
        return verb;
    }

    public static String getItem1() {
        return item1;
    }

    public static String getItem2() {
        return item2;
    }

    public static void setVerb(String verb) {
        Input.verb = verb;
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
