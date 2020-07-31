package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Oxygen;
import com.alienation.coregamefiles.enums.Rooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.alienation.coregamefiles.charactersetc.Player.getInventory;
import static com.alienation.coregamefiles.charactersetc.Player.setInventory;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gameart.TextColors.ANSI_RESET;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.*;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.setAvailableItemsMap;

public class GrabItems {

    // Grab the item from the room
    public static void grab(Rooms currentRoom) throws Exception {
        List<String> items = getAvailableItemsMap().get(currentRoom);

        setItem1(capitalizeAll(Input.getItem1()));
        setItem2(capitalizeAll(Input.getItem2()));

        if(items.contains(getItem2()) || items.contains(getItem1())){
            try {
                if (getXItems().contains(getItem1())){
                    System.out.println(ANSI_RED + "\nYou can't grab that!" + ANSI_RESET);
                    displayMenu();
                }
            }
            catch(IllegalArgumentException e){
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(getItem2().equals("Oxygen Tank")){
                Oxygen.incOxygen(100);
                System.out.println(ANSI_YELLOW + "\nYou just increased " + getOxygenString() + " levels." +
                        ANSI_RESET);
                items.remove(getItem2());
                setAvailableItemsMap(currentRoom, items);
                displayMenu();
            }

            System.out.println(ANSI_YELLOW + "\n" + getItem1() + " added to Inventory." + ANSI_RESET);
            List<String> newItems = getInventory();
            newItems.add(getItem1());
            setInventory(newItems);

            // delete item from room
            items.remove(getItem1());
            setAvailableItemsMap(currentRoom, items);

        }else if(Input.getItem1().equals("empty")){
            System.out.println(ANSI_RED + "\n" + capitalizeAll(action.toString().toLowerCase()) +
                    " what?" + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED + "\n" + "That's not in this room." + ANSI_RESET);
        }
        displayMenu();
    }


    //Get items which user can't grab
    private static List<String> getXItems(){
        List<String> xItems = new ArrayList<>();
        xItems.addAll(Arrays.asList("Locker", "Pods", "Cabinets", "Computer", "Desk", "Sofa",
                "Racks", "Cage", "Supplies", "Refrigerator", "Microwave", "Dustbin",
                "Monitor", "Control Panel", "Pilot Seats", "Humanoid", "Bed", "Mirror", "Old Box"));
        return xItems;
    }

}
