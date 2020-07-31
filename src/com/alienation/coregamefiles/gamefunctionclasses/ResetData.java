package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Oxygen;
import com.alienation.coregamefiles.charactersetc.Player;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.rooms.CapsuleRoom;

import java.util.ArrayList;

import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.clearAvailableItemsMap;

public class ResetData {
    //Reset all data if user restarts the game
    private static void resetData(){
        Player.setHealth(5);
        Player.setCurrentRoom(Rooms.CapsuleRoom);
        Player.setInventory(new ArrayList<String>());
        Player.setPreviousRoom(null);
        Player.setCurrentWeapon("Bad Breath");
        Player.setTempRoom(null);
        Oxygen.setOxygen(50);
        new CapsuleRoom().count = 0;
        //TODO store attackCount instead
        clearAvailableItemsMap();
    }
    public static void initResetData() {
        resetData();
    }
}
