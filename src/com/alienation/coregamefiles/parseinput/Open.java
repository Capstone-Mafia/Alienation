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

import com.alienation.coregamefiles.enums.Rooms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.alienation.coregamefiles.charactersetc.Player.getCurrentRoom;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.GrabItems.grab;

public class Open implements Action {

    private static Object targetValue;

    //try to read file, if not, print stack trace
    public static Object performAction() {
        try {
            Rooms currentRoom = getCurrentRoom();
            //locate the cvs txt file w/ synonyms
            String fileLocation = "inputsynonyms" + File.separator + "openSyns.txt";

            //define the file by location
            File synonyms = new File(fileLocation);

            //instantiate scanner to read file
            Scanner synonymScanner = new Scanner(synonyms);

            //read one line at a time from file
            String nextLine = synonymScanner.nextLine().toUpperCase();

            //create list of the synonyms
            String[] allTheSynonyms = nextLine.split(", ");

            //look for this synonym among all the synonyms
            //if it's an approved synonym, do the thing. grab that thing.
            for (String theSynonym : allTheSynonyms) {
                if(theSynonym.equals(targetValue)) {
                    //do the thing: if the word they typed equals one of the "grab" words, then grab
                    grab(currentRoom);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return null;
        return null;
    }

//    //try to read file, if not, print stack trace
//    static {
//        try {
//            //locate the cvs txt file w/ synonyms
//            String fileLocation = "inputsynonyms" + File.separator + "openSyns.txt";
//
//            //define the file by location
//            File synonyms = new File(fileLocation);
//
//            //instantiate scanner to read file
//            Scanner synonymScanner = new Scanner(synonyms);
//
//            //read one line at a time from file
//            String nextLine = synonymScanner.nextLine();
//
//            //create list of the synonyms
//            String[] allTheSynonyms = nextLine.split(", ");
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void run(Scanner args) {
//        if (!args.hasNext())
//            throw new IllegalArgumentException(getAnsiRed() + "What do you want to open?" + getAnsiReset());
//        System.out.println(getAnsiCyan() + "Opening " + args.next() + getAnsiReset());
//    }
}
