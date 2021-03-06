package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Oxygen;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.enums.Weapons;
import com.alienation.coregamefiles.parseinput.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.alienation.coregamefiles.charactersetc.Player.*;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.*;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.setAvailableItemsMap;

public class GrabItems {

    // Grab the item from the room
    public static void grab(Rooms currentRoom) throws Exception {
        List<String> items = getAvailableItemsMap().get(currentRoom);

        setItem1(Input.getItem1());

        boolean addToInventory = true;

        for (Weapons weapon : Weapons.values()){
            if (weapon.getName().equalsIgnoreCase(getItem1()) && getAvailableItemsMap().get(currentRoom).contains(getItem1())){
                addToInventory = false;
                addToWeaponsInventory(weapon);
            }
        }

        if(items.contains(getItem1())){
            try {
                if (getXItems().contains(getItem1())){
                    System.out.println(getAnsiRed() + "\nYou can't grab that!" + getAnsiReset());
                    displayMenu();
                }
            }
            catch(IllegalArgumentException e){
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(Input.getItem1().equals("oxygen")){
                Oxygen.incOxygen(100);
                System.out.println(getAnsiYellow() + "\nYou just increased " + getOxygenString() + " levels to " + Oxygen.getOxygen() +
                        getAnsiReset());
                items.remove(getItem1());
                setAvailableItemsMap(currentRoom, items);
                displayMenu();
            }

            System.out.println(getAnsiYellow() + "\n" + getItem1() + " added to Inventory." + getAnsiReset());
            List<String> newItems = getInventory();
            newItems.add(Input.getItem1());
            setInventory(newItems);

            // delete item from room
            items.remove(getItem1());
            setAvailableItemsMap(currentRoom, items);

        }else if(getItem1().equals("")){
            System.out.println(getAnsiRed() + "\n" + action.toString().toLowerCase() +
                    " what?" + getAnsiReset());
        }
        else if(addToInventory) {
            System.out.println(getAnsiRed() + "\n" + "That's not in this room." + getAnsiReset());
        }
        displayMenu();
    }

    //Get items which user can't grab
    private static List<String> getXItems(){
        return new ArrayList<>(Arrays.asList("locker", "lockers", "pods", "cabinets", "computer", "desk", "sofa",
                "racks", "cage", "supplies", "refrigerator", "microwave", "dustbin",
                "monitor", "control Panel", "pilot seats", "pilot", "humanoid", "bed", "mirror", "old box", "old"));
    }
}
