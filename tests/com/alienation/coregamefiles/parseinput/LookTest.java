package com.alienation.coregamefiles.parseinput;

import junit.framework.TestCase;

import java.util.Arrays;

public class LookTest extends TestCase {

    public void testGetPerformAction() {
        System.out.println(Look.getPerformAction());
        String[] testArray = Look.getPerformAction().toArray(new String[0]);
        System.out.println(Arrays.toString(testArray));
        System.out.println(testArray[0]);
    }
}