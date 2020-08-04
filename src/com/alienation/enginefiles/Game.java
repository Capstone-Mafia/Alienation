package com.alienation.enginefiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.alienation.coregamefiles.charactersetc.Alien;
import com.alienation.coregamefiles.charactersetc.Oxygen;
import com.alienation.coregamefiles.charactersetc.Player;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.gameart.Banner;
import com.alienation.coregamefiles.gamefunctionclasses.ImageViewer;
import com.alienation.coregamefiles.gamefunctionclasses.Menu;
import com.alienation.coregamefiles.gamefunctionclasses.MoveRoom;
import com.alienation.coregamefiles.rooms.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.alienation.coregamefiles.charactersetc.Player.getCurrentRoom;
import static com.alienation.coregamefiles.enums.Rooms.*;
import static com.alienation.coregamefiles.gamefunctionclasses.LoadRoom.loadRoom;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.*;
import static com.alienation.coregamefiles.rooms.CapsuleRoom.getStory;
import static java.lang.System.getProperty;

public class Game {

    JFrame window;
//    Container con;
    static JPanel titleNamePanel, infoPanel, mainMapPanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    static JLabel titleNameLabel, carMapLabel, corMapLabel, arMapLabel, srMapLabel, kMapLabel, mainMapLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    static Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    static Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    static JButton startButton, choice1, choice2, choice3, choice4;
    static JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon;
    static String position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();



    public static void main(String[] args) {

        new Game();
    }

    public Game(){

        //Main Game window
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        //Title panel
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(0, 50, 800, 150);
        titleNamePanel.setBackground(Color.cyan);

//        titleNameLabel = new JLabel(Banner.getBanner(), JLabel.CENTER);
        titleNameLabel = new JLabel("Alienation");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        //Info Panel
        infoPanel = new JPanel();
        infoPanel.setBounds(0, 0, 800, 50);
        infoPanel.setBackground(Color.blue);
        infoPanel.setLayout(new GridLayout(1,4));

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        infoPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        infoPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        infoPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        infoPanel.add(weaponLabelName);
        weaponLabelName.setText(Player.getCurrentWeapon());
        hpLabelNumber.setText(Integer.toString(Player.getHealth()));

        //Start Button
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);


        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        //Adding panels to windows
        window.add(titleNamePanel);
        window.add(startButtonPanel);
        window.add(infoPanel);
        window.setVisible(true);

    }

    public void createGameScreen() throws Exception {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
//        infoPanel.setVisible(false);

        //Map Pannel
        mainMapPanel = new JPanel();
        mainMapPanel.setBounds(0, 50, 400, 350);
        mainMapPanel.setBackground(Color.black);
        window.add(mainMapPanel);

//        // Map Label
//        BufferedImage img = null;
//        // TODO: Fix Image path. make it look like image viewer.
//        String imgPath = "/com/alienation/resources/" + "CapsuleRoom.png";
//        img = ImageIO.read(getClass().getResource(imgPath));
//        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
//        ImageIcon imgIcon = new ImageIcon(dimg);
//        mainMapLabel = new JLabel();
//        mainMapLabel.setIcon(imgIcon);
//        mainMapPanel.add(mainMapLabel);


        //Main text panel.
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(400, 50, 400, 350);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);
//        window.pack();

        // Adding text field to text panel.
        mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
        mainTextArea.setBounds(400, 50, 395, 350);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
//        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // Create button panel.
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(0, 500, 800, 50);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(1, 4));
        window.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        capsuleRoom();
//        new CapsuleRoom().loadEnvironment();

//        playerPanel = new JPanel();
//        playerPanel.setBounds(100, 15, 600, 50);
//        playerPanel.setBackground(Color.black);
//        playerPanel.setLayout(new GridLayout(1,4));
//        window.add(playerPanel);
//        hpLabel = new JLabel("HP:");
//        hpLabel.setFont(normalFont);
//        hpLabel.setForeground(Color.white);
//        playerPanel.add(hpLabel);
//        hpLabelNumber = new JLabel();
//        hpLabelNumber.setFont(normalFont);
//        hpLabelNumber.setForeground(Color.white);
//        playerPanel.add(hpLabelNumber);
//        weaponLabel = new JLabel("Weapon:");
//        weaponLabel.setFont(normalFont);
//        weaponLabel.setForeground(Color.white);
//        playerPanel.add(weaponLabel);
//        weaponLabelName = new JLabel();
//        weaponLabelName.setFont(normalFont);
//        weaponLabelName.setForeground(Color.white);
//        playerPanel.add(weaponLabelName);
//
//        playerSetup();
//
    }
