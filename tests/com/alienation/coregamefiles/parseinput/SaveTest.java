package com.alienation.coregamefiles.parseinput;

import junit.framework.TestCase;

import java.util.List;

public class SaveTest extends TestCase {

    private final List<String> testArray = Save.getPerformAction();

    public void testPrintGetPerformAction() {
        System.out.println(testArray);
    }

    public void testPrintGetPerformActionPositionOne() {
        String testArrayGet = testArray.get(0);
        String expectedOutput = "SAVE";
        assertEquals(expectedOutput, testArrayGet);
        System.out.println(testArrayGet);
    }

    public void testPrintGetPerformActionPositionTwo() {
        String testArrayGet = testArray.get(1);
        String expectedOutput = "FREEZE";
        assertEquals(expectedOutput, testArrayGet);
        System.out.println(testArrayGet);
    }

    public void testPrintGetPerformActionPositionLast() {
        String testArrayGet = testArray.get(testArray.size() - 1);
        String expectedOutput = "COMEBACK";
        assertEquals(expectedOutput, testArrayGet);
        System.out.println(testArrayGet);
    }

    public void testPrintGetPerformActionPositionNextToLast() {
        String testArrayGet = testArray.get(testArray.size() - 2);
        String expectedOutput = "HALT";
        assertEquals(expectedOutput, testArrayGet);
        System.out.println(testArrayGet);
    }

}