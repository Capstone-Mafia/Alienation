package com.alienation.enginefiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.alienation.coregamefiles.charactersetc.Oxygen;
import com.alienation.coregamefiles.charactersetc.Player;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.gameart.Banner;
import com.alienation.coregamefiles.gamefunctionclasses.ImageViewer;
import com.alienation.coregamefiles.gamefunctionclasses.Menu;
import com.alienation.coregamefiles.rooms.CapsuleRoom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.alienation.coregamefiles.gamefunctionclasses.LoadRoom.loadRoom;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.*;
import static java.lang.System.getProperty;

public class Game {

    JFrame window;
//    Container con;
    JPanel titleNamePanel, infoPanel, mainMapPanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, mainMapLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
//    ChoiceHandler choiceHandler = new ChoiceHandler();



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

    public void createGameScreen() throws IOException {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
//        infoPanel.setVisible(false);

        //Map Pannel
        mainMapPanel = new JPanel();
        mainMapPanel.setBounds(0, 50, 400, 350);
        mainMapPanel.setBackground(Color.GREEN);
        window.add(mainMapPanel);

        // Map Label
        BufferedImage img = null;
        // TODO: Fix Image path. make it look like image viewer.
        String imgPath = "/com/alienation/resources/" + "CapsuleRoom.png";
        img = ImageIO.read(getClass().getResource(imgPath));
        Image dimg = img.getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(dimg);
        mainMapLabel = new JLabel();
        mainMapLabel.setIcon(imgIcon);
        mainMapPanel.add(mainMapLabel);


        //Main text panel.
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(400, 50, 400, 350);
        mainTextPanel.setBackground(Color.cyan);
        window.add(mainTextPanel);
//        window.pack();

        // Adding text field to test panel.
        mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
        mainTextArea.setBounds(400, 50, 400, 350);
        mainTextArea.setBackground(Color.cyan);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);


        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));

    }

    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            try {
                createGameScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
