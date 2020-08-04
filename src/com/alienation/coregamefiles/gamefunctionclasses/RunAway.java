package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Alien;
import com.alienation.coregamefiles.enums.Rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.alienation.coregamefiles.charactersetc.Player.getPreviousRoom;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.LoadRoom.loadRoom;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.displayMenu;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;

public class RunAway {

    /********* run only if you're ********/
    // Run from alien to previous room
    public static void run(Rooms currentRoom) throws Exception {
        System.out.println("Before AlienList");
        //List<String> aliens = new ArrayList<>();
        List<String> aliens = Alien.getAlienNameList();
        System.out.println("AlienList");
        List<String> itemsInRoom = getAvailableItemsMap().get(currentRoom);

        boolean foundAlien = false;
        for (String key : itemsInRoom) {
            for(String alien : aliens){
                if(key.equals(alien)){
                    System.out.println(getAnsiRed() + "\n\nYou ran away as fast as you can!" + getAnsiReset());
                    loadRoom(getPreviousRoom());

                    foundAlien = true;
                }
            }
        }
        if(!foundAlien){
            System.out.println(getAnsiRed() + "\nYou can only run from an alien scaredy pants!" + getAnsiReset());
        }
        displayMenu();
    }
}
