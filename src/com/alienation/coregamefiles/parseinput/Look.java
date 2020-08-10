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
import java.util.*;


public class Look implements Action {

    public static final ArrayList<String> performAction = new ArrayList<>();
    {
        String fileName= "src/com/alienation/resources/lookSyns.txt";
        try {
            InputStream is = getClass().getResourceAsStream(fileName);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            Scanner myReader = new Scanner(br);
            while (myReader.hasNextLine()) {
                performAction.add(myReader.nextLine().toUpperCase().trim());
            }
            myReader.close();
            br.close();
            isr.close();
            is.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getPerformAction() {
        return performAction;
    }
}
