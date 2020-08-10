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

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Open implements Action {

    private static final ArrayList<String> performAction = new ArrayList<>();

    static {
        try {
            try (InputStream inputStream = Look.class.getResourceAsStream("/openSyns.txt");
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                String contents = reader.lines().collect(Collectors.joining(System.lineSeparator()));

                //define file
                File synonyms = new File(contents);
                //instantiate scanner to read file
                Scanner synonymScanner = new Scanner(synonyms);

                //add to arraylist
                while((synonymScanner.hasNext())) {
                    performAction.add(synonymScanner.nextLine().toUpperCase().trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    //try to read file, if not, print stack trace
//    static {
//        try {
//            //locate the cvs txt file w/ synonyms
//            String fileLocation = "src" + File.separator + "com" + File.separator + "alienation" +
//                    File.separator + "coregamefiles" + File.separator + "parseinput" + File.separator +
//                    "inputsynonyms" + File.separator + "openSyns.txt";
//
//            //define the file by location
//            File synonyms = new File(fileLocation);
//
//            //instantiate scanner to read file
//            Scanner synonymScanner = new Scanner(synonyms);
//
//            //add to arraylist
//            while((synonymScanner.hasNext())) {
//                performAction.add(synonymScanner.nextLine().toUpperCase().trim());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static ArrayList<String> getPerformAction() {
        return performAction;
    }
}
