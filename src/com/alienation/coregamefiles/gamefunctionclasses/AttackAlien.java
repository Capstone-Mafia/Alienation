package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Alien;
import com.alienation.coregamefiles.charactersetc.AlienObjects;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.enums.Weapons;
import com.alienation.coregamefiles.gameart.Death;
import com.alienation.coregamefiles.parseinput.Input;
import com.alienation.enginefiles.Game;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.alienation.coregamefiles.charactersetc.Oxygen.getOxygen;
import static com.alienation.coregamefiles.charactersetc.Player.*;
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

        setItem1(Input.getItem1());

        if(roomItems.contains(getItem2()) || roomItems.contains(getItem1())) {
            try {
                Optional<Alien> maybeAlien = AlienObjects.getAlien(getItem1());

                if(maybeAlien.isPresent()){
                    Alien alien = maybeAlien.get();
                    if(getHealth() == 0 || getOxygen() == 0) {
                        Death.death();
                    }


                    else {
                        /**
                        boolean hasWeapon = false;
                        for(Weapons weapon : Weapons.values()){
                            if(weapon.getName().equals(getCurrentWeapon())){
                                hasWeapon = true;
                                break;
                            }
                        }
                        */

                        alienAttack(currentRoom, alien);

                    }
                }
                else {
                    System.out.println(getAnsiRed() + "\nYou can't attack that!" + getAnsiReset());
                    Game.secondTextArea.setText("You can't attack that!");
//                    displayMenu();
                }
            } catch (Exception e) {
                System.out.println();
            }
        }else if(Input.getItem1().equals("empty")){
            System.out.println(getAnsiRed() + "\n" + action.toString().toLowerCase() +
                    " what?" + getAnsiReset());
        }
        else {
            System.out.println(getAnsiRed() + "\n" + "That's not in this room." + getAnsiReset());
            Game.secondTextArea.setText("That's not in this room.");
        }
//        displayMenu();
    }
}
