package com.alienation.coregamefiles.charactersetc;

import com.alienation.coregamefiles.enums.Weapons;

public class AlienHumanoid extends Alien{
    public AlienHumanoid(int HP){
        super(HP);
    }
    public AlienHumanoid(){
        super(10);
    }

    public Weapons getWeapon(String name){

        return Weapons.valueOf(name);
    }

    @Override
    public String getAlienName() {
        return "AlienHumanoid";
    }

    @Override
    public static int getAlienDP() {
        return 5;
    }

    @Override
    public static int getNewWeaponDamagePoints(Weapons weapon) {
        return weapon.getDamagePoints()-1;
    }
}
