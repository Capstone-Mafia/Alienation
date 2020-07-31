package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Alien;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.enums.Weapons;
import com.alienation.coregamefiles.gameart.Death;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.alienation.coregamefiles.charactersetc.Player.*;
import static com.alienation.coregamefiles.charactersetc.Player.setInventory;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gameart.TextColors.ANSI_RESET;
import static com.alienation.coregamefiles.gamefunctionclasses.AlienAttackOrRun.alienAttackOrRun;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.displayMenu;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.setAvailableItemsMap;

public class AlienAttack {

    private static int attackCount = 0;

    //Attacking the Alien and Alien will attack back to you
    public static void alienAttack(Rooms currentRoom, String alienType){
        System.out.println(ANSI_RED + "\nAttacking Alien..." + ANSI_RESET);
        attackCount ++;
        try {
            if(getHealth() != 0) {
                int alienHealthPoints = Alien.getPoints(alienType,"HP");
                int alienDamagePoints = Alien.getPoints(alienType,"DP");
                int weaponDamagePoints = Weapons.findWeaponsByName(getCurrentWeapon()).getDamagePoints();
                int alienNewHealthPoints = ((alienHealthPoints - weaponDamagePoints) < 0 ? 0 : (alienHealthPoints - weaponDamagePoints));
                Alien.setPoints(alienType,"HP", alienNewHealthPoints);

                System.out.println(ANSI_RED + "\n-" + weaponDamagePoints + " dmg");
                System.out.println(ANSI_BLUE + "\nAlien HP: " + ANSI_GREEN + alienNewHealthPoints +
                        ANSI_RESET);
                TimeUnit.SECONDS.sleep(2);

                if(alienNewHealthPoints != 0){
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(ANSI_RED + "\nOops!! Alien attacked you back...");
                    int characterFinalHealth = -alienDamagePoints;
                    setHealth(characterFinalHealth);
                    System.out.println("\n-" + alienDamagePoints + " dmg" + ANSI_RESET);
                    System.out.println(ANSI_BLUE + "\nYour HP: " + ANSI_GREEN + getHealth() +
                            ANSI_RESET);

                    if(getHealth() == 0){
                        Death.death();
                    }
                    else {
                        alienAttackOrRun(currentRoom, alienType);
                    }
                }
                else{
                    //Remove from available items of room
                    List<String> availableItems = getAvailableItemsMap().get(currentRoom);
                    availableItems.remove(alienType);
                    System.out.println(ANSI_RED + "\nThe alien is fatally wounded and falls to it's death " +
                            "in a pool of blood." + ANSI_RESET);
                    System.out.println(ANSI_BLUE + "\nThe alien has dropped something." + ANSI_RESET);
                    List<String> inventory = getInventory();
                    inventory.add("Code");
                    setInventory(inventory);
                    setAvailableItemsMap(currentRoom, availableItems);
                    displayMenu();
                }
            }
            else {
                Death.death();
            }
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getAttackCount() {
        return attackCount;
    }

    public static void setAttackCount(int attackCount) {
        AlienAttack.attackCount = attackCount;
    }
}
