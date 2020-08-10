package com.alienation.enginefiles;

import com.alienation.coregamefiles.charactersetc.Oxygen;
import com.alienation.coregamefiles.charactersetc.Player;
import com.alienation.coregamefiles.gamefunctionclasses.Menu;
import com.alienation.coregamefiles.gamefunctionclasses.MoveRoom;
import com.alienation.coregamefiles.rooms.CapsuleRoom;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.alienation.coregamefiles.charactersetc.Player.getCurrentRoom;
import static com.alienation.coregamefiles.rooms.CapsuleRoom.getStory;

public class Game {

    public static JFrame window;
    static JPanel secondTextpanel;
    static JPanel textInputPanel;
    static JPanel inventoryButtonPanel;
    static JPanel titleNamePanel;
    static JPanel infoPanel;
    static JPanel mainMapPanel;
    static JPanel startButtonPanel;
    static JPanel mainTextPanel;
    static JPanel choiceButtonPanel;
    static JLabel oxyLabel, oxyLabelName, titleNameLabel, carMapLabel, corMapLabel, arMapLabel, srMapLabel, kMapLabel, mainMapLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    static Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    static Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    static JButton okButton, inv, startButton, choice1, choice2, choice3, choice4;
    public static JTextArea mainTextArea, secondTextArea;

    static JTextField textInputField;
    public static String position, input;

    static TitleScreenHandler tsHandler = new TitleScreenHandler();
    static ChoiceHandler choiceHandler = new ChoiceHandler();



//    public static void main(String[] args) {
//
//        new Game();
//    }

    public Game(){

        //Main Game window
        window = new JFrame();
        window.setSize(810, 600);
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
        infoPanel.setLayout(new GridLayout(1,6));

        hpLabel = new JLabel("HP:");
//        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        infoPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
//        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        infoPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon:");
//        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        infoPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
//        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        infoPanel.add(weaponLabelName);

        oxyLabel = new JLabel("Oxygen:");
        oxyLabel.setForeground(Color.white);
        infoPanel.add(oxyLabel);
        oxyLabelName = new JLabel();
        oxyLabelName.setForeground(Color.white);
        infoPanel.add(oxyLabelName);

        weaponLabelName.setText(String.valueOf(Player.getCurrentWeapon()));
        hpLabelNumber.setText(Integer.toString(Player.getHealth()));
        oxyLabelName.setText(String.valueOf(Oxygen.getOxygen()));

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

    public static void createGameScreen() throws Exception {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
//        infoPanel.setVisible(false);

        //Map Pannel
        mainMapPanel = new JPanel();
        mainMapPanel.setBounds(0, 50, 400, 350);
        mainMapPanel.setBackground(Color.black);
        window.add(mainMapPanel);


        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(400, 50, 400, 175);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);


        // Adding text field to text panel.
        mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
        mainTextArea.setBounds(400, 50, 380, 170);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
//        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // Second text panel
        secondTextpanel = new JPanel();
        secondTextpanel.setBounds(400,250, 400, 150);
        secondTextpanel.setBackground(Color.black);
        window.add(secondTextpanel);

        //Second text area
        secondTextArea = new JTextArea("This is the secondary text area.");
        secondTextArea.setBounds(400, 250, 380, 150);
        secondTextArea.setBackground(Color.black);
        secondTextArea.setForeground(Color.white);
//        mainTextArea.setFont(normalFont);
        secondTextArea.setLineWrap(true);
        secondTextpanel.add(secondTextArea);

        // Setting up text input panel.
        textInputPanel = new JPanel();
        textInputPanel.setBounds(0,450,400,50);
        textInputPanel.setBackground(Color.blue);
        textInputPanel.setLayout(new GridLayout(1, 2));
        window.add(textInputPanel);

        //Adding text input field to the panel
        textInputField = new JTextField();
        textInputField.setPreferredSize(new Dimension(200,50));
        textInputPanel.add(textInputField);
        textInputField.setVisible(true);


        okButton = new JButton("OK");
        okButton.setBackground(Color.black);
        okButton.setForeground(Color.white);
        okButton.setFont(normalFont);
        okButton.setFocusPainted(false);
        okButton.addActionListener(choiceHandler);
        okButton.setActionCommand("ok");
        textInputPanel.add(okButton);



        // Create direction button panel.
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(0, 500, 600, 50);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(1, 4));
        window.add(choiceButtonPanel);

        // Button properties.
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

        // Create Inventory button panel.
        inventoryButtonPanel = new JPanel();
        inventoryButtonPanel.setBounds(600, 500, 150, 50);
        inventoryButtonPanel.setBackground(Color.black);
//        inventoryButtonPanel.setLayout(new GridLayout(1, 4));
        window.add(inventoryButtonPanel);

        inv = new JButton("Inventory");
        inv.setBackground(Color.black);
        inv.setForeground(Color.white);
        inv.setFont(normalFont);
        inv.setFocusPainted(false);
        inv.addActionListener(choiceHandler);
        inv.setActionCommand("inv");
        inventoryButtonPanel.add(inv);

