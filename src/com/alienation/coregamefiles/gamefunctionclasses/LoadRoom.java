package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.rooms.*;

import static com.alienation.coregamefiles.charactersetc.Player.setCurrentRoom;

public class LoadRoom {

    // Load the next room
    public static void loadRoom(Rooms newRoom) throws Exception {
        setCurrentRoom(newRoom);
        switch (newRoom){
            case AlienRoom:
                AlienRoom.loadEnvironment();
                break;
            case Kitchen:
                Kitchen.loadEnvironment();
                break;
            case SupplyRoom:
                SupplyRoom.loadEnvironment();
                break;
            case ControlRoom:
                ControlRoom.loadEnvironment();
                break;
            default:
                CapsuleRoom.loadEnvironment();

        }

    }
}
