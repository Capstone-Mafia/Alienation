package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Alien;
import com.alienation.coregamefiles.enums.Rooms;

import java.util.List;

import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gameart.TextColors.ANSI_RESET;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.displayMenu;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;

public class InvestigateRoom {

    // InvestigateRoom the room
    public static void investigate(Rooms currentRoom) throws Exception {
        final String space = "\n";
        final String lines = "************";
        System.out.println(space + ANSI_YELLOW + "You see:\n");
        System.out.println(lines);

        List<String> keys = getAvailableItemsMap().get(currentRoom);
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(lines + ANSI_RESET);
        for (String key : keys) {
            if(Alien.getAliens().containsKey(key)){
                switch (key){
                    case "Vermin":
                        System.out.println(ANSI_BLUE + "\nIt's a Vermin like Creature\n"+ ANSI_RESET);
                        break;
                    case "Canine":
                        System.out.println(ANSI_BLUE + "\nIt's a Canine like Creature\n"+ ANSI_RESET);
                        break;
                    case "Humanoid":
                        System.out.println(ANSI_BLUE + "\nIt looks like you found your crew mate, they look dismembered and there is a large bloody hole in their chest.\n"+
                                "You can see their insides squirming around, their eyes are black with bloody tears leaking from the corners. They notice you and it let's\n"+
                                "out a horrific bellowing growl. This is not your crew mate anymore ... it's coming to get you!!\n"+ ANSI_RESET);
                        break;
                    case "Superhumanoid":
                        System.out.println(ANSI_BLUE + "\nIt's a Super Humanoid Creature\n"+ ANSI_RESET);
                        break;
                }
            }
        }
        displayMenu();
    }
}
