package com.alienation.coregamefiles.charactersetc;

import com.alienation.coregamefiles.gameart.Death;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.alienation.coregamefiles.gameart.TextColors.getAnsiRed;
import static com.alienation.coregamefiles.gameart.TextColors.getAnsiReset;

public class OxygenTest extends TestCase {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Oxygen oxy = new Oxygen();

    public void testGetOxygen() {
    }

    public void testSetOxygen() {
    }

    public void testMinOxygen() {
    }

    public void testIncOxygen() {
    }

    public void testCheckOxyEmpty() {
//        oxy.oxygen = 0;
//        oxy.checkOxy();
//        System.setOut(new PrintStream(outContent));
//        String expectedOutput = "getAnsiRed() + \"\\n\\nOxygen depleted...\" + getAnsiReset()";
//        assertEquals(expectedOutput, outContent.toString());
    }

//    public void testCheckOxy() {
//        oxy.oxygen = 100;
//        System.setOut(new PrintStream(outContent));
//        String expectedOutput = "getAnsiRed() + \"\\n\\nOxygen depleted...\" + getAnsiReset()";
//    }
}