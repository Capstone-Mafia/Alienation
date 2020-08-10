package com.alienation.coregamefiles.gamefunctionclasses;

import com.alienation.coregamefiles.charactersetc.Alien;
import com.alienation.coregamefiles.enums.Rooms;
import com.alienation.coregamefiles.enums.Weapons;
import com.alienation.coregamefiles.gameart.Death;
import com.alienation.enginefiles.Game;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.alienation.coregamefiles.charactersetc.Player.*;
import static com.alienation.coregamefiles.charactersetc.Player.setInventory;
import static com.alienation.coregamefiles.gameart.TextColors.*;
import static com.alienation.coregamefiles.gamefunctionclasses.AlienAttackOrRun.alienAttackOrRun;
import static com.alienation.coregamefiles.gamefunctionclasses.Menu.displayMenu;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.getAvailableItemsMap;
import static com.alienation.coregamefiles.hashmaps.AvailableItemsHashMap.setAvailableItemsMap;

public class AlienAttack {

    private static int attackCount = 0;

    //Attacking the Alien and Alien will attack back to you

    public static void alienAttack(Rooms currentRoom, Alien alien){
        System.out.println(getAnsiRed() + "\nAttacking Alien..." + getAnsiReset());
        Game.secondTextArea.setText("Attacking Alien...");

        attackCount ++;
        try {
            if(getHealth() != 0) {
                int alienHealthPoints = alien.getHealthPoints();
                int alienDamagePoints = alien.getAlienDP();
                //int weaponDamagePoints = Player.getCurrentWeapon().getDamagePoints();
                /**
                 * Weapon's damage points are adjusted
                 */
                int newWeaponDamagePoints = alien.getNewWeaponDamagePoints(getCurrentWeapon());

                int alienNewHealthPoints = ((alienHealthPoints - newWeaponDamagePoints) < 0 ? 0 :
                        (alienHealthPoints - newWeaponDamagePoints));

                alien.setHealthPoints(alienNewHealthPoints);

                if (alienNewHealthPoints <= 0){
                    List<String> items = getAvailableItemsMap().get(currentRoom);
                    items.remove(alien.getAlienName());
                    setAvailableItemsMap(currentRoom, items);
                }

                System.out.println(getAnsiRed() + "\n-" + newWeaponDamagePoints + " dmg");
                Game.secondTextArea.setText("newWeaponDamagePoints + \" dmg\"");
                System.out.println(getAnsiBlue() + "\nAlien HP: " + getAnsiGreen() + alienNewHealthPoints +
                        getAnsiReset());
                Game.secondTextArea.setText("Alien HP: " + alienNewHealthPoints);
                TimeUnit.SECONDS.sleep(2);

                /**character newHealthPoints after Alien Attack, wrong
                 *
                 */
                if(alienNewHealthPoints > 0){
                    TimeUnit.SECONDS.sleep(2);

                    System.out.println(getAnsiRed() + "\nOops!! Alien attacked you back..." + getAnsiReset());
                    Game.secondTextArea.setText("\nOops!! Alien attacked you back...");
                    int characterFinalHealth =  ((getHealth() - alienDamagePoints) < 0 ? 0 :
                            (getHealth() - alienDamagePoints));


                    setHealth(characterFinalHealth);
                    System.out.println("\n-" + alienDamagePoints + " dmg" + getAnsiReset());
                    Game.secondTextArea.setText(alienDamagePoints + " dmg" );
                    System.out.println(getAnsiBlue() + "\nYour HP: " + getAnsiGreen() + getHealth() +
                            getAnsiReset());
                    Game.secondTextArea.setText("Your HP: " + getHealth());

                    if(getHealth() == 0){
                        Death.death();
                    }
                    else {
                        alienAttackOrRun(currentRoom, alien);
                    }
                }
                else{
                    //Remove from available items of room
                    List<String> availableItems = getAvailableItemsMap().get(currentRoom);

                    availableItems.remove(alien);
                    System.out.println(getAnsiRed() + "\nThe alien is fatally wounded and falls to it's death " +
                            "in a pool of blood." + getAnsiReset());
                    Game.secondTextArea.setText("\\nThe alien is fatally wounded and falls to it's death \" +\n" +
                            "                            \"in a pool of blood.");
                    System.out.println(getAnsiBlue() + "\nThe alien has dropped something." + getAnsiReset());
                    Game.secondTextArea.setText("\nThe alien has dropped something.");

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