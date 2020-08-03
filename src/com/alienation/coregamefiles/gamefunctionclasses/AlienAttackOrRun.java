package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Alien;
import com.alienation.coregamefiles.enums.Actions;
import com.alienation.coregamefiles.enums.Rooms;

import static com.alienation.coregamefiles.enums.Actions.*;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gameart.TextColors.ANSI_RESET;
import static com.alienation.coregamefiles.gamefunctionclasses.AlienAttack.alienAttack;
import static com.alienation.coregamefiles.gamefunctionclasses.EatItems.eat;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.*;
import static com.alienation.coregamefiles.gamefunctionclasses.RunAway.run;
import static com.alienation.coregamefiles.gamefunctionclasses.SwapWeapons.swap;

public class AlienAttackOrRun {

    // AttackAlien or Run from Alien in the room to previous room
    public static void alienAttackOrRun(Rooms currentRoom, Alien alienType) {
        System.out.println(ANSI_YELLOW + "\nWhat do you want to do?" + ANSI_RESET);

        boolean repeat = true;
        while (repeat) {
            try {
                Input.getInput();
                String input = Input.getActionInput();
                setAction(Actions.valueOf(input.toUpperCase()));

                switch (getAction()) {
                    case FIGHT:
                    case ATTACK:
                        repeat = false;
                        alienAttack(currentRoom, alienType);
                        break;
                    case RUN:
                    case FLEE:
                        repeat = false;
                        run(currentRoom);
                        break;
                    case EAT:
                        repeat = false;
                        eat(currentRoom);
                    case SWAP:
                    case EQUIP:
                        repeat = false;
                        swap(currentRoom);
                        break;
                    default:
                        System.out.println("You must enter one of the following actions: ATTACK, RUN, FIGHT, FLEE, EAT, SWAP, EQUIP");
                        repeat = true;
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(ANSI_RED + "\nCan't do that!" + ANSI_RESET);
                repeat = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
