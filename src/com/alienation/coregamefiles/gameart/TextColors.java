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

package com.alienation.coregamefiles.gameart;

public class TextColors {
    /**********************
     *TEXT FONT COLORS
     **********************/
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    /**********************
     *TEXT BACKGROUND COLORS
     **********************/
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    /**********************
     *TEXT ATTRIBUTES
     **********************/
    private static final String ANSI_BOLD = "\u001B[1m";
    private static final String ANSI_UNDERSCORE = "\u001B[4m";
    private static final String ANSI_BLINK_ON = "\u001B[5m";

    /**********************
     *TEXT FONT GETTERS
     **********************/
    public static String getAnsiReset() {
        return ANSI_RESET;
    }

    public static String getAnsiBlack() {
        return ANSI_BLACK;
    }

    public static String getAnsiRed() {
        return ANSI_RED;
    }

    public static String getAnsiGreen() {
        return ANSI_GREEN;
    }

    public static String getAnsiYellow() {
        return ANSI_YELLOW;
    }

    public static String getAnsiBlue() {
        return ANSI_BLUE;
    }

    public static String getAnsiPurple() {
        return ANSI_PURPLE;
    }

    public static String getAnsiCyan() {
        return ANSI_CYAN;
    }

    public static String getAnsiWhite() {
        return ANSI_WHITE;
    }

    /**********************
     *TEXT BACKGROUND GETTERS
     **********************/
    public static String getAnsiBlackBackground() {
        return ANSI_BLACK_BACKGROUND;
    }

    public static String getAnsiRedBackground() {
        return ANSI_RED_BACKGROUND;
    }

    public static String getAnsiGreenBackground() {
        return ANSI_GREEN_BACKGROUND;
    }

    public static String getAnsiYellowBackground() {
        return ANSI_YELLOW_BACKGROUND;
    }

    public static String getAnsiBlueBackground() {
        return ANSI_BLUE_BACKGROUND;
    }

    public static String getAnsiPurpleBackground() {
        return ANSI_PURPLE_BACKGROUND;
    }

    public static String getAnsiCyanBackground() {
        return ANSI_CYAN_BACKGROUND;
    }

    public static String getAnsiWhiteBackground() {
        return ANSI_WHITE_BACKGROUND;
    }

    /**********************
     *TEXT ATTRIBUTE GETTERS
     **********************/
    public static String getAnsiBold() {
        return ANSI_BOLD;
    }

    public static String getAnsiUnderscore() {
        return ANSI_UNDERSCORE;
    }

    public static String getAnsiBlinkOn() {
        return ANSI_BLINK_ON;
    }
}
