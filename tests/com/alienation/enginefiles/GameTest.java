package com.alienation.enginefiles;

import junit.framework.TestCase;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameTest extends TestCase {

    Game game = new Game();

    @Test
    public void testCapsuleRoom() throws IOException {
        BufferedImage img;
        String imagePath = "/com/alienation/resources/CapsuleRoom.png";
        img = ImageIO.read(getClass().getResource(imagePath));
        assertNotNull(img);

    }
}