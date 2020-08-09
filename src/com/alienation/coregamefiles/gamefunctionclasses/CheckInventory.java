package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.enums.Weapons;

import java.util.List;

import static com.alienation.coregamefiles.charactersetc.Player.getInventory;
import static com.alienation.coregamefiles.charactersetc.Player.getWeaponsInventory;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.displayMenu;

public class CheckInventory {

    // Get available items of a room
    public static void checkInventory() throws Exception {
        final String space = "\n";
        List<String> inventory = getInventory();
        List<Weapons> weaponsInventory = getWeaponsInventory();

        final String lines = "************";
        System.out.println(space + getAnsiYellow() + "Inventory\n");
        System.out.println(lines);
        for (Object item : inventory) {
            System.out.println(item);
        }
        System.out.println(lines + getAnsiReset());

        for (Object item : weaponsInventory) {
            System.out.println(item);
        }
        System.out.println(lines + getAnsiReset());

        displayMenu();
    }
}
