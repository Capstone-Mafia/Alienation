package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.enums.Weapons;

import java.util.List;

import static com.alienation.coregamefiles.charactersetc.Player.getInventory;
import static com.alienation.coregamefiles.charactersetc.Player.setCurrentWeapon;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.*;

public class SwapWeapons {

    //swaps weapons
    public static void swap(Rooms currentRoom) throws Exception {
        final String space = "\n";
        final String lines = "************";

        setItem1(capitalizeAll(Input.getItem1())); // Chips
        setItem2(capitalizeAll(Input.getItem2())); // Oxygen Tank

        List<String> keys = getInventory();

        if(keys.size() == 0){
            System.out.println(getAnsiRed() + "\nYou don't have any weapons in your inventory. " +
                    "Grab some weapons to swap!!" + getAnsiReset());
            displayMenu();
        }else if(!Input.getItem1().equals("empty")){
            setAnswer(capitalizeAll(Input.getItem1()));
        }
        else {
            System.out.println(space + getAnsiYellow() + "Which weapon would you like to hold?\n");
            System.out.println(lines);
            for (String key : keys) {
                System.out.println(key);
            }
            System.out.println(lines + getAnsiReset());
            Input.getInput();

            try {
                setAnswer(capitalizeAll(Input.getVerb()));
                /**check if answer exists in the inventory and replace the inventory with answer
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
            Weapons weapon = Weapons.findWeaponsByName(getAnswer());
            setCurrentWeapon(weapon.getName());
            System.out.println(getAnsiYellow() + "\nYou are now holding a " + getAnswer() + "." + getAnsiReset());

        } catch(Exception e){
            System.out.println(getAnsiRed() + "\nYou can't swap with that." + getAnsiReset());
        }
        displayMenu();
    }
}
