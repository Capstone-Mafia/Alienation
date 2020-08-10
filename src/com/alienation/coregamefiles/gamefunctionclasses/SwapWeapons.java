package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Player;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.enums.Weapons;
import com.alienation.coregamefiles.parseinput.Input;
import com.alienation.enginefiles.Game;

import java.util.List;

import static com.alienation.coregamefiles.charactersetc.Player.*;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.*;

public class SwapWeapons {

    //swaps weapons
    public static void swap(Rooms currentRoom) throws Exception {
        final String space = "\n";
        final String lines = "************";

        List<Weapons> playerInventory = getWeaponsInventory();

        System.out.println(space + getAnsiYellow() + "Which weapon would you like to hold?\n" + getAnsiReset());
        Game.secondTextArea.setText("Which weapon would you like to hold?");
        System.out.println(getAnsiYellow() + lines + getAnsiReset());
        for (Weapons key : playerInventory) {
            System.out.println(getAnsiYellow() + key + getAnsiReset());
        }

        System.out.println(getAnsiYellow() + lines + getAnsiReset());

        if(!Player.getWeaponsInventory().contains(getWeaponInput())) {

            System.out.println(getAnsiRed() + "\nYou don't have any weapons in your inventory. " +
                    "Grab some weapons to swap!!" + getAnsiReset());
            Game.secondTextArea.setText("You don't have any weapons in your inventory." +
                    "                    Grab some weapons to swap!!");
//            displayMenu();
            return;
        }

        try {
            setItem1(Input.getItem1());
            removeFromWeaponsInventory(Weapons.valueOf(Input.getItem1().toUpperCase()));
            addToWeaponsInventory(getCurrentWeapon());

            setCurrentWeapon(Input.getItem1().toUpperCase());

            System.out.println(getAnsiYellow() + "\nYou are now holding a " + getItem1() + "." + getAnsiReset());
            Game.secondTextArea.setText("You are now holding a " + getItem1());

        } catch (Exception e) {
            System.out.println(getAnsiRed() + "\nYou can't swap with that." + getAnsiReset());
            Game.secondTextArea.setText("You can't swap with that.");
        } finally {
            displayMenu();
        }
    }
}
