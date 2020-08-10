package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Oxygen;
import com.alienation.coregamefiles.charactersetc.Player;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.enums.Weapons;
import com.alienation.coregamefiles.parseinput.Input;
import com.alienation.enginefiles.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.alienation.coregamefiles.charactersetc.Player.*;
import static com.alienation.coregamefiles.enums.Items.OXYGEN;
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
            if (weapon.getName().equals(getItem1()) && getAvailableItemsMap().get(currentRoom).contains(getItem1())){
                addToInventory = true;
                addToWeaponsInventory(weapon);
            }
        }

        if(addToInventory && items.contains(getItem1())){
            try {
                if (getXItems().contains(getItem1())){
                    System.out.println(getAnsiRed() + "\nYou can't grab that!" + getAnsiReset());
                    Game.secondTextArea.setText("You can't grab that!");
//                    displayMenu();
                }
            }
            catch(IllegalArgumentException e){
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(getItem1().equals("oxygen")){
                Oxygen.incOxygen(100);
                System.out.println(getAnsiYellow() + "\nYou just increased " + getOxygenString() + " levels to " + Oxygen.getOxygen() +
                        getAnsiReset());
                Game.secondTextArea.setText("You just increased" + getOxygenString() + " levels to " + Oxygen.getOxygen());
                items.remove(getItem1());
                setAvailableItemsMap(currentRoom, items);
//                displayMenu();
            }

            System.out.println(getAnsiYellow() + "\n" + getItem1() + " added to Inventory." + getAnsiReset());
            Game.secondTextArea.setText(getItem1() + " added to Inventory.");
            List<String> newItems = getInventory();
            newItems.add(getItem1());
            setInventory(newItems);

            // delete item from room
            items.remove(getItem1());
            setAvailableItemsMap(currentRoom, items);

        }else if(Input.getItem1().equals("")){
            System.out.println(getAnsiRed() + "\n" + action.toString().toLowerCase() +
                    " what?" + getAnsiReset());
            Game.secondTextArea.setText(action.toString().toLowerCase()  +
                    "                     what?");
        }
        else if(addToInventory) {
            System.out.println(getAnsiRed() + "\n" + "That's not in this room." + getAnsiReset());
            Game.secondTextArea.setText("That's not in this room.");
        }
//        displayMenu();
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
