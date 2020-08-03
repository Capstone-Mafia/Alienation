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
import java.util.Scanner;

import static com.alienation.coregamefiles.gameart.TextColors.*;

public class Eat implements Action {

    //try to read file, if not, print stack trace
    static {
        try {
            //locate the cvs txt file w/ synonyms
            String fileLocation = "inputsynonyms" + File.separator + "eatSyns.txt";

            //define the file by location
            File synonyms = new File(fileLocation);

            //instantiate scanner to read file
            Scanner synonymScanner = new Scanner(synonyms);

            //read one line at a time from file
            String nextLine = synonymScanner.nextLine();

            //create list of the synonyms
            String[] allTheSynonyms = nextLine.split(", ");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(Scanner args) {
        if (!args.hasNext())
            throw new IllegalArgumentException(getAnsiRed() + "What do you want to eat?" + getAnsiReset());
        System.out.println(getAnsiCyan() + "Eating " + args.next() + getAnsiReset());
    }
}
