package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.rooms.*;

import static com.alienation.coregamefiles.charactersetc.Player.setCurrentRoom;

public class LoadRoom {

    // Load the next room
    public static void loadRoom(Rooms newRoom) throws Exception {
        setCurrentRoom(newRoom);
        Room r = new CapsuleRoom();
        switch (newRoom){
            case AlienRoom:
                r = new AlienRoom();
                break;
            case Kitchen:
                r = new Kitchen();
                break;
            case SupplyRoom:
                r = new SupplyRoom();
                break;
            case ControlRoom:
                r = new ControlRoom();
                break;
        }
        r.loadEnvironment();
    }
}
