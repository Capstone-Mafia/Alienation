package com.alienation.coregamefiles.charactersetc;

import com.alienation.coregamefiles.enums.Weapons;

public class AlienSuperhumanoid extends Alien{
    /**
    alienPointWorth = new HashMap<>();
            alienPointWorth.put("HP", 50);
            alienPointWorth.put("DP", 10);
     */


    public AlienSuperhumanoid(int HP){
        super(HP);
    }
    public AlienSuperhumanoid(){
        super(50);
    }

    public Weapons getWeapon(String name){

        return Weapons.valueOf(name);
    }

    @Override
    public String getAlienName() {
        return "AlienSuperhumanoid";
    }

    @Override
    public int getAlienDP() {
        return 10;
    }

    @Override
    public int getNewWeaponDamagePoints(Weapons weapon) {
       return weapon.getDamagePoints()-1;
    }

    /**
    public void setWeapon(String name){

        for (Weapons weapon : Weapons.values()){
            weapon.setDamagePoints(weapon.getDamagePoints()-1);
        }
     */


}
