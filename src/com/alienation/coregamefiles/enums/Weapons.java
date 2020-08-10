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

package com.alienation.coregamefiles.enums;

import com.alienation.coregamefiles.charactersetc.Alien;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Weapons Enum
 */
public enum Weapons{

    TASER_GUN("taser gun", 1),
    LASER("laser", 3),
    SQUIRT_GUN("squirt gun", 4),
    FLAMETHROWER("flamethrower", 8);
     /**
    Set<String> weaponsSet = new HashSet<>();
    weaponsSet.add("Taser Gun");
     */

    private final String name;
    private int damagePoints;

    Weapons(String name, int damagePoints){
        this.damagePoints = damagePoints;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getDamagePoints() {
        return damagePoints;
    }

    /* This will maybe change the damage points of each weapon over time
     * if we want to add that feature
     */
    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public static Weapons findWeaponsByName(String name) throws Exception {
        return Arrays.stream(Weapons.values()).filter(v ->
                v.getName().equals(name)).findFirst().orElseThrow(() ->
                new Exception(String.format("Unknown Weapons.name: '%s'", name)));

    }
}
