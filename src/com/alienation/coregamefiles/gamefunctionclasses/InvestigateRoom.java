package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Alien;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.enginefiles.Game;

import java.util.List;

import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.displayMenu;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;

public class InvestigateRoom {

    // InvestigateRoom the room
    public static void investigate(Rooms currentRoom) throws Exception {
        final String space = "\n";
        final String lines = "************";
        System.out.println(space + getAnsiYellow() + "You see:\n");
        Game.secondTextArea.setText("You see");
        System.out.println(lines);

        List<String> keys = getAvailableItemsMap().get(currentRoom);
        Game.secondTextArea.append((String.valueOf(keys)));
        for (String key : keys) {
            System.out.println(key);
            Game.secondTextArea.setText(String.valueOf(keys));

        }
        System.out.println(lines + getAnsiReset());
        for (String key : keys) {
            if(Alien.getAlienNameList().contains(key)){
                switch (key){
                    case "Vermin":
                        System.out.println(getAnsiBlue() + "\nIt's a Vermin like Creature\n"+ getAnsiReset());
                        Game.secondTextArea.setText("It's a Vermin like Creature");
                        break;
                    case "Canine":
                        System.out.println(getAnsiBlue() + "\nIt's a Canine like Creature\n"+ getAnsiReset());
                        Game.secondTextArea.setText("It's a Canine like Creature");
                        break;
                    case "Humanoid":
                        System.out.println(getAnsiBlue() + "\nIt looks like you found your crew mate, they look dismembered and there is a large bloody hole in their chest.\n"+
                                "You can see their insides squirming around, their eyes are black with bloody tears leaking from the corners. They notice you and it let's\n"+
                                "out a horrific bellowing growl. This is not your crew mate anymore ... it's coming to get you!!\n"+ getAnsiReset());
                        Game.secondTextArea.setText("It looks like you found your crew mate, they look dismembered and there is a large bloody hole in their chest.\\n\"+\n" +
                                "                                \"You can see their insides squirming around, their eyes are black with bloody tears leaking from the corners. They notice you and it let's\\n\"+\n" +
                                "                                \"out a horrific bellowing growl. This is not your crew mate anymore ... it's coming to get you!!");
                        break;
                    case "Superhumanoid":
                        System.out.println(getAnsiBlue() + "\nIt's a Super Humanoid Creature\n"+ getAnsiReset());
                        Game.secondTextArea.setText("It's a Super Humanoid Creature");
                        break;
                }
            }
        }
//        displayMenu();
    }
}
