package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.enums.Edibles;
import com.alienation.coregamefiles.enums.Rooms;

import java.util.List;

import static com.alienation.coregamefiles.charactersetc.Player.*;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gameart.TextColors.ANSI_RESET;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.*;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.setAvailableItemsMap;

public class EatItems {

    private static Edibles edible;

    // Eat the item from the room
    public static void eat(Rooms currentRoom) throws Exception {
        List<String> items = getAvailableItemsMap().get(currentRoom);

        setItem1(capitalizeAll(Input.getItem1()));; // Chips
        setItem2(capitalizeAll(Input.getItem2())); // Oxygen Tank

        if(items.contains(getItem2()) || items.contains(getItem1()) || getInventory().contains(getItem1())){
            try {
                edible = Edibles.valueOf(getItem1().toUpperCase());
                int edibleItems = 0;

                for(Edibles edible : Edibles.values()){
                    int healthPoints = edible.getHealthPoints();
                    if(items.contains(edible.getName())){
                        edibleItems++;
                        System.out.println(ANSI_YELLOW + "\nYou ate " + getItem1() + ".  HP ++" + ANSI_RESET);
                        //Increase health points
                        setHealth(healthPoints);
                        //Remove from available items of room
                        items.remove(edible.getName());
                        setAvailableItemsMap(currentRoom, items);
                    }else if(getInventory().contains(getItem1())){
                        edibleItems++;
                        System.out.println(ANSI_YELLOW + "\nYou ate " + getItem1() + ".  HP ++" + ANSI_RESET);
                        //Increase health points
                        setHealth(healthPoints);
                        List<String> newItems = getInventory();
                        newItems.remove(getItem1());
                        setInventory(newItems);
                    }
                }
                if(edibleItems == 0){
                    System.out.println(ANSI_RED + "There is nothing to eat!!" + ANSI_RESET);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI_RED + "\nYou can't eat that." + ANSI_RESET);
            }
        } else if(Input.getItem1().equals("empty")){
            System.out.println(ANSI_RED + "\n" + capitalizeAll(action.toString().toLowerCase()) +
                    " what?" + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED + "\n" + "That's not in this room or your inventory." + ANSI_RESET);
        }
        displayMenu();
    }
}
