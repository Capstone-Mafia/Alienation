package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Alien;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.enums.Weapons;
import com.alienation.coregamefiles.gameart.Death;

import java.util.List;
import java.util.Set;

import static com.alienation.coregamefiles.charactersetc.Oxygen.getOxygen;
import static com.alienation.coregamefiles.charactersetc.Player.getCurrentWeapon;
import static com.alienation.coregamefiles.charactersetc.Player.getHealth;
import static com.alienation.coregamefiles.gameart.TextColors.ANSI_RED;
import static com.alienation.coregamefiles.gameart.TextColors.ANSI_RESET;
import static com.alienation.coregamefiles.gamefunctionclasses.AlienAttack.alienAttack;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.*;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;

public class AttackAlien {

    /* -- AttackAlien the Alien in the room -- START */
    // Starting AttackAlien the Alien process in the room
    public static void attack(Rooms currentRoom) throws Exception {
        List<String> roomItems = getAvailableItemsMap().get(currentRoom);
        Set<String> aliens = Alien.getAliens().keySet();

        setItem1(capitalizeAll(Input.getItem1()));
        setItem2(capitalizeAll(Input.getItem2()));

        if(roomItems.contains(getItem2()) || roomItems.contains(getItem1())) {
            try {
                if(aliens.contains(getItem1())){
                    if(getHealth() == 0 || getOxygen() == 0) {
                        Death.death();
                    }
                    else {
                        System.out.println();
                        boolean hasWeapon = false;
                        for(Weapons weapon : Weapons.values()){
                            if(weapon.getName().equals(getCurrentWeapon())){
                                hasWeapon = true;
                                break;
                            }
                        }

                        if(hasWeapon) {
                            alienAttack(currentRoom, getItem1());
                        }
                        else {
                            System.out.println(ANSI_RED + "You don't have a weapon equipped to fight with. " +
                                    "Bad breath won't do!" + ANSI_RESET);
                            displayMenu();
                        }
                    }
                }
                else {
                    System.out.println(ANSI_RED + "\nYou can't attack that!" + ANSI_RESET);
                    displayMenu();
                }
            } catch (Exception e) {
                System.out.println();
            }
        }else if(Input.getItem1().equals("empty")){
            System.out.println(ANSI_RED + "\n" + capitalizeAll(action.toString().toLowerCase()) +
                    " what?" + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED + "\n" + "That's not in this room." + ANSI_RESET);
        }
        displayMenu();
    }
}