        new CapsuleRoom().loadEnvironment();
        mainTextArea.setText(CapsuleRoom.getStory());
        capsuleRoom();

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
    public static void capsuleRoom() throws Exception {
        position = "CapsuleRoom";
        // Map Label
        BufferedImage img = null;
        // TODO: Fix Image path. make it look like image viewer.
        String imgPath = "/com/alienation/resources/" + "CapsuleRoom.png";
        img = ImageIO.read(Game.class.getResource(imgPath));
        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(dimg);
        carMapLabel = new JLabel();
        carMapLabel.setIcon(imgIcon);
        mainMapPanel.add(carMapLabel);
        mainTextArea.setText(getStory());
        secondTextArea.setText(Menu.getActionQuestion() + "\n\n" + Menu.getActions() + "\n");

        choice1.setText("North");
        choice2.setText("South");
        choice3.setText("East");
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(true);
        choice4.setVisible(false);
        inv.setVisible(true);
        okButton.setVisible(true);
        textInputField.setVisible(true);
    }


    public static void supplyRoom() throws Exception {

//        new SupplyRoom().loadEnvironment();
        position = "SupplyRoom";
        mainTextArea.setText(com.alienation.coregamefiles.rooms.SupplyRoom.getStory());
        BufferedImage img = null;
        // TODO: Fix Image path. make it look like image viewer.
        String imgPath = "/com/alienation/resources/" + "SupplyRoom.png";
        img = ImageIO.read(Game.class.getResource(imgPath));
        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(dimg);
        srMapLabel = new JLabel();
        srMapLabel.setIcon(imgIcon);
        mainMapPanel.add(srMapLabel);
        srMapLabel.setVisible(true);
//        mainTextArea.setText(com.alienation.coregamefiles.rooms.SupplyRoom.getStory());
        secondTextArea.setText(Menu.getActionQuestion() + "\n\n" + Menu.getActions() + "\n");
        okButton.setVisible(true);
        textInputField.setVisible(true);

        choice1.setText("South");
        choice2.setText("East");
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(false);
        choice4.setVisible(false);
        inv.setVisible(true);
        okButton.setVisible(true);
        textInputField.setVisible(true);
    }


    public static void controlRoom() throws IOException {
        position = "ControlRoom";
        mainTextArea.setText(com.alienation.coregamefiles.rooms.ControlRoom.getStory());
        // Map Label
        BufferedImage img = null;
        // TODO: Fix Image path. make it look like image viewer.
        String imgPath = "/com/alienation/resources/" + "ControlRoom.png";
        img = ImageIO.read(Game.class.getResource(imgPath));
        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(dimg);
        corMapLabel = new JLabel();
        corMapLabel.setIcon(imgIcon);
        mainMapPanel.add(corMapLabel);
        corMapLabel.setVisible(true);
        secondTextArea.setText(Menu.getActionQuestion() + "\n\n" + Menu.getActions() + "\n");
        okButton.setVisible(true);
        textInputField.setVisible(true);

        choice1.setText("North");
        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
        inv.setVisible(true);
        okButton.setVisible(true);
        textInputField.setVisible(true);
    }


    public static void alienRoom() throws IOException {
        position = "AlienRoom";
        mainTextArea.setText(com.alienation.coregamefiles.rooms.AlienRoom.getStory());
        BufferedImage img = null;
        // TODO: Fix Image path. make it look like image viewer.
        String imgPath = "/com/alienation/resources/" + "AlienRoom.png";
        img = ImageIO.read(Game.class.getResource(imgPath));
        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(dimg);
        arMapLabel = new JLabel();
        arMapLabel.setIcon(imgIcon);
        mainMapPanel.add(arMapLabel);
        arMapLabel.setVisible(true);
        secondTextArea.setText(Menu.getActionQuestion() + "\n\n" + Menu.getActions() + "\n");
        okButton.setVisible(true);
        textInputField.setVisible(true);

        choice1.setText("North");
        choice2.setText("West");
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(false);
        choice4.setVisible(false);
        inv.setVisible(true);
        okButton.setVisible(true);
        textInputField.setVisible(true);
    }


    public static void kitchen() throws IOException {
        position = "Kitchen";
        mainTextArea.setText(com.alienation.coregamefiles.rooms.Kitchen.getStory());
        BufferedImage img = null;
        // TODO: Fix Image path. make it look like image viewer.
        String imgPath = "/com/alienation/resources/" + "Kitchen.png";
        img = ImageIO.read(Game.class.getResource(imgPath));
        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(dimg);
        kMapLabel = new JLabel();
        kMapLabel.setIcon(imgIcon);
        mainMapPanel.add(kMapLabel);
        kMapLabel.setVisible(true);
        secondTextArea.setText(Menu.getActionQuestion() + "\n\n" + Menu.getActions() + "\n");
        okButton.setVisible(true);
        textInputField.setVisible(true);

        choice1.setText("West");
        choice2.setText("South");
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(false);
        choice4.setVisible(false);
        inv.setVisible(true);
        okButton.setVisible(true);
        textInputField.setVisible(true);
    }


