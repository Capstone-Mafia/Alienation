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

package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Alien;
import com.alienation.coregamefiles.enums.*;
import com.alienation.coregamefiles.gameart.Death;
import com.alienation.enginefiles.Engine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.*;
import java.util.regex.Pattern;

import static com.alienation.coregamefiles.charactersetc.Oxygen.getOxygen;
import static com.alienation.coregamefiles.charactersetc.Player.*;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.AlienAttack.alienAttack;
import static com.alienation.coregamefiles.gamefunctionclasses.GrabItems.grab;
import static com.alienation.coregamefiles.gamefunctionclasses.ImageViewer.viewer;
import static com.alienation.coregamefiles.gamefunctionclasses.InvestigateRoom.investigate;
import static com.alienation.coregamefiles.gamefunctionclasses.MoveRoom.moveRoom;
import static com.alienation.coregamefiles.gamefunctionclasses.ReadThings.read;
import static com.alienation.coregamefiles.gamefunctionclasses.RunAway.run;
import static com.alienation.coregamefiles.gamefunctionclasses.SwapWeapons.swap;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.setAvailableItemsMap;

/**
 * Menu For Console
 * This class used to display Menu items to User and call related methods for actions on selected verbs.
 */
public class Menu {

    /*************** PRIVATE VARIABLE DECLARATIONS  ******************/
    private static String actionQuestion = "What will you do? (o for options)";
    private static String actions = "Try : look, open item , eat item, grab item, attack, read, swap, run, Map\n";
    private static String directions = "Try : N, north, S, South, e, W, west to move around\n";
    private static String inv = "Check Inventory < i >";
    public static Actions action;
    private static String saveGame = "Save the Game < save >";
    private static Edibles edible;
    private static CanOpen itemToOpen;
    private static String answer;
    private static String item1;
    private static String item2;
    private static final String oxygen = "O\u2082"; // O₂

    /*************** PUBLIC METHODS  ******************/
    // This method used to display Menu to user
    public static void displayMenu() throws Exception {
        final String green = ANSI_GREEN;
        final String end = ANSI_RESET;
        final String lines = "---------------------------------------------------------------------------------------------------------------------------------";
        final String space = "                                      ";

        System.out.println("\n" + getActionQuestion() + "   " + space + "[HP " + green + getHealth() + end +
                "   " + getOxygenString() + " " + green  + getOxygen() + end + "   Wpn: " + ANSI_BLUE +
                getCurrentWeapon() + end  + "]");
        System.out.println(lines);

        boolean repeat = true;

        while (repeat) {
            try {
                Input.getInput();
                action = Actions.valueOf(Input.getActionInput());
                repeat = false;
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI_RED + "Enter something." + ANSI_RESET);
                repeat = true;
            }
        }
        Rooms currentRoom = getCurrentRoom();
        Rooms nextRoom = null;