//    public void playerSetup(){
//        playerHP = 15;
//        monsterHP = 20;
//        weapon = "Knife";
//        weaponLabelName.setText(weapon);
//        hpLabelNumber.setText("" + playerHP);
//
//        townGate();
//    }
    public void capsuleRoom() throws Exception {
//        new CapsuleRoom().loadEnvironment();
        position = "CapsuleRoom";
        // Map Label
        BufferedImage img = null;
        // TODO: Fix Image path. make it look like image viewer.
        String imgPath = "/com/alienation/resources/" + "CapsuleRoom.png";
        img = ImageIO.read(getClass().getResource(imgPath));
        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(dimg);
        carMapLabel = new JLabel();
        carMapLabel.setIcon(imgIcon);
        mainMapPanel.add(carMapLabel);
        mainTextArea.setText(getStory());
        choice1.setText("North");
        choice2.setText("South");
        choice3.setText("East");
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(true);
        choice4.setVisible(false);
    }
    public void supplyRoom() throws IOException {
        position = "SupplyRoom";
        mainTextArea.setText(com.alienation.coregamefiles.rooms.SupplyRoom.getStory());
        BufferedImage img = null;
        // TODO: Fix Image path. make it look like image viewer.
        String imgPath = "/com/alienation/resources/" + "SupplyRoom.png";
        img = ImageIO.read(getClass().getResource(imgPath));
        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(dimg);
        srMapLabel = new JLabel();
        srMapLabel.setIcon(imgIcon);
        mainMapPanel.add(srMapLabel);
        srMapLabel.setVisible(true);

        choice1.setText("South");
        choice2.setText("East");
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void controlRoom() throws IOException {
        position = "ControlRoom";
        mainTextArea.setText(com.alienation.coregamefiles.rooms.ControlRoom.getStory());
        // Map Label
        BufferedImage img = null;
        // TODO: Fix Image path. make it look like image viewer.
        String imgPath = "/com/alienation/resources/" + "ControlRoom.png";
        img = ImageIO.read(getClass().getResource(imgPath));
        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(dimg);
        corMapLabel = new JLabel();
        corMapLabel.setIcon(imgIcon);
        mainMapPanel.add(corMapLabel);
        corMapLabel.setVisible(true);
//        playerHP = playerHP -3;
//        hpLabelNumber.setText(""+playerHP);
        choice1.setText("North");
        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void alienRoom() throws IOException {
        position = "AlienRoom";
        mainTextArea.setText(com.alienation.coregamefiles.rooms.AlienRoom.getStory());
        BufferedImage img = null;
        // TODO: Fix Image path. make it look like image viewer.
        String imgPath = "/com/alienation/resources/" + "AlienRoom.png";
        img = ImageIO.read(getClass().getResource(imgPath));
        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(dimg);
        arMapLabel = new JLabel();
        arMapLabel.setIcon(imgIcon);
        mainMapPanel.add(arMapLabel);
        arMapLabel.setVisible(true);

        choice1.setText("North");
        choice2.setText("West");
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void kitchen() throws IOException {
        position = "Kitchen";
        mainTextArea.setText(com.alienation.coregamefiles.rooms.Kitchen.getStory());
//        playerHP = playerHP + 2;
//        hpLabelNumber.setText(""+playerHP);
        BufferedImage img = null;
        // TODO: Fix Image path. make it look like image viewer.
        String imgPath = "/com/alienation/resources/" + "Kitchen.png";
        img = ImageIO.read(getClass().getResource(imgPath));
        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(dimg);
        kMapLabel = new JLabel();
        kMapLabel.setIcon(imgIcon);
        mainMapPanel.add(kMapLabel);
        kMapLabel.setVisible(true);

        choice1.setText("West");
        choice2.setText("South");
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
//    public void east(){
//        position = "east";
//        mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
//        weapon = "Long Sword";
//        weaponLabelName.setText(weapon);
//        choice1.setText("Go west");
//        choice2.setText("");
//        choice3.setText("");
//        choice4.setText("");
//
//    }
//    public void west(){
//        position = "west";
//        mainTextArea.setText("You encounter a goblin!");
//        choice1.setText("Fight");
//        choice2.setText("Run");
//        choice3.setText("");
//        choice4.setText("");
//    }
//    public void fight(){
//        position = "fight";
//        mainTextArea.setText("Monter HP: " + monsterHP + "\n\nWhat do you do?");
//        choice1.setText("Attack");
//        choice2.setText("Run");
//        choice3.setText("");
//        choice4.setText("");
//    }
//    public void playerAttack(){
//        position = "playerAttack";
//
//        int playerDamage = 0;
//
//        if(weapon.equals("Knife")){
//            playerDamage = new java.util.Random().nextInt(3);
//        }
//        else if(weapon.equals("Long Sword")){
//            playerDamage = new java.util.Random().nextInt(12);
//        }
//
//        mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
//
//        monsterHP = monsterHP - playerDamage;
//
//        choice1.setText(">");
//        choice2.setText("");
//        choice3.setText("");
//        choice4.setText("");
//    }
//    public void monsterAttack(){
//        position = "monsterAttack";
//
//        int monsterDamage = 0;
//
//        monsterDamage = new java.util.Random().nextInt(6);
//
//        mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
//
//        playerHP = playerHP - monsterDamage;
//        hpLabelNumber.setText(""+playerHP);
//
//        choice1.setText(">");
//        choice2.setText("");
//        choice3.setText("");
//        choice4.setText("");
//    }
//    public void win(){
//        position = "win";
//
//        mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
//
//        silverRing = 1;
//
//        choice1.setText("Go east");
//        choice2.setText("");
//        choice3.setText("");
//        choice4.setText("");
//
//    }
//    public void lose(){
//        position = "lose";
//
//        mainTextArea.setText("You are dead!\n\n");
//
//        choice1.setText("");
//        choice2.setText("");
//        choice3.setText("");
//        choice4.setText("");
//        choice1.setVisible(false);
//        choice2.setVisible(false);
//        choice3.setVisible(false);
//        choice4.setVisible(false);
//    }
//    public void ending(){
//        position = "ending";
//
//        mainTextArea.setText("Guard: Oh you killed that goblin!?\nThank you so much. You are true hero!\nWelcome to our town!\n\n");
//
//        choice1.setText("");
//        choice2.setText("");
//        choice3.setText("");
//        choice4.setText("");
//        choice1.setVisible(false);
//        choice2.setVisible(false);
//        choice3.setVisible(false);
//        choice4.setVisible(false);
//    }



    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            try {
                createGameScreen();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch(position){
                case "CapsuleRoom":
                    switch(yourChoice){

                        case "c1":
                            try {
//                                MoveRoom.moveRoom("N", getCurrentRoom());
                                carMapLabel.setVisible(false);
                                supplyRoom();break;

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        case "c2":
                            try {
                                carMapLabel.setVisible(false);
                                controlRoom();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c3":
                            try {
                                carMapLabel.setVisible(false);
                                alienRoom();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                    break;
                case "SupplyRoom":
                    switch(yourChoice){
                        case "c1":
                            try {
                                srMapLabel.setVisible(false);
                                capsuleRoom();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c2":
                            try {
                                srMapLabel.setVisible(false);
                                kitchen();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                    break;
                case "Kitchen":
                    switch(yourChoice){
                        case "c1":
                            try {
                                kMapLabel.setVisible(false);
                                supplyRoom();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c2":
                            try {
                                kMapLabel.setVisible(false);
                                alienRoom();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                    break;
                case "AlienRoom":
                    switch(yourChoice){
                        case "c1":
                            try {
                                arMapLabel.setVisible(false);
                                kitchen();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c2":
                            try {
                                arMapLabel.setVisible(false);
                                capsuleRoom();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
//                        case "c3":
//                            try {
//                                cRoom();
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                            break;
//                        case "c4": west();break;
                    }
                    break;
                case "ControlRoom":
                    switch(yourChoice){
                        case "c1":
                            try {
                                corMapLabel.setVisible(false);
                                capsuleRoom();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                    break;
//                case "east":
//                    switch(yourChoice){
//                        case "c1": crossRoad(); break;
//                    }
//                    break;
//                case "west":
//                    switch(yourChoice){
//                        case "c1": fight(); break;
//                        case "c2": crossRoad(); break;
//                    }
//                    break;
//                case "fight":
//                    switch(yourChoice){
//                        case "c1": playerAttack();break;
//                        case "c2": crossRoad(); break;
//                    }
//                    break;
//                case "playerAttack":
//                    switch(yourChoice){
//                        case "c1":
//                            if(monsterHP<1){
//                                win();
//                            }
//                            else{
//                                monsterAttack();
//                            }
//                            break;
//                    }
//                    break;
//                case "monsterAttack":
//                    switch(yourChoice){
//                        case "c1":
//                            if(playerHP<1){
//                                lose();
//                            }
//                            else{
//                                fight();
//                            }
//                            break;
//                    }
//                    break;
//                case "win":
//                    switch(yourChoice){
//                        case "c1": crossRoad();
//                    }
//                    break;

            }


        }
    }



}