    public static class TitleScreenHandler implements ActionListener{

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
    public static class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch(position){
                case "CapsuleRoom":
                    switch(yourChoice){

                        case "c1":
                            try {
                                carMapLabel.setVisible(false);
//                                mainTextArea.setText(com.alienation.coregamefiles.rooms.SupplyRoom.getStory());

                                //Todo: add move room to other room(cases).
                                MoveRoom.moveRoom("N", getCurrentRoom());
                                System.out.println("Test for room location from game engine capsuleroom switch statement " + getCurrentRoom());
                                supplyRoom();
                                break;

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        case "c2":
                            try {
                                carMapLabel.setVisible(false);
                                MoveRoom.moveRoom("S", getCurrentRoom());
                                System.out.println("Test for room location from game engine capsuleroom switch statement " + getCurrentRoom());
                                controlRoom();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c3":
                            try {
                                carMapLabel.setVisible(false);
                                MoveRoom.moveRoom("E", getCurrentRoom());
                                System.out.println("Test for room location from game engine capsuleroom switch statement " + getCurrentRoom());
                                alienRoom();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "inv":
                            try {
                                String delim = "-";
                                String res = String.join(delim, Player.getInventory());
                                secondTextArea.setText("Items in the room: " + res);
//                                CheckInventory.checkInventory();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "ok":
                            input = textInputField.getText();

                            try {
                                Menu.displayMenu();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;

                    }
                    break;

                case "SupplyRoom":
                    switch(yourChoice){
                        case "c1":

                            srMapLabel.setVisible(false);
//                            mainTextArea.setText(com.alienation.coregamefiles.rooms.CapsuleRoom.getStory());
                            try {
                                MoveRoom.moveRoom("S", getCurrentRoom());
                                System.out.println("Test for room location from game engine Supplyroom switch statement " + getCurrentRoom());
                                capsuleRoom();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c2":

//                            mainTextArea.setText(com.alienation.coregamefiles.rooms.Kitchen.getStory());
                            try {
                                srMapLabel.setVisible(false);
                                MoveRoom.moveRoom("E", getCurrentRoom());
                                System.out.println("Test for room location from game engine Supplyroom switch statement " + getCurrentRoom());
                                kitchen();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;

                        case "inv":
                            try {
                                String delim = "-";
                                String res = String.join(delim, Player.getInventory());
                                secondTextArea.setText(res);
//                                CheckInventory.checkInventory();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;

                        case "ok":
                            input = textInputField.getText();
                            try {
                                Menu.displayMenu();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                    }
                    break;

                case "Kitchen":
                    switch(yourChoice){
                        case "c1":
//                            mainTextArea.setText(com.alienation.coregamefiles.rooms.SupplyRoom.getStory());
                            try {
                                kMapLabel.setVisible(false);
                                MoveRoom.moveRoom("W", getCurrentRoom());
                                supplyRoom();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c2":
//                            mainTextArea.setText(com.alienation.coregamefiles.rooms.AlienRoom.getStory());
                            try {
                                kMapLabel.setVisible(false);
                                MoveRoom.moveRoom("S", getCurrentRoom());
                                alienRoom();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        case "inv":
                            try {
                                String delim = "-";
                                String res = String.join(delim, Player.getInventory());
                                secondTextArea.setText(res);
//                                CheckInventory.checkInventory();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;

                        case "ok":
                            input = textInputField.getText();
                            try {
                                Menu.displayMenu();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                    }
                    break;
                case "AlienRoom":
                    switch(yourChoice){
                        case "c1":
//                            mainTextArea.setText(com.alienation.coregamefiles.rooms.Kitchen.getStory());
                            try {
                                arMapLabel.setVisible(false);
                                MoveRoom.moveRoom("N", getCurrentRoom());
                                kitchen();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c2":
//                            mainTextArea.setText(com.alienation.coregamefiles.rooms.CapsuleRoom.getStory());
                            try {
                                arMapLabel.setVisible(false);
                                MoveRoom.moveRoom("W", getCurrentRoom());
                                capsuleRoom();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                       case "inv":
                            try {
                                String delim = "-";
                                String res = String.join(delim, Player.getInventory());
                                secondTextArea.setText(res);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;

                        case "ok":
                            input = textInputField.getText();
                            try {
                                Menu.displayMenu();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                    }
                    break;
                case "ControlRoom":
                    switch(yourChoice){
                        case "c1":
//                            mainTextArea.setText(com.alienation.coregamefiles.rooms.CapsuleRoom.getStory());
                            try {
                                corMapLabel.setVisible(false);
                                MoveRoom.moveRoom("N", getCurrentRoom());
                                capsuleRoom();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        case "inv":
                            try {
                                String delim = "-";
                                String res = String.join(delim, Player.getInventory());
                                secondTextArea.setText(res);
//                                CheckInventory.checkInventory();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;

                        case "ok":
                            input = textInputField.getText();
                            try {
                                Menu.displayMenu();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                    break;
            }
        }
    }
}