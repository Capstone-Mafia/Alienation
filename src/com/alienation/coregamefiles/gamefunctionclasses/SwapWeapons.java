package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Player;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.enums.Weapons;
import com.alienation.coregamefiles.parseinput.Input;

import java.util.List;

import static com.alienation.coregamefiles.charactersetc.Player.*;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.*;

public class SwapWeapons {

    //swaps weapons
    public static void swap(Rooms currentRoom) throws Exception {
        final String space = "\n";
        final String lines = "************";

        List<String> playerInventory = getInventory();
        System.out.println("inventory" + playerInventory.toString());
        System.err.println(getWeaponInput());
        if(!Player.getWeaponsInventory().contains(getWeaponInput())){
            System.out.println(getAnsiRed() + "\nYou don't have any weapons in your inventory. " +
                    "Grab some weapons to swap!!" + getAnsiReset());
            displayMenu();
        }//else if(!Input.getItem1().equals("empty")){
            //setVerb(capitalizeAll(Input.getItem1()));
        //}
        else {
            System.out.println(space + getAnsiYellow() + "Which weapon would you like to hold?\n");
            System.out.println(lines);
            for (Object key : playerInventory) {
                System.out.println(key);
            }
            System.out.println(lines + getAnsiReset());
            Input.getInput();

            try {
                setItem1(capitalizeAll(Input.getItem1()));
                removeFromInventory(Input.getItem1());
                addToWeaponsInventory(getCurrentWeapon());


                /**
                 * remove that weapon input from the item list, and setCurrentWeapon with that weapon
                 *
                 * check if item exists in the inventory and replace the inventory with item
                 * does the method 'drop inventory' exist
                 */
            } catch (Exception e) {
                System.out.println(getAnsiRed() + "\nYou can't swap with that." + getAnsiReset());
            }
        }
        try {
            /**
             * Player keeps inventory. Check if weapon.getName() is in it
             */
            Weapons weapon = Weapons.findWeaponsByName(getItem1());
            setCurrentWeapon(weapon.getName());
            System.out.println(getAnsiYellow() + "\nYou are now holding a " + getAnswer() + "." + getAnsiReset());

        } catch(Exception e){
            System.out.println(getAnsiRed() + "\nYou can't swap with that." + getAnsiReset());
        }
        displayMenu();
    }
}
