package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.rooms.Room;
import com.alienation.enginefiles.Game;

import static com.alienation.coregamefiles.charactersetc.Player.setPreviousRoom;
import static com.alienation.coregamefiles.charactersetc.Player.setTempRoom;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.LoadRoom.loadRoom;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.displayMenu;
import static com.alienation.coregamefiles.hashmaps.DirectionsHashMap.getAvailableDirectionsMap;

public class MoveRoom {

    // Move Room from one to another
    public static void moveRoom(String direction, Rooms currentRoom) throws Exception {
        Rooms nextRoom = getNextRoom(direction, currentRoom);
        if(nextRoom != null){
            setPreviousRoom(currentRoom);
            setTempRoom(currentRoom);
            loadRoom(nextRoom);
        }
        else{
            System.out.println(getAnsiRed() + "\nThere doesn't seem to be a door this way.\n" + getAnsiReset());
            Game.secondTextArea.setText("There doesn't seem to be a door this way.");
//            displayMenu();
        }
    }

    public static Rooms getNextRoom(String direction, Rooms currentRoom){
        return getAvailableDirectionsMap().get(currentRoom).get(direction);

    }
}
