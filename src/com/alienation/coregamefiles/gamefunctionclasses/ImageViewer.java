package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.enums.Rooms;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.alienation.coregamefiles.gamefunctionclasses.Menu.displayMenu;

public class ImageViewer {

    public static void viewer(Rooms currentRoom) throws Exception{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Ship Blueprints");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                BufferedImage img = null;
                try {
                    String imgPath = "/com/alienation/resources/" + currentRoom  + ".png";
                    img = ImageIO.read(getClass().getResource(imgPath));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }

                ImageIcon imgIcon = new ImageIcon(img);
                JLabel lbl = new JLabel();
                lbl.setIcon(imgIcon);
                frame.getContentPane().add(lbl, BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        displayMenu();
    }
}
