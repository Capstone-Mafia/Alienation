package com.alienation.coregamefiles.hashmaps;

import com.alienation.coregamefiles.enums.Rooms;

import java.util.HashMap;
import java.util.Map;

public class DirectionsHashMap {
    private static Map<Rooms,Map<String, Rooms>> availableDirectionsMap = new HashMap<>();

    //Get Available Directions Map
    public static Map<Rooms,Map<String, Rooms>> getAvailableDirectionsMap() {
        Map<String, Rooms> roomsMap = new HashMap<String, Rooms>();
        roomsMap.put("N",Rooms.SupplyRoom);
        roomsMap.put("S",Rooms.ControlRoom);
        roomsMap.put("E",Rooms.AlienRoom);
        roomsMap.put("W",null);
        availableDirectionsMap.put(Rooms.CapsuleRoom, roomsMap);

        roomsMap = new HashMap<String, Rooms>();
        roomsMap.put("N",Rooms.Kitchen);
        roomsMap.put("S",null);
        roomsMap.put("E",null);
        roomsMap.put("W",Rooms.CapsuleRoom);
        availableDirectionsMap.put(Rooms.AlienRoom, roomsMap);

        roomsMap = new HashMap<String, Rooms>();
        roomsMap.put("N",null);
        roomsMap.put("S", Rooms.AlienRoom);
        roomsMap.put("E",null);
        roomsMap.put("W", Rooms.SupplyRoom);
        availableDirectionsMap.put(Rooms.Kitchen, roomsMap);

        roomsMap = new HashMap<String, Rooms>();
        roomsMap.put("N",null);
        roomsMap.put("S",Rooms.CapsuleRoom);
        roomsMap.put("E",Rooms.Kitchen);
        roomsMap.put("W",null);
        availableDirectionsMap.put(Rooms.SupplyRoom, roomsMap);

        roomsMap = new HashMap<String, Rooms>();
        roomsMap.put("N", Rooms.CapsuleRoom);
        roomsMap.put("S",null);
        roomsMap.put("E",null);
        roomsMap.put("W",null);
        availableDirectionsMap.put(Rooms.ControlRoom, roomsMap);

        return availableDirectionsMap;
    }
}
