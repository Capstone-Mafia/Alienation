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

    private static final ArrayList<String> performAction = new ArrayList<>();
    String fileTitle = "lookSyns.txt";
    InputStream is = this.getClass().getResourceAsStream(File.separator + fileTitle);

    {

        try(BufferedReader fileReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(File.separator + fileTitle)))) {
            while(fileReader.ready()) performAction.add(fileReader.readLine().toUpperCase().trim());
        }
        catch(IOException e){
            System.out.println("Something went wrong with text parser");
        }
    }

    public static ArrayList<String> getPerformAction() {
        return performAction;
    }
}
