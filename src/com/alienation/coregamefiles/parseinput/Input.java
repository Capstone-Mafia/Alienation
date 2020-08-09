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

import com.alienation.enginefiles.Game;

import java.util.Scanner;

/**
 * Receives all user Input
 */


public class Input {

    public static String grabInput;
    private static String verb;
    private static String item1;
    private static String item2;

    public static void getInput(){

        item1 = null;
        item2 = null;

        //Passes the text input from Game.java - Guru
        grabInput = Game.input;
//        System.out.println("We made it to input before if" + grabInput);
//        if (grabInput != "") {

            System.out.println("We made it to input in Input.java                                      " + grabInput);

//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        System.out.println("This is the input from original code                          " + s);
            String delims = "[ ]+";
            String[] tokens = grabInput.split(delims);
            System.out.println(tokens[0]);
            verb = tokens[0];


            if (tokens.length == 1) {
                item1 = "empty";
                item2 = "empty";
            }

            /**
             * Setting two variables of different lengths unnecessarily, make only one item1
             */
            if (tokens.length == 2) { // eat snickers
                item1 = tokens[1];
                item2 = "empty";

            }
            if (tokens.length == 3) { // grab oxygen tank
                item1 = tokens[1];
                item2 = item1 + " " + tokens[2];
            }
//        }
//        else {
//                System.out.println("Type what do you want to do next.");
//
//        }
//            Game.input = "";

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

}
