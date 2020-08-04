package com.alienation.coregamefiles.gamefunctionclasses;

import java.util.List;

import static com.alienation.coregamefiles.charactersetc.Player.getInventory;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.displayMenu;

public class CheckInventory {

    // Get available items of a room
    public static void checkInventory() throws Exception {
        final String space = "\n";
        List<String> inventory = getInventory();

        final String lines = "************";
        System.out.println(space + getAnsiYellow() + "Inventory\n");
        System.out.println(lines);
        for (String item : inventory) {
            System.out.println(item);
        }
        System.out.println(lines + getAnsiReset());
        displayMenu();
    }
}
