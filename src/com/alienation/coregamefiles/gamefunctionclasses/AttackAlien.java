package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Alien;
import com.alienation.coregamefiles.charactersetc.AlienObjects;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.enums.Weapons;
import com.alienation.coregamefiles.gameart.Death;
import com.alienation.coregamefiles.parseinput.Input;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.alienation.coregamefiles.charactersetc.Oxygen.getOxygen;
import static com.alienation.coregamefiles.charactersetc.Player.getCurrentWeapon;
import static com.alienation.coregamefiles.charactersetc.Player.getHealth;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.AlienAttack.alienAttack;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.*;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;


public class AttackAlien {

    /* -- AttackAlien the Alien in the room -- START */
    // Starting AttackAlien the Alien process in the room
    public static void attack(Rooms currentRoom) throws Exception {
        List<String> roomItems = getAvailableItemsMap().get(currentRoom);
        Set<String> aliens = new HashSet<>(Alien.getAlienNameList());

        setItem1(capitalizeAll(Input.getItem1()));
        setItem2(capitalizeAll(Input.getItem2()));

        if(roomItems.contains(getItem2()) || roomItems.contains(getItem1())) {
            try {
                //Optional<Alien> maybeAlien = Alien.getAlien(getItem1());
                Optional<Alien> maybeAlien = AlienObjects.getAlien(getItem1());

                if(maybeAlien.isPresent()){
                    Alien alien = maybeAlien.get();
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

                            alienAttack(currentRoom, alien);
                        }
                        else {
                            System.out.println(getAnsiRed() + "You don't have a weapon equipped to fight with. " +
                                    "Bad breath won't do!" + getAnsiReset());
                            displayMenu();
                        }
                    }
                }
                else {
                    System.out.println(getAnsiRed() + "\nYou can't attack that!" + getAnsiReset());
                    displayMenu();
                }
            } catch (Exception e) {
                System.out.println();
            }
        }else if(Input.getItem1().equals("empty")){
            System.out.println(getAnsiRed() + "\n" + capitalizeAll(action.toString().toLowerCase()) +
                    " what?" + getAnsiReset());
        }
        else {
            System.out.println(getAnsiRed() + "\n" + "That's not in this room." + getAnsiReset());
        }
        displayMenu();
    }
}