        /********* lots of unimplemented actions, could be simplified" *******/
        // Action verbs... things the character can do
        switch (action) {
            case INVESTIGATE:
            case SEE:
            case LOOK:
                investigate(currentRoom);
                break;
            case OPEN:
                open(currentRoom);
                break;
            case EAT:
            case DRINK:
                eat(currentRoom);
                break;
            case GRAB:
            case GET:
            case TAKE:
                grab(currentRoom);
                break;
            case FIGHT:
            case ATTACK:
                attack(currentRoom);
                break;
            case READ:
                read();
                break;
            case EQUIP:
            case HOLD:
            case SWAP:
                swap(currentRoom);
                break;
            case NORTH:
            case N:
                moveRoom("N", currentRoom);
                break;
            case EAST:
            case E:
                moveRoom("E", currentRoom);
                break;
            case SOUTH:
            case S:
                moveRoom("S", currentRoom);
                break;
            case WEST:
            case W:
                moveRoom("W", currentRoom);
                break;
            case OPTIONS:
            case O:
                System.out.println("\n" + ANSI_BLUE + getActions() + "\n" + getDirections() + "\n" + getInv() +
                        "\n" + getSaveGame() + ANSI_RESET);
                displayMenu();
                break;
            case INVENTORY:
            case I:
                CheckInventory();
                break;
            case RUN:
            case FLEE:
                run(currentRoom);
                break;
            case SAVE:
                saveGameDataToFile();
                break;
            case MAP:
                viewer(currentRoom);
                break;
        }

    }

    /* -- Attack the Alien in the room -- START */
    // Starting Attack the Alien process in the room
    public static void attack(Rooms currentRoom) throws Exception {
        List<String> roomItems = getAvailableItemsMap().get(currentRoom);
        Set<String> aliens = Alien.getAliens().keySet();

        item1 = capitalizeAll(Input.getItem1());
        item2 = capitalizeAll(Input.getItem2());

        if(roomItems.contains(item2) || roomItems.contains(item1)) {
            try {
                if(aliens.contains(item1)){
                    if(getHealth() == 0 || getOxygen() == 0) {
                        Death.death();
                    }
                    else {
                        System.out.println();
                        boolean hasWeapon = false;
                        for(Weapons weapon : Weapons.values()){
                            if(weapon.getName().equals(getCurrentWeapon())){
                                hasWeapon = true;
                                break;
                            }
                        }

                        if(hasWeapon) {
                            alienAttack(currentRoom, item1);
                        }
                        else {
                            System.out.println(ANSI_RED + "You don't have a weapon equipped to fight with. " +
                                    "Bad breath won't do!" + ANSI_RESET);
                            displayMenu();
                        }
                    }
                }
                else {
                    System.out.println(ANSI_RED + "\nYou can't attack that!" + ANSI_RESET);
                    displayMenu();
                }
            } catch (Exception e) {
                System.out.println();
            }
        }else if(Input.getItem1().equals("empty")){
            System.out.println(ANSI_RED + "\n" + Menu.capitalizeAll(action.toString().toLowerCase()) +
                    " what?" + ANSI_RESET);
        }
        else {
        System.out.println(ANSI_RED + "\n" + "That's not in this room." + ANSI_RESET);
        }
        displayMenu();
    }

    //Open something
    public static void open(Rooms currentRoom) throws Exception {
        item1 = capitalizeAll(Input.getItem1());; // Chips
        item2 = capitalizeAll(Input.getItem2()); // Oxygen Tank

        List<String> items = getAvailableItemsMap().get(currentRoom);

        if(items.contains(item2) || items.contains(item1)) {
            try {
                itemToOpen = CanOpen.valueOf(item1.toUpperCase()); // cage
                String upperAnswer = item1.toUpperCase();
                if (itemToOpen.toString().equals(upperAnswer)) { // new answer it cage
                    if(!getInventory().contains("Code")){ // make the key code not cage
                        System.out.println(ANSI_RED + "\nIt's locked" + ANSI_RESET);
                    }else{
                        System.out.println(ANSI_YELLOW + "\nNew item added to inventory."+ ANSI_RESET);
                        List<String> newItems = new ArrayList<>();
                        newItems = getInventory();
                        newItems.add("Ignition Switch");
                        // delete item from room and code from inventory
                        items.remove("Ignition Switch");
                        setAvailableItemsMap(currentRoom, items);
                        newItems.remove("Code");
                        setInventory(newItems);
                    }
                } else {
                    System.out.println("here");
                    displayMenu();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI_RED + "\nYou can't open that!" + ANSI_RESET);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(Input.getItem1().equals("empty")){
            System.out.println(ANSI_RED + "\n" + Menu.capitalizeAll(action.toString().toLowerCase()) +
                    " what?" + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED + "\n" + "That's not in this room." + ANSI_RESET);
        }
        displayMenu();
    }

//    // Grab the item from the room
//    public static void grab(Rooms currentRoom) throws Exception {
//        List<String> items = getAvailableItemsMap().get(currentRoom);
//
//        item1 = capitalizeAll(Input.getItem1());
//        item2 = capitalizeAll(Input.getItem2());
//
//        if(items.contains(item2) || items.contains(item1)){
//            try {
//                if (getXItems().contains(item1)){
//                    System.out.println(ANSI_RED + "\nYou can't grab that!" + ANSI_RESET);
//                    displayMenu();
//                }
//            }
//            catch(IllegalArgumentException e){
//                System.out.println();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            if(item2.equals("Oxygen Tank")){
//                Oxygen.incOxygen(100);
//                System.out.println(ANSI_YELLOW + "\nYou just increased " + oxygen + " levels." +
//                        ANSI_RESET);
//                items.remove(item2);
//                setAvailableItemsMap(currentRoom, items);
//                displayMenu();
//            }
//
//            System.out.println(ANSI_YELLOW + "\n" + item1 + " added to Inventory." + ANSI_RESET);
//            List<String> newItems = getInventory();
//            newItems.add(item1);
//            setInventory(newItems);
//
//            // delete item from room
//            items.remove(item1);
//            setAvailableItemsMap(currentRoom, items);
//
//        }else if(Input.getItem1().equals("empty")){
//            System.out.println(ANSI_RED + "\n" + Menu.capitalizeAll(action.toString().toLowerCase()) +
//                    " what?" + ANSI_RESET);
//        }
//        else {
//            System.out.println(ANSI_RED + "\n" + "That's not in this room." + ANSI_RESET);
//        }
//        displayMenu();
//    }

//    //Get items which user can't grab
//    private static List<String> getXItems(){
//        List<String> xItems = new ArrayList<>();
//        xItems.addAll(Arrays.asList("Locker", "Pods", "Cabinets", "Computer", "Desk", "Sofa",
//                "Racks", "Cage", "Supplies", "Refrigerator", "Microwave", "Dustbin",
//                "Monitor", "Control Panel", "Pilot Seats", "Humanoid", "Bed", "Mirror", "Old Box"));
//        return xItems;
//    }

    // Eat the item from the room
    public static void eat(Rooms currentRoom) throws Exception {
        List<String> items = getAvailableItemsMap().get(currentRoom);

        item1 = capitalizeAll(Input.getItem1());; // Chips
        item2 = capitalizeAll(Input.getItem2()); // Oxygen Tank

        if(items.contains(item2) || items.contains(item1) || getInventory().contains(item1)){
            try {
                edible = Edibles.valueOf(item1.toUpperCase());
                int edibleItems = 0;

                for(Edibles edible : Edibles.values()){
                    int healthPoints = edible.getHealthPoints();
                    if(items.contains(edible.getName())){
                        edibleItems++;
                        System.out.println(ANSI_YELLOW + "\nYou ate " + item1 + ".  HP ++" + ANSI_RESET);
                        //Increase health points
                        setHealth(healthPoints);
                        //Remove from available items of room
                        items.remove(edible.getName());
                        setAvailableItemsMap(currentRoom, items);
                    }else if(getInventory().contains(item1)){
                        edibleItems++;
                        System.out.println(ANSI_YELLOW + "\nYou ate " + item1 + ".  HP ++" + ANSI_RESET);
                        //Increase health points
                        setHealth(healthPoints);
                        List<String> newItems = getInventory();
                        newItems.remove(item1);
                        setInventory(newItems);
                    }
                }
                if(edibleItems == 0){
                    System.out.println(ANSI_RED + "There is nothing to eat!!" + ANSI_RESET);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI_RED + "\nYou can't eat that." + ANSI_RESET);
            }
        } else if(Input.getItem1().equals("empty")){
            System.out.println(ANSI_RED + "\n" + Menu.capitalizeAll(action.toString().toLowerCase()) +
                    " what?" + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED + "\n" + "That's not in this room or your inventory." + ANSI_RESET);
        }
        displayMenu();
    }

    // Get available items of a room
    public static void CheckInventory() throws Exception {
        final String space = "\n";
        List<String> inventory = getInventory();

        final String lines = "************";
        System.out.println(space + ANSI_YELLOW + "Inventory\n");
        System.out.println(lines);
        for (String item : inventory) {
            System.out.println(item);
        }
        System.out.println(lines + ANSI_RESET);
        displayMenu();
    }

    // utility function to capitalize first letter of each word
    public static String capitalizeAll(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return Pattern.compile("\\b(.)(.*?)\\b")
                .matcher(str)
                .replaceAll(match -> match.group(1).toUpperCase() + match.group(2));
    }

    //Start new or quit game when die/win
    public static void StartNewOrQuitGame(){
        File gameState = new File(System.getProperty("user.dir") + "\\SaveState.xml");
        if (gameState.exists()) {
            gameState.delete();
        }

        final String lines = "---------------------------------------------------------------------------------------------------------------------------------";
        System.out.println("\nDo you want to Start New Game?? Yes<Y> or No<N>");
        System.out.println(lines);

        boolean repeat = true;
        Scanner in = new Scanner(System.in);
        while (repeat) {
            try {
                String answer = in.nextLine(); //grabs input
                if (answer.toUpperCase().equals("Y")) {
                    Engine.ResumeOrNewGame(true);
                    repeat = false;
                } else if (answer.toUpperCase().equals("N")) {
                    System.exit(0);
                } else {
                    System.out.println("You must enter one of the following actions: Y, N");
                    repeat = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("You must enter one of the following actions: Y, N");
                repeat = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* -- Save the Game -- START */
    // Save the Game
    public static void saveGameDataToFile() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            //add elements to Document
            Element rootElement =
                    doc.createElementNS("", "GameState");
            //append root element to document
            doc.appendChild(rootElement);

            //append child elements to root element
            rootElement.appendChild(getGameElements(doc,"CurrentHealth",String.valueOf(getHealth())));
            rootElement.appendChild(getGameElements(doc,"CurrentOxygen",String.valueOf(getOxygen())));
            rootElement.appendChild(getGameElements(doc,"CurrentWeapon",String.valueOf(getCurrentWeapon())));
            rootElement.appendChild(getGameElements(doc,"CurrentRoom",String.valueOf(getCurrentRoom())));
            rootElement.appendChild(getGameElements(doc,"TempRoom",String.valueOf(getTempRoom())));
            rootElement.appendChild(getGameElements(doc,"PreviousRoom",String.valueOf(getPreviousRoom())));

            //append inventory list to root element
            rootElement.appendChild(getGameData(doc,"Inventory",getInventory()));

            //append room available item list to root element
            for (Rooms room : Rooms.values()) {
                rootElement.appendChild(getGameData(doc,room.toString(),getAvailableItemsMap().get(room)));
            }

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            //StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(System.getProperty("user.dir") + "\\SaveState.xml"));

            //write data
            //transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("We saved the game status!!");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node getGameData(Document doc, String element, List<String> items) {
        Element data = doc.createElement(element);
        for(String value : items){
            data.appendChild(getGameElements(doc, "Item", value));
        }
        return data;
    }

    //utility method to create text node
    private static Node getGameElements(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    /* -- Save the Game -- END */


    /*************** GETTER - SETTER METHODS  ******************/
    private static String getActionQuestion() {
        return actionQuestion;
    }

    private static String getActions() {
        return actions;
    }

    private static String getDirections() {
        return directions;
    }

    private static String getInv(){
        return inv;
    }

    public static void clear() {
        for (int i = 0; i < 25; ++i) System.out.println();
    }

    private static String getSaveGame(){
        return saveGame;
    }

    public static String getItem1() {
        return item1;
    }

    public static void setItem1(String item1) {
        Menu.item1 = item1;
    }

    public static String getItem2() {
        return item2;
    }

    public static void setItem2(String item2) {
        Menu.item2 = item2;
    }

    public static String getAnswer() {
        return answer;
    }

    public static void setAnswer(String answer) {
        Menu.answer = answer;
    }

    public static Actions getAction() {
        return action;
    }

    public static void setAction(Actions action) {
        Menu.action = action;
    }

    public static String getOxygenString() {
        return oxygen;
    }
}
