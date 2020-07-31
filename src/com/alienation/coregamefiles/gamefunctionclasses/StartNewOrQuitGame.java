package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.enginefiles.Engine;

import java.io.File;
import java.util.Scanner;

public class StartNewOrQuitGame {

    //Start new or quit game when die/win
    public static void startNewOrQuitGame(){
        File gameState = new File(System.getProperty("user.dir") + "\\SaveState.xml");
        if (gameState.exists()) {
            gameState.delete();
        }

        final String lines = "---------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("\nDo you want to Start New Game?? Yes<Y> or No<N>");
        System.out.println(lines);

        boolean repeat = true;
        Scanner in = new Scanner(System.in);
        while (repeat) {
            try {
                String answer = in.nextLine(); //grabs input
                if (answer.toUpperCase().equals("Y")) {
                    Engine.ResumeOrNewGame(true);
                    repeat = false;
                } else if (answer.toUpperCase().equals("N")) {
                    System.exit(0);
                } else {
                    System.out.println("You must enter one of the following actions: Y, N");
                    repeat = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("You must enter one of the following actions: Y, N");
                repeat = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
