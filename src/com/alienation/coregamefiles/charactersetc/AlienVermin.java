package com.alienation.coregamefiles.charactersetc;

import com.alienation.coregamefiles.enums.Weapons;

public class AlienVermin extends Alien{
    public AlienVermin(int HP){
        super(HP);
    }
    public AlienVermin(){
        super(4);
    }

    public Weapons getWeapon(String name){

        return Weapons.valueOf(name);
    }

    @Override
    public String getAlienName() {
        return "Vermin";
    }

    @Override
    public int getAlienDP() {
        return 1;
    }

    @Override
    public int getNewWeaponDamagePoints(Weapons weapon) {
        return weapon.getDamagePoints()-1;
    }
}
