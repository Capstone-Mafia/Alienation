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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static com.alienation.coregamefiles.gameart.TextColors.*;

public class Grab implements Action {

    private static Object targetValue;

    //try to read file, if not, print stack trace
    static {
        try {
            //locate the cvs txt file w/ synonyms
            String fileLocation = "inputsynonyms" + File.separator + "grabSyns.txt";

            //define the file by location
            File synonyms = new File(fileLocation);

            //instantiate scanner to read file
            Scanner synonymScanner = new Scanner(synonyms);

            //read one line at a time from file
            String nextLine = synonymScanner.nextLine().toUpperCase();

            //create list of the synonyms
            String[] allTheSynonyms = nextLine.split(", ");

            for(String s : allTheSynonyms) {
                if (s.equals(targetValue)) {
                    String action = "GRAB";
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(Scanner args) {
        if (!args.hasNext())
            throw new IllegalArgumentException(getAnsiRed() + "What do you want to grab?" + getAnsiReset());
        System.out.println(getAnsiCyan() + "Grabbing " + args.next() + getAnsiReset());
    }
}
