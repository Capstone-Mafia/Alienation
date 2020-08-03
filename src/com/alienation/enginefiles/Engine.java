/*
 *      Alienation
 *      TLG Learning: Capstone Project
 *      Originally Created by Team Alienation &&
 *      Edited by Team Capstone Mafia
 *      https://github.com/Capstone-Mafia
 *
 *      Team Alienation Members:
 *      Brad Smialek (https://github.com/bradsmialek)
 *      Dhruti Kosta (https://github.com/dhruti-kosta)
 *      Terrell Douglas (https://github.com/Dougie105)
 *      Original project repo:
 *      https://github.com/bradsmialek/Alienation
 *
 *      Capstone Mafia Members:
 *      Bruce West (https://github.com/BruceBAWest)
 *      Gurinder Batth (https://github.com/GurinderB)
 *      Daeun Lok (https://github.com/koreareefclub)
 *      Capstone Mafia fork:
 *      https://github.com/Capstone-Mafia/Alienation
 */

package com.alienation.enginefiles;
import com.alienation.coregamefiles.charactersetc.Oxygen;
import com.alienation.coregamefiles.charactersetc.Player;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.rooms.CapsuleRoom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

import static com.alienation.coregamefiles.gamefunctionclasses.LoadRoom.loadRoom;
import static com.alienation.coregamefiles.gamefunctionclasses.ResetData.initResetData;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.*;
import static java.lang.System.getProperty;

/**
 * Game Engine
 * This class is used to start the Engine of the game
 */
public class Engine {

    /*************** PUBLIC METHODS  ******************/
    // Method when our Game Engine starts
    public static void start() throws Exception {
        ResumeOrNewGame(false);
        //Does the game have a resume functionality where I can start while isDead ==true?
    }

    //User wants to resume old game or start new one
    public static void ResumeOrNewGame(Boolean isDead) throws Exception {
        if(!isDead) {
            File gameState = new File(getProperty("user.dir") + "\\SaveState.xml");
            if (gameState.exists()) {
                final String lines = "---------------------------------------------------------------------------------------------------------------------------------";
                System.out.println("\nDo you want to Resume Game<R> or Play New Game<N>??");
                System.out.println(lines);

                boolean repeat = true;
                boolean isNew = true;
                Scanner in = new Scanner(System.in);
                while (repeat) {
                    try {
                        String answer = in.nextLine(); //grabs input
                        if (answer.toUpperCase().equals("N")) {
                            gameState.delete();
                            repeat = false;
                        } else if (answer.toUpperCase().equals("R")) {
                            isNew = false;
                            repeat = false;
                        } else {
                            System.out.println("You must enter one of the following actions: R, N");
                            repeat = true;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("You must enter one of the following actions: R, N");
                        repeat = true;
                    }
                }
                if (!isNew) {
                    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
                    try {
                        DocumentBuilder builder = domFactory.newDocumentBuilder();
                        Document dDoc = builder.parse(gameState);
                        dDoc.getDocumentElement().normalize();

                        // Get Player Health
                        int currentHealth = Integer.parseInt(dDoc.getElementsByTagName("CurrentHealth").item(0).getTextContent());

                        Player.setHealth(currentHealth - Player.getHealth());
                        /**ideally Player is its own instance.
                         * and each cahracter will have its own getHealth method, so it should have instance method not
                         class method
                         bc there's only one character it's ok now. still not ideal*/

                        //Get Player Oxygen level
                        int currentOxygen = Integer.parseInt(dDoc.getElementsByTagName("CurrentOxygen").item(0).getTextContent()) + 10;
                        Oxygen.setOxygen(currentOxygen);

                        //Get Current Weapon
                        String currentWeapon = dDoc.getElementsByTagName("CurrentWeapon").item(0).getTextContent();
                        Player.setCurrentWeapon(currentWeapon);

                        //Get Temp Room
                        String tempRoom = dDoc.getElementsByTagName("TempRoom").item(0).getTextContent();
                        Player.setTempRoom(Rooms.valueOf(tempRoom));

                        //Get Previous Room
                        String previousRoom = dDoc.getElementsByTagName("PreviousRoom").item(0).getTextContent();
                        Player.setPreviousRoom(Rooms.valueOf(previousRoom));

                        //Get inventory
                        List<String> inventory = new ArrayList<>();
                        NodeList inventoryNodeList = dDoc.getElementsByTagName("Inventory");
                        Element eElement = (Element) inventoryNodeList.item(0);
                        NodeList childItems = eElement.getElementsByTagName("Item");
                        for (int temp = 0; temp < childItems.getLength(); temp++) {
                            inventory.add(childItems.item(temp).getTextContent());
                        }
                        Player.setInventory(inventory);

                        //Get Available Items Map
                        clearAvailableItemsMap();
                        for(Rooms room : Rooms.values()){
                            NodeList capsuleRoomNodeList = dDoc.getElementsByTagName(room.toString());
                            List<String> availableItems = getAvailableItemsXML(capsuleRoomNodeList);
                            newRoomAvailableItemsMapPut(room, availableItems);
                        }

                        //Get Current Room
                        String currentRoom = dDoc.getElementsByTagName("CurrentRoom").item(0).getTextContent();
                        loadRoom(Rooms.valueOf(currentRoom));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    new CapsuleRoom().loadEnvironment();
                }
            } else {
                new CapsuleRoom().loadEnvironment();
            }
        } else {
            initResetData();
            new CapsuleRoom().loadEnvironment();
        }
    }


    //Reset all data if user restarts the game
    private static void ResetData(){
        Player.setHealth(5);
        Player.setCurrentRoom(Rooms.AlienRoom);
        Player.setInventory(new ArrayList<String>());
        Player.setPreviousRoom(null);
        Player.setCurrentWeapon("Bad Breath");
        Player.setTempRoom(null);
        Oxygen.setOxygen(50);
        new CapsuleRoom().count = 0;
        //TODO store attackCount instead
        clearAvailableItemsMap();
    }