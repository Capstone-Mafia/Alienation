package com.alienation.coregamefiles;

import com.alienation.coregamefiles.charactersetc.Player;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.gamefunctionclasses.MoveRoom;
import junit.framework.TestCase;

public class MoveTest extends TestCase {

        public void setUp() throws Exception {
            super.setUp();
        }

        public void testMove() throws Exception {
            assertEquals(Rooms.SupplyRoom, MoveRoom.getNextRoom("N", Rooms.CapsuleRoom));
        }
}
