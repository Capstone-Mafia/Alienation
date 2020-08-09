package com.alienation.coregamefiles.hashmaps;

import com.alienation.coregamefiles.enums.Rooms;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.*;

public class AvailableItemsHashMap {

    private static Map<Rooms,List<String>> availableItemsMap = new HashMap<>();

    //Get available items for room from XML
    public static List<String> getAvailableItemsXML(NodeList nList){
        List<String> availableItems = new ArrayList<>();
        Element eElement = (Element) nList.item(0);
        NodeList childItems = eElement.getElementsByTagName("Item");
        for (int temp = 0; temp < childItems.getLength(); temp++) {
            availableItems.add(childItems.item(temp).getTextContent());
        }
        return availableItems;
    }

    /**
     * you're not letting each room class deal with its items
     * in objected oriented standpoint
     */
    // Get Available Items Map
    public static Map<Rooms, List<String>> getAvailableItemsMap() {
        if(availableItemsMap.size() == 0) {
            availableItemsMap.put(Rooms.CapsuleRoom, new ArrayList<String>(Arrays.asList("pods", "oxygen", "racks", "lockers")));
            availableItemsMap.put(Rooms.AlienRoom, new ArrayList<String>(Arrays.asList("humanoid", "bed", "mirror", "old box")));
            availableItemsMap.put(Rooms.Kitchen, new ArrayList<String>(Arrays.asList("refrigerator", "microwave", "cabinets", "dustbin", "snickers", "flamethrower")));
            availableItemsMap.put(Rooms.SupplyRoom, new ArrayList<String>(Arrays.asList("computer", "desk", "sofa", "racks", "supplies", "cage")));
            availableItemsMap.put(Rooms.ControlRoom, new ArrayList<String>(Arrays.asList("monitor", "control panel", "pilot seats", "laser", "chips")));
        }
        return availableItemsMap;
    }

    //set availableI items map
    public static void setAvailableItemsMap(Rooms key, List<String> items){
        availableItemsMap.remove(key);
        availableItemsMap.put(key, items);
    }

    public static void clearAvailableItemsMap() {
        availableItemsMap.clear();
    }

    public static <availableItems, room> void newRoomAvailableItemsMapPut(Rooms room, List<String> availableItems) {
        availableItemsMap.put(room,availableItems);
    }

}
