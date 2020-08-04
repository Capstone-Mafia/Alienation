package com.alienation.coregamefiles.charactersetc;

import com.alienation.coregamefiles.enums.Weapons;

public class AlienCanine extends Alien {
    public AlienCanine(int HP){
        super(HP);
    }
    public AlienCanine(){
        super(6);
    }

    public Weapons getWeapon(String name){

        return Weapons.valueOf(name);
    }

    @Override
    public String getAlienName() {
        return "AlienCanine";
    }

    @Override
    public int getAlienDP() {
        return 3;
    }

    @Override
    public int getNewWeaponDamagePoints(Weapons weapon) {
        return weapon.getDamagePoints()-1;
    }
}
