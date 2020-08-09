package com.alienation.coregamefiles;

import com.alienation.coregamefiles.charactersetc.Player;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bradsmialek on Thu - 7/16/20 @ 12:45 PM
 */
public class InventoryTest extends TestCase {

    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Player.setInventory(new ArrayList<String>( Arrays.asList() ));
    }

    public void testSwapItem() throws Exception {
        Player.addToInventory("apple");
        List<String> expectedList = new ArrayList<>();
        expectedList.add("apple");
        List<String> invetoryList = Player.getInventory();
        assertEquals(expectedList, invetoryList);
    }

    public void testRemoveItem() throws Exception {

        Player.setInventory(new ArrayList<String>( Arrays.asList("alex", "brian", "charles") ));

        Player.removeFromInventory("alex");

        assertEquals(Player.getInventory(), Arrays.asList("brian", "charles"));
    }



}
