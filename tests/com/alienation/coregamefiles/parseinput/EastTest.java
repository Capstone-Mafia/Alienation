package com.alienation.coregamefiles.parseinput;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class EastTest extends TestCase {

    private final List<String> testArray = East.getPerformAction();

    public void testPrintGetPerformAction() {
        System.out.println(testArray);
    }

    public void testPrintGetPerformActionPositionOne() {
        System.out.println(testArray.get(0));
    }

    public void testPrintGetPerformActionPositionTwo() {
        String testArrayGet = testArray.get(1);
        String expectedOutput = "E";
        assertEquals(expectedOutput, testArrayGet);
        System.out.println(testArrayGet);
    }

    public void testPrintGetPerformActionPositionLast() {
        String testArrayGet = testArray.get(testArray.size() - 1);
        String expectedOutput = "RIGHT";
        assertEquals(expectedOutput, testArrayGet);
        System.out.println(testArrayGet);
    }